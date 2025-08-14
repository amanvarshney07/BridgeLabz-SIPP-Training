package Encapsulation_Interface_Abstract_Classes_and_Polymorphism;

interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    private double discountApplied;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discountApplied = 0;
    }

    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - (total * discountApplied / 100);
    }

    public void applyDiscount(double percent) {
        discountApplied = percent;
    }

    public String getDiscountDetails() {
        return "Veg Discount Applied: " + discountApplied + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge = 20;
    private double discountApplied;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discountApplied = 0;
    }

    public double calculateTotalPrice() {
        double total = (getPrice() + extraCharge) * getQuantity();
        return total - (total * discountApplied / 100);
    }

    public void applyDiscount(double percent) {
        discountApplied = percent;
    }

    public String getDiscountDetails() {
        return "Non-Veg Discount Applied: " + discountApplied + "%";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem item1 = new VegItem("Paneer Tikka", 150, 2);
        FoodItem item2 = new NonVegItem("Chicken Biryani", 200, 3);

        Discountable d1 = (Discountable) item1;
        Discountable d2 = (Discountable) item2;

        d1.applyDiscount(10);
        d2.applyDiscount(5);

        FoodItem[] order = {item1, item2};

        for (FoodItem item : order) {
            System.out.println("===============");
            item.getItemDetails();
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println(d.getDiscountDetails());
            }
            System.out.println("Total Price: ₹" + item.calculateTotalPrice());
            System.out.println("===============\n");
        }
    }
}

