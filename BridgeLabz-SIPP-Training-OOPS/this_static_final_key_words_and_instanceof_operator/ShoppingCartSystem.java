package this_static_final_key_words_and_instanceof_operator;

class Product {
    static double discount = 10.0;

    private String productName;
    private double price;
    private int quantity;
    private final int productID;

    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 75000, 1, 501);
        Product p2 = new Product("Headphones", 1500, 2, 502);

        if (p1 instanceof Product) {
            p1.displayDetails();
        }

        if (p2 instanceof Product) {
            p2.displayDetails();
        }

        Product.updateDiscount(15.0);

        if (p1 instanceof Product) {
            System.out.println("\nAfter updating discount:");
            p1.displayDetails();
        }
    }
}

