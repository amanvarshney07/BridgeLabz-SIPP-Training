package Class_and_Object;

import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

public class ShoppingCart {
    ArrayList<CartItem> cart = new ArrayList<>();
    public void addItem(String itemName, double price, int quantity) {
        cart.add(new CartItem(itemName, price, quantity));
        System.out.println(quantity + " x " + itemName + " added to cart.");
    }

    public void removeItem(String itemName) {
        boolean removed = cart.removeIf(item -> item.itemName.equalsIgnoreCase(itemName));
        if (removed) {
            System.out.println(itemName + " removed from cart.");
        } else {
            System.out.println(itemName + " not found in cart.");
        }
    }

    public void displayTotalCost() {
        double total = 0;
        System.out.println("\n--- Cart Items ---");
        for (CartItem item : cart) {
            System.out.println(item.itemName + " - ₹" + item.price + " x " + item.quantity + " = ₹" + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Total Cost: ₹" + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 50000, 1);
        cart.addItem("Mouse", 750, 2);
        cart.displayTotalCost();

        cart.removeItem("Mouse");
        cart.displayTotalCost();
    }
}
