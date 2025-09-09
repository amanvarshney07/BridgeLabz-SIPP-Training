import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name() default "";
}

class User {
    @JsonField(name = "user_name")
    private String username;
    
    @JsonField(name = "user_age")
    private int age;
    
    @JsonField(name = "email_address")
    private String email;
    
    @JsonField(name = "is_active")
    private boolean active;
    
    private String password;
    
    public User(String username, int age, String email, boolean active, String password) {
        this.username = username;
        this.age = age;
        this.email = email;
        this.active = active;
        this.password = password;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder json = new StringBuilder("{");
        boolean first = true;
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                Object value = field.get(obj);
                
                if (!first) {
                    json.append(",");
                }
                first = false;
                
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name().isEmpty() ? field.getName() : annotation.name();
                
                json.append("\"").append(jsonKey).append("\":");
                
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else if (value instanceof Boolean) {
                    json.append(value.toString().toLowerCase());
                } else {
                    json.append(value);
                }
            }
        }
        
        json.append("}");
        return json.toString();
    }
    
    public static void displaySerializableFields(Class<?> clazz) {
        System.out.println("Serializable fields in " + clazz.getSimpleName() + ":");
        System.out.println("==========================================");
        
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name().isEmpty() ? field.getName() : annotation.name();
                System.out.println("Field: " + field.getName() + " → JSON Key: " + jsonKey);
            } else {
                System.out.println("Field: " + field.getName() + " → Not serialized");
            }
        }
        System.out.println();
    }
}

class JsonFieldDemo {
    public static void main(String[] args) throws Exception {
        User user = new User("john_doe", 25, "john@example.com", true, "secret123");
        
        JsonSerializer.displaySerializableFields(User.class);
        
        String jsonString = JsonSerializer.toJson(user);
        System.out.println("Serialized JSON:");
        System.out.println(jsonString);
        
        System.out.println("\nFormatted JSON:");
        System.out.println(formatJson(jsonString));
    }
    
    static String formatJson(String json) {
        return json.replace(",", ",\n  ")
                  .replace("{", "{\n  ")
                  .replace("}", "\n}");
    }
}