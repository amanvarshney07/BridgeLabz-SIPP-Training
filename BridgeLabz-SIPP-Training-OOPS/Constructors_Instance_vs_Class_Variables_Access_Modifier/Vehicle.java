package Constructors_Instance_vs_Class_Variables_Access_Modifier;

public class Vehicle {

    private String ownerName;
    private String vehicleType;

    private static double registrationFee = 500.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

   
    public static void main(String[] args) {
       
        Vehicle.updateRegistrationFee(750.0);

        Vehicle vehicle1 = new Vehicle("Aman", "Car");
        Vehicle vehicle2 = new Vehicle("mkkgjfg", "Bike");

        vehicle1.displayVehicleDetails();
        System.out.println();
        vehicle2.displayVehicleDetails();
    }
}

