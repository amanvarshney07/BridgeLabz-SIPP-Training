import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotificationFiltering {
    record Alert(String type, String severity, String patient, boolean urgent) {}
    
    static Map<String, Predicate<Alert>> filters = Map.of(
        "critical_only", a -> "CRITICAL".equals(a.severity()),
        "urgent_only", Alert::urgent,
        "medication", a -> "MEDICATION".equals(a.type()),
        "vitals", a -> "VITALS".equals(a.type()),
        "emergency", a -> a.urgent() && "CRITICAL".equals(a.severity()),
        "routine", a -> !a.urgent() && !"CRITICAL".equals(a.severity()),
        "patient_specific", a -> "John Doe".equals(a.patient()),
        "high_priority", a -> a.urgent() || "HIGH".equals(a.severity()) || "CRITICAL".equals(a.severity())
    );
    
    static List<Alert> alerts = List.of(
        new Alert("MEDICATION", "HIGH", "John Doe", true),
        new Alert("VITALS", "CRITICAL", "Jane Smith", true),
        new Alert("APPOINTMENT", "LOW", "Bob Johnson", false),
        new Alert("MEDICATION", "MEDIUM", "Alice Brown", false),
        new Alert("EMERGENCY", "CRITICAL", "John Doe", true),
        new Alert("VITALS", "HIGH", "Carol White", true)
    );
    
    static void showAlerts(String preference) {
        System.out.println(preference.toUpperCase() + ":");
        alerts.stream().filter(filters.get(preference)).forEach(System.out::println);
        System.out.println();
    }
    
    public static void main(String[] args) {
        Arrays.asList("critical_only", "urgent_only", "medication", "emergency", "patient_specific", "high_priority").forEach(NotificationFiltering::showAlerts);
        
        alerts.stream().filter(filters.get("urgent_only").and(filters.get("medication"))).forEach(a -> System.out.println("URGENT MEDS: " + a));
    }
}