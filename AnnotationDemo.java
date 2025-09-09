import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class BusinessService {
    @ImportantMethod
    public void processPayment() {
        System.out.println("Processing payment...");
    }
    
    @ImportantMethod(level = "CRITICAL")
    public void handleSecurityBreach() {
        System.out.println("Handling security breach...");
    }
    
    @ImportantMethod(level = "MEDIUM")
    public void generateReport() {
        System.out.println("Generating report...");
    }
    
    public void regularMethod() {
        System.out.println("Regular method without annotation...");
    }
}

class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = BusinessService.class;
        Method[] methods = clazz.getDeclaredMethods();
        
        System.out.println("Important Methods Found:");
        System.out.println("========================");
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + 
                                 " | Importance Level: " + annotation.level());
            }
        }
        
        System.out.println("\nExecuting annotated methods:");
        System.out.println("============================");
        
        BusinessService service = new BusinessService();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                method.invoke(service);
            }
        }
    }
}