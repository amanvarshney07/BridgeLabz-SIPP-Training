package Class_and_Object;


public class Item {
    int itemCode;
    String itemName;
    double price;
    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    public void displayDetails() {
        System.out.println("Item Details:");
        System.out.println("Code  : " + itemCode);
        System.out.println("Name  : " + itemName);
        System.out.println("Price : ₹" + price);
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Item item = new Item(101, "Wireless Mouse", 749.50);
        item.displayDetails();

        int quantity = 3;
        System.out.println("Quantity        : " + quantity);
        System.out.println("Total Cost      : ₹" + item.calculateTotalCost(quantity));
    }
}

