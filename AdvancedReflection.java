import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

class AdvancedReflection {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        MathOperations math = new MathOperations();
        Class<?> clazz = math.getClass();
        
        System.out.print("Enter method name (add/subtract/multiply): ");
        String methodName = sc.nextLine();
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        Method method = clazz.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(math, a, b);
        System.out.println("Result: " + result);
        
        TestAnnotation.displayAuthor();
        Configuration.testStaticField();
    }
}

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
}

@Author(name="John Doe")
class TestAnnotation {
    public static void displayAuthor() {
        Class<?> clazz = TestAnnotation.class;
        Author annotation = clazz.getAnnotation(Author.class);
        if (annotation != null) {
            System.out.println("Author: " + annotation.name());
        }
    }
}

class Configuration {
    private static String API_KEY = "default_key";
    
    public static void testStaticField() throws Exception {
        Class<?> clazz = Configuration.class;
        Field field = clazz.getDeclaredField("API_KEY");
        field.setAccessible(true);
        
        System.out.println("Original API_KEY: " + field.get(null));
        field.set(null, "new_secret_key_123");
        System.out.println("Modified API_KEY: " + field.get(null));
    }
}