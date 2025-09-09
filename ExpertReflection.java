import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class ExpertReflection {
    public static void main(String[] args) throws Exception {
        testObjectMapper();
        testJsonGenerator();
        testDynamicProxy();
        testDependencyInjection();
        testMethodTiming();
    }
    
    static void testObjectMapper() throws Exception {
        Map<String, Object> props = new HashMap<>();
        props.put("name", "Alice");
        props.put("age", 25);
        
        Person person = ObjectMapper.toObject(Person.class, props);
        System.out.println("Mapped Person: " + person);
    }
    
    static void testJsonGenerator() throws Exception {
        Person person = new Person();
        person.name = "Bob";
        person.age = 30;
        
        String json = JsonGenerator.toJson(person);
        System.out.println("JSON: " + json);
    }
    
    static void testDynamicProxy() {
        Greeting greeting = LoggingProxy.create(new GreetingImpl());
        greeting.sayHello("World");
        greeting.sayGoodbye("World");
    }
    
    static void testDependencyInjection() throws Exception {
        DIContainer container = new DIContainer();
        container.register(DatabaseService.class, new DatabaseService());
        
        UserService userService = container.getInstance(UserService.class);
        userService.performAction();
    }
    
    static void testMethodTiming() throws Exception {
        Calculator calc = new Calculator();
        MethodTimer.measureMethods(calc);
    }
}

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = properties.get(field.getName());
            if (value != null) {
                field.set(instance, value);
            }
        }
        return instance;
    }
}

class JsonGenerator {
    public static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            Object value = field.get(obj);
            
            json.append("\"").append(field.getName()).append("\":");
            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }
            
            if (i < fields.length - 1) json.append(",");
        }
        
        json.append("}");
        return json.toString();
    }
}

interface Greeting {
    void sayHello(String name);
    void sayGoodbye(String name);
}

class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
    
    public void sayGoodbye(String name) {
        System.out.println("Goodbye, " + name + "!");
    }
}

class LoggingProxy {
    @SuppressWarnings("unchecked")
    public static <T> T create(T target) {
        return (T) Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("Logging: Calling method " + method.getName());
                    return method.invoke(target, args);
                }
            }
        );
    }
}

class DIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();
    
    public <T> void register(Class<T> clazz, T instance) {
        instances.put(clazz, instance);
    }
    
    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> clazz) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = instances.get(field.getType());
                field.set(instance, dependency);
            }
        }
        return instance;
    }
}

class DatabaseService {
    public void connect() {
        System.out.println("Connected to database");
    }
}

class UserService {
    @Inject
    private DatabaseService dbService;
    
    public void performAction() {
        dbService.connect();
        System.out.println("User service action performed");
    }
}

class MethodTimer {
    public static void measureMethods(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.getParameterCount() == 0) {
                method.setAccessible(true);
                
                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();
                
                System.out.println("Method " + method.getName() + " took " + (end - start) / 1_000_000.0 + " ms");
            }
        }
    }
}

class Person {
    public String name;
    public int age;
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class Calculator {
    public void fastMethod() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
    }
    
    public void slowMethod() throws InterruptedException {
        Thread.sleep(100);
    }
}