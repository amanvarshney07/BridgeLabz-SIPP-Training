import java.util.*;
import java.util.stream.Collectors;

public class StudentGrouping {
    record Student(String name, String grade) {}
    
    static List<Student> students = List.of(
        new Student("John Doe", "10th"),
        new Student("Jane Smith", "12th"),
        new Student("Bob Johnson", "11th"),
        new Student("Alice Brown", "10th"),
        new Student("Carol White", "12th"),
        new Student("David Lee", "9th"),
        new Student("Emma Wilson", "11th"),
        new Student("Frank Miller", "9th"),
        new Student("Grace Taylor", "10th"),
        new Student("Henry Davis", "12th")
    );
    
    public static void main(String[] args) {
        students.stream()
            .collect(Collectors.groupingBy(Student::grade, Collectors.mapping(Student::name, Collectors.toList())))
            .forEach((grade, names) -> System.out.println(grade + ": " + names));
    }
}