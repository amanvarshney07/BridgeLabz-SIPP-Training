package Encapsulation_Interface_Abstract_Classes_and_Polymorphism;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate/Km: ₹" + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle v1 = new Car("CAR123", "Raj", 15.0);
        Vehicle v2 = new Bike("BIKE456", "Amit", 7.0);
        Vehicle v3 = new Auto("AUTO789", "Suresh", 10.0);

        ((GPS)v1).updateLocation("Connaught Place");
        ((GPS)v2).updateLocation("Lajpat Nagar");
        ((GPS)v3).updateLocation("Karol Bagh");

        Vehicle[] rides = {v1, v2, v3};
        double[] distances = {10, 5, 8};

        for (int i = 0; i < rides.length; i++) {
            System.out.println("===================");
            rides[i].getVehicleDetails();
            System.out.println("Current Location: " + ((GPS)rides[i]).getCurrentLocation());
            System.out.println("Distance: " + distances[i] + " km");
            System.out.println("Fare: ₹" + rides[i].calculateFare(distances[i]));
        }
    }
}

