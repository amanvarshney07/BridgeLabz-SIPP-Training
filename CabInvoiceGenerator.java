import java.util.*;
enum RideType {
    NORMAL(10.0, 1.0, 5.0),
    PREMIUM(15.0, 2.0, 20.0);
       private final double costPerKm;
    private final double costPerMinute;
    private final double minimumFare;
    
    RideType(double costPerKm, double costPerMinute, double minimumFare) {
        this.costPerKm = costPerKm;
        this.costPerMinute = costPerMinute;
        this.minimumFare = minimumFare;
    }
    
    public double getCostPerKm() { return costPerKm; }
    public double getCostPerMinute() { return costPerMinute; }
    public double getMinimumFare() { return minimumFare; }
}
class Ride {
    private double distance;
    private int time;
    private RideType rideType;
    
    public Ride(double distance, int time, RideType rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }
    
    public double getDistance() { return distance; }
    public int getTime() { return time; }
    public RideType getRideType() { return rideType; }
}
class InvoiceSummary{
    private int totalRides;
    private double totalFare;
    private double averageFare;

    public InvoiceSummary(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare= totalRides > 0 ? totalFare / totalRides : 0;
    }
    public int getTotalRides() { return totalRides; }
    public double getTotalFare() { return totalFare; }
    public double getAverageFare() { return averageFare; }

    @Override
    public String toString() {
       return String.format("Invoice Summary:\n" +
            "Total Number of Rides: %d\n" +
            "Total Fare: Rs. %.2f\n" +
            "Average Fare Per Ride: Rs. %.2f",
            totalRides, totalFare, averageFare);
    }
}
class RideRepository{
    private Map<String, List<Ride>> userRides;
    public RideRepository() {
       this.userRides = new HashMap<>();
    } 
      
    public void addRide(String userId, Ride ride) {
        userRides.computeIfAbsent(userId, k -> new ArrayList<>()).add(ride);
    }
     public List<Ride> getRides(String userId) {
        return userRides.getOrDefault(userId, new ArrayList<>());
    }
     public void addMultipleRides(String userId, List<Ride> rides) {
        userRides.computeIfAbsent(userId, k -> new ArrayList<>()).addAll(rides);
    }
}

public class CabInvoiceGenerator{
    private RideRepository rideRepository;
    public CabInvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }
     public double calculateFare(double distance, int time, RideType rideType) {
        double totalFare = distance * rideType.getCostPerKm() + time * rideType.getCostPerMinute();
        return Math.max(totalFare, rideType.getMinimumFare());
    }
     public double calculateFare(double distance, int time) {
        return calculateFare(distance, time, RideType.NORMAL);
    }
    public double calculateFare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride : rides){
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        }
        return totalFare;
    }
     public InvoiceSummary calculateInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        return new InvoiceSummary(rides.length, totalFare);
    }
   public InvoiceSummary getInvoice(String userId) {
        List<Ride> rides = rideRepository.getRides(userId);
        Ride[] rideArray = rides.toArray(new Ride[0]);
        return calculateInvoice(rideArray);
    }
     public void addRide(String userId, double distance, int time, RideType rideType) {
        Ride ride = new Ride(distance, time, rideType);
        rideRepository.addRide(userId, ride);
    }
     public void addRides(String userId, Ride[] rides) {
        rideRepository.addMultipleRides(userId, Arrays.asList(rides));
    }
    public static void main(String[] args) {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        System.out.println("Single ride: Rs." + generator.calculateFare(5.0, 10, RideType.NORMAL));
        Ride[] rides = {
            new Ride(2.0, 5, RideType.NORMAL),
            new Ride(0.1, 1, RideType.PREMIUM)
        };
        System.out.println(generator.calculateFare(rides));
        generator.addRide("user1", 3.0,8,RideType.NORMAL);
        System.out.println(generator.getInvoice("user1"));
    }
}