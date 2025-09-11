import java.util.*;
import java.util.stream.Collectors;

public class EmployeeSalary {
    record Employee(String name, String department, double salary) {}
    
    static List<Employee> employees = List.of(
        new Employee("John Doe", "Engineering", 85000),
        new Employee("Jane Smith", "Marketing", 65000),
        new Employee("Bob Johnson", "Engineering", 90000),
        new Employee("Alice Brown", "HR", 55000),
        new Employee("Carol White", "Marketing", 70000),
        new Employee("David Lee", "Finance", 75000),
        new Employee("Emma Wilson", "Engineering", 95000),
        new Employee("Frank Miller", "HR", 60000),
        new Employee("Grace Taylor", "Finance", 80000),
        new Employee("Henry Davis", "Marketing", 68000)
    );
    
    public static void main(String[] args) {
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
        
        avgSalaryByDept.forEach((dept, avg) -> System.out.println(dept + ": $" + String.format("%.2f", avg)));
    }
}