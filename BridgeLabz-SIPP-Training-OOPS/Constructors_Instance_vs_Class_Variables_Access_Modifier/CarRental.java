package Constructors_Instance_vs_Class_Variables_Access_Modifier;

public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
  final double costPerDay = 1500.0;
    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
    public void calculateTotalCost() {
        double totalCost = rentalDays * costPerDay;
        System.out.println("Customer: " + customerName +
                           ", Car Model: " + carModel +
                           ", Days: " + rentalDays +
                           ", Total Cost: ₹" + totalCost);
    }

    public static void main(String[] args) {
        CarRental defaultRental = new CarRental();  
        CarRental customRental = new CarRental("Aman Khan", "Honda City", 4); 

        defaultRental.calculateTotalCost();
        customRental.calculateTotalCost();
    }
}

