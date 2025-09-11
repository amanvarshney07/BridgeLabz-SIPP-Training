import java.util.*;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysis {
    record Claim(String type, double amount) {}
    
    static List<Claim> claims = List.of(
        new Claim("Auto", 5000.0),
        new Claim("Health", 12000.0),
        new Claim("Home", 8000.0),
        new Claim("Auto", 3500.0),
        new Claim("Health", 15000.0),
        new Claim("Life", 25000.0),
        new Claim("Auto", 7500.0),
        new Claim("Health", 9000.0),
        new Claim("Home", 12000.0),
        new Claim("Life", 30000.0)
    );
    
    public static void main(String[] args) {
        claims.stream()
            .collect(Collectors.groupingBy(Claim::type, Collectors.averagingDouble(Claim::amount)))
            .forEach((type, avg) -> System.out.println(type + ": $" + String.format("%.2f", avg)));
    }
}