import java.util.*;
import java.time.LocalTime;

public class SmartLighting {
    interface LightPattern { void activate(String room); }
    
    static Map<String, LightPattern> patterns = Map.of(
        "motion", room -> System.out.println(room + " lights: Motion detected - Bright white"),
        "morning", room -> System.out.println(room + " lights: Morning - Warm yellow 70%"),
        "evening", room -> System.out.println(room + " lights: Evening - Soft amber 30%"),
        "night", room -> System.out.println(room + " lights: Night mode - Dim red 5%"),
        "party", room -> System.out.println(room + " lights: Party mode - Rainbow colors"),
        "relax", room -> System.out.println(room + " lights: Relax - Cool blue 40%"),
        "reading", room -> System.out.println(room + " lights: Reading - Bright white focused")
    );
    
    static Map<String, LightPattern> triggers = Map.of(
        "motion_detected", patterns.get("motion"),
        "voice_party", patterns.get("party"),
        "voice_relax", patterns.get("relax"),
        "voice_reading", patterns.get("reading"),
        "time_based", room -> {
            int hour = LocalTime.now().getHour();
            patterns.get(hour < 8 ? "night" : hour < 12 ? "morning" : hour < 18 ? "morning" : "evening").activate(room);
        }
    );
    
    public static void main(String[] args) {
        triggers.get("motion_detected").activate("Living Room");
        triggers.get("voice_party").activate("Kitchen");
        triggers.get("time_based").activate("Bedroom");
        
        Arrays.asList("motion_detected", "voice_relax", "time_based")
            .forEach(trigger -> triggers.get(trigger).activate("Bathroom"));
    }
}