import java.util.*;

public class DoctorAvailability {
    record Doctor(String name, String specialty, boolean weekendAvailable) {}
    
    static List<Doctor> doctors = List.of(
        new Doctor("Dr. Smith", "Cardiology", true),
        new Doctor("Dr. Johnson", "Neurology", false),
        new Doctor("Dr. Brown", "Emergency", true),
        new Doctor("Dr. Davis", "Pediatrics", true),
        new Doctor("Dr. Wilson", "Orthopedics", false),
        new Doctor("Dr. Miller", "Cardiology", true),
        new Doctor("Dr. Taylor", "Emergency", true),
        new Doctor("Dr. Anderson", "Dermatology", false),
        new Doctor("Dr. Thomas", "Radiology", true),
        new Doctor("Dr. Jackson", "Anesthesiology", true)
    );
    
    public static void main(String[] args) {
        doctors.stream()
            .filter(Doctor::weekendAvailable)
            .sorted(Comparator.comparing(Doctor::specialty).thenComparing(Doctor::name))
            .forEach(System.out::println);
    }
}