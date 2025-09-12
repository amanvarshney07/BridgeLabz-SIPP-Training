import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@FunctionalInterface
interface FareCalculator { double calculateFare(double distance, String serviceType); }

interface EmergencyService { }

interface TransportService {
    String getServiceName();
    String getServiceType();
    LocalDateTime getDepartureTime();
    double getFare();
    String getRoute();
    boolean isActive();
    
    default void printServiceDetails() {
        System.out.printf("Service: %s | Type: %s | Route: %s | Fare: $%.2f | Departure: %s%n",
            getServiceName(), getServiceType(), getRoute(), getFare(),
            getDepartureTime().format(DateTimeFormatter.ofPattern("HH:mm")));
    }
    
    static double calculateDistance(String start, String end) { return Math.random() * 50 + 5; }
}

interface GeoUtils {
    static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(deltaLat/2) * Math.sin(deltaLat/2) +
                  Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                  Math.sin(deltaLon/2) * Math.sin(deltaLon/2);
        return 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)) * 6371;
    }
    
    static boolean isWithinRadius(double lat1, double lon1, double lat2, double lon2, double radius) {
        return calculateDistance(lat1, lon1, lat2, lon2) <= radius;
    }
}

class BusService implements TransportService {
    private String name, route; private LocalDateTime time; private double fare; private boolean active;
    
    public BusService(String n, String r, LocalDateTime t, double f) { name=n; route=r; time=t; fare=f; active=true; }
    public String getServiceName() { return name; }
    public String getServiceType() { return "Bus"; }
    public String getRoute() { return route; }
    public LocalDateTime getDepartureTime() { return time; }
    public double getFare() { return fare; }
    public boolean isActive() { return active; }
}

class MetroService implements TransportService {
    private String name, route; private LocalDateTime time; private double fare; private boolean active;
    
    public MetroService(String n, String r, LocalDateTime t, double f) { name=n; route=r; time=t; fare=f; active=true; }
    public String getServiceName() { return name; }
    public String getServiceType() { return "Metro"; }
    public String getRoute() { return route; }
    public LocalDateTime getDepartureTime() { return time; }
    public double getFare() { return fare; }
    public boolean isActive() { return active; }
    
    public void printServiceDetails() {
        System.out.printf("🚇 METRO: %s | Route: %s | Fare: $%.2f | Next: %s%n",
            getServiceName(), getRoute(), getFare(),
            getDepartureTime().format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}

class TaxiService implements TransportService {
    private String name, route; private LocalDateTime time; private double fare; private boolean active;
    
    public TaxiService(String n, String r, LocalDateTime t, double f) { name=n; route=r; time=t; fare=f; active=true; }
    public String getServiceName() { return name; }
    public String getServiceType() { return "Taxi"; }
    public String getRoute() { return route; }
    public LocalDateTime getDepartureTime() { return time; }
    public double getFare() { return fare; }
    public boolean isActive() { return active; }
}

class AmbulanceService implements TransportService, EmergencyService {
    private String name, route; private LocalDateTime time; private boolean active;
    
    public AmbulanceService(String n, String r, LocalDateTime t) { name=n; route=r; time=t; active=true; }
    public String getServiceName() { return name; }
    public String getServiceType() { return "Emergency-Ambulance"; }
    public String getRoute() { return route; }
    public LocalDateTime getDepartureTime() { return time; }
    public double getFare() { return 0.0; }
    public boolean isActive() { return active; }
    
    public void printServiceDetails() {
        System.out.printf("🚨 EMERGENCY: %s | Route: %s | PRIORITY ACCESS | ETA: %s%n",
            getServiceName(), getRoute(),
            getDepartureTime().format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}

class Passenger {
    private String id, name, route, serviceType;
    private double faresPaid;
    private LocalDateTime travelTime;
    
    public Passenger(String id, String name, String route, double faresPaid, LocalDateTime travelTime, String serviceType) {
        this.id = id; this.name = name; this.route = route; this.faresPaid = faresPaid; 
        this.travelTime = travelTime; this.serviceType = serviceType;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public String getRoute() { return route; }
    public double getFaresPaid() { return faresPaid; }
    public LocalDateTime getTravelTime() { return travelTime; }
    public String getServiceType() { return serviceType; }
    
    public boolean isPeakTime() {
        int hour = travelTime.getHour();
        return (hour >= 7 && hour <= 9) || (hour >= 17 && hour <= 19);
    }
}

public class SmartCityTransportSystem {
    private List<TransportService> services = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private FareCalculator fareCalculator = (d, t) -> {
        double base = switch (t.toLowerCase()) {
            case "bus" -> 2.0; case "metro" -> 3.0; case "taxi" -> 5.0; default -> 2.5;
        };
        return base + (d * 0.5);
    };
    
    public SmartCityTransportSystem() { init(); }
    
    private void init() {
        LocalDateTime now = LocalDateTime.now();
        services.add(new BusService("Express 101", "Downtown-Airport", now.plusMinutes(15), 3.50));
        services.add(new BusService("Link 205", "Central-University", now.plusMinutes(8), 2.75));
        services.add(new MetroService("Blue Line", "North-South", now.plusMinutes(5), 4.00));
        services.add(new MetroService("Red Line", "East-West", now.plusMinutes(12), 3.75));
        services.add(new TaxiService("Cab #123", "Custom Route", now.plusMinutes(3), 12.50));
        services.add(new AmbulanceService("Emergency Unit 1", "Hospital-Site", now.plusMinutes(2)));
        
        String[] routes = {"Downtown-Airport", "Central-University", "North-South", "East-West", "Hospital-Mall"};
        String[] types = {"Bus", "Metro", "Taxi"};
        Random r = new Random();
        
        for (int i = 1; i <= 20; i++) {
            String route = routes[r.nextInt(routes.length)];
            String type = types[r.nextInt(types.length)];
            double fare = fareCalculator.calculateFare(r.nextDouble() * 30 + 5, type);
            passengers.add(new Passenger("P" + String.format("%03d", i), "Passenger " + i, route,
                Math.round(fare * 100.0) / 100.0, now.minusHours(r.nextInt(12)).plusMinutes(r.nextInt(60)), type));
        }
    }
    
    public void demo() {
        System.out.println("=== LAMBDA FILTERING ===");
        services.stream().filter(s -> s.isActive()).sorted((s1, s2) -> s1.getDepartureTime().compareTo(s2.getDepartureTime()))
            .limit(3).forEach(TransportService::printServiceDetails);
        
        System.out.println("\n=== METHOD REFERENCES ===");
        services.forEach(TransportService::printServiceDetails);
        
        System.out.println("\n=== STREAM APIs ===");
        Map<String, List<Passenger>> byRoute = passengers.stream().collect(Collectors.groupingBy(Passenger::getRoute));
        byRoute.forEach((route, p) -> System.out.printf("Route: %s (%d passengers)%n", route, p.size()));
        
        System.out.println("\n=== FOREACH DASHBOARD ===");
        services.stream().filter(TransportService::isActive).sorted((s1, s2) -> s1.getDepartureTime().compareTo(s2.getDepartureTime()))
            .forEach(s -> { if (s instanceof EmergencyService) System.out.print("⚡ PRIORITY: "); s.printServiceDetails(); });
        
        System.out.println("\n=== COLLECTORS ===");
        Map<Boolean, List<Passenger>> peak = passengers.stream().collect(Collectors.partitioningBy(Passenger::isPeakTime));
        System.out.printf("Peak: %d, Non-peak: %d%n", peak.get(true).size(), peak.get(false).size());
        
        DoubleSummaryStatistics stats = passengers.stream().collect(Collectors.summarizingDouble(Passenger::getFaresPaid));
        System.out.printf("Total: $%.2f, Avg: $%.2f, Trips: %d%n", stats.getSum(), stats.getAverage(), stats.getCount());
        
        System.out.println("\n=== FUNCTIONAL INTERFACE ===");
        FareCalculator premium = (d, t) -> (3.0 + d * 0.8) * (t.equals("Taxi") ? 2.0 : 1.0);
        System.out.printf("Standard Bus 15km: $%.2f%n", fareCalculator.calculateFare(15.0, "Bus"));
        System.out.printf("Premium Taxi 15km: $%.2f%n", premium.calculateFare(15.0, "Taxi"));
        
        System.out.println("\n=== MARKER INTERFACE ===");
        List<TransportService> emergency = services.stream().filter(s -> s instanceof EmergencyService).collect(Collectors.toList());
        emergency.forEach(TransportService::printServiceDetails);
        System.out.printf("Emergency services: %d%n", emergency.size());
        
        System.out.println("\n=== GEO UTILS ===");
        double dist = GeoUtils.calculateDistance(28.6139, 77.2090, 28.5355, 77.3910);
        System.out.printf("Distance: %.2f km%n", dist);
        
        System.out.println("\n=== EXTENSIBILITY ===");
        class FerryService implements TransportService {
            private String name, route; private LocalDateTime time; private double fare;
            public FerryService(String n, String r, LocalDateTime t, double f) { name=n; route=r; time=t; fare=f; }
            public String getServiceName() { return name; }
            public String getServiceType() { return "Ferry"; }
            public String getRoute() { return route; }
            public LocalDateTime getDepartureTime() { return time; }
            public double getFare() { return fare; }
            public boolean isActive() { return true; }
            public void printServiceDetails() {
                System.out.printf("⛵ FERRY: %s | Route: %s | Fare: $%.2f%n", name, route, fare);
            }
        }
        FerryService ferry = new FerryService("River Express", "Port A-B", LocalDateTime.now().plusMinutes(25), 6.50);
        services.add(ferry);
        ferry.printServiceDetails();
        
        System.out.println("\n🎯 All Java 8 Features Demonstrated!");
    }
    
    public static void main(String[] args) {
        System.out.println("🌆 SMART CITY TRANSPORT SYSTEM 🌆");
        new SmartCityTransportSystem().demo();
    }
}