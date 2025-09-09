import java.lang.reflect.*;
import java.util.Scanner;

class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = sc.nextLine();
        
        Class<?> clazz = Class.forName(className);
        System.out.println("Class: " + clazz.getName());
        
        System.out.println("\nConstructors:");
        for(Constructor<?> c : clazz.getDeclaredConstructors()) {
            System.out.println(c);
        }
        
        System.out.println("\nFields:");
        for(Field f : clazz.getDeclaredFields()) {
            System.out.println(f);
        }
        
        System.out.println("\nMethods:");
        for(Method m : clazz.getDeclaredMethods()) {
            System.out.println(m);
        }
    }
}

class Person {
    private int age = 25;
    
    public void testReflection() throws Exception {
        Class<?> clazz = this.getClass();
        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        
        System.out.println("Original age: " + ageField.get(this));
        ageField.set(this, 30);
        System.out.println("Modified age: " + ageField.get(this));
    }
}

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
    
    public void testReflection() throws Exception {
        Class<?> clazz = this.getClass();
        Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);
        
        int result = (int) multiplyMethod.invoke(this, 5, 3);
        System.out.println("Result: " + result);
    }
}

class Student {
    private String name;
    private int rollNo;
    
    public Student() {
        this.name = "Default";
        this.rollNo = 0;
    }
    
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', rollNo=" + rollNo + "}";
    }
    
    public static void createDynamically() throws Exception {
        Class<?> clazz = Class.forName("Student");
        
        Object obj1 = clazz.getDeclaredConstructor().newInstance();
        System.out.println("Default: " + obj1);
        
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        Object obj2 = constructor.newInstance("John", 101);
        System.out.println("Parameterized: " + obj2);
    }
}