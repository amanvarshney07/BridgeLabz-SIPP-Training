import java.util.*;
import java.util.stream.Collectors;

public class PatientIDPrinting {
    record Patient(String id, String name, int age, String department) {}
    
    static List<Patient> patients = List.of(
        new Patient("P001", "John Doe", 45, "Cardiology"),
        new Patient("P002", "Jane Smith", 32, "Neurology"),
        new Patient("P003", "Bob Johnson", 67, "Orthopedics"),
        new Patient("P004", "Alice Brown", 28, "Pediatrics"),
        new Patient("P005", "Carol White", 55, "Oncology")
    );
    
    public static void main(String[] args) {
        System.out.println("ALL PATIENT IDs:");
        patients.stream().map(Patient::id).forEach(System.out::println);
        
        System.out.println("\nSORTED IDs:");
        patients.stream().map(Patient::id).sorted().forEach(System.out::println);
        
        System.out.println("\nUPPERCASE IDs:");
        patients.stream().map(Patient::id).map(String::toUpperCase).forEach(System.out::println);
        
        System.out.println("\nCOLLECTED IDs:");
        System.out.println(patients.stream().map(Patient::id).collect(Collectors.joining(", ")));
        
        System.out.println("\nFILTERED & PRINTED (Cardiology):");
        patients.stream().filter(p -> "Cardiology".equals(p.department())).map(Patient::id).forEach(System.out::println);
        
        System.out.println("\nCOUNT: " + patients.stream().map(Patient::id).count());
    }
}