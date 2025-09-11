import java.util.*;
import java.util.stream.Collectors;

public class NameUppercasing {
    record Employee(String name, String department, String role) {}
    
    static List<Employee> employees = List.of(
        new Employee("john doe", "Engineering", "Developer"),
        new Employee("jane smith", "Marketing", "Manager"),
        new Employee("bob johnson", "Finance", "Analyst"),
        new Employee("alice brown", "HR", "Recruiter"),
        new Employee("carol white", "Sales", "Representative")
    );
    
    public static void main(String[] args) {
        System.out.println("UPPERCASE NAMES:");
        employees.stream().map(Employee::name).map(String::toUpperCase).forEach(System.out::println);
        
        System.out.println("\nHR LETTER FORMAT:");
        employees.stream().map(Employee::name).map(String::toUpperCase).forEach(name -> System.out.println("Dear " + name + ","));
        
        System.out.println("\nCOLLECTED UPPERCASE:");
        System.out.println(employees.stream().map(Employee::name).map(String::toUpperCase).collect(Collectors.toList()));
        
        System.out.println("\nJOINED FOR DOCUMENT:");
        System.out.println(employees.stream().map(Employee::name).map(String::toUpperCase).collect(Collectors.joining(", ")));
        
        System.out.println("\nDEPARTMENT SPECIFIC (Engineering):");
        employees.stream().filter(e -> "Engineering".equals(e.department())).map(Employee::name).map(String::toUpperCase).forEach(System.out::println);
    }
}