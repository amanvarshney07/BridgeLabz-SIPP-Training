import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;
    
    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private Item head;
    
    public InventoryLinkedList() {
        this.head = null;
    }
    
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        if (findItemById(itemId) != null) {
            System.out.println("Item with ID " + itemId + " already exists!");
            return;
        }
        
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
        System.out.println("Item added at beginning successfully!");
    }
    
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        if (findItemById(itemId) != null) {
            System.out.println("Item with ID " + itemId + " already exists!");
            return;
        }
        
        Item newItem = new Item(itemName, itemId, quantity, price);
        
        if (head == null) {
            head = newItem;
        } else {
            Item current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
        System.out.println("Item added at end successfully!");
    }
    
    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (findItemById(itemId) != null) {
            System.out.println("Item with ID " + itemId + " already exists!");
            return;
        }
        
        if (position < 1) {
            System.out.println("Position should be >= 1");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        
        Item newItem = new Item(itemName, itemId, quantity, price);
        Item current = head;
        
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        
        newItem.next = current.next;
        current.next = newItem;
        System.out.println("Item added at position " + position + " successfully!");
    }
    
    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed successfully!");
            return;
        }
        
        Item current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        
        if (current.next == null) {
            System.out.println("Item with ID " + itemId + " not found!");
        } else {
            current.next = current.next.next;
            System.out.println("Item with ID " + itemId + " removed successfully!");
        }
    }
    
    public void updateQuantity(int itemId, int newQuantity) {
        Item item = findItemById(itemId);
        if (item != null) {
            int oldQuantity = item.quantity;
            item.quantity = newQuantity;
            System.out.println("Quantity updated successfully!");
            System.out.println("Item ID: " + itemId);
            System.out.println("Old Quantity: " + oldQuantity);
            System.out.println("New Quantity: " + newQuantity);
        } else {
            System.out.println("Item with ID " + itemId + " not found!");
        }
    }
    
    public void searchById(int itemId) {
        Item item = findItemById(itemId);
        if (item != null) {
            System.out.println("\n--- Item Found ---");
            displayItemInfo(item);
        } else {
            System.out.println("Item with ID " + itemId + " not found!");
        }
    }
    
    public void searchByName(String itemName) {
        Item current = head;
        boolean found = false;
        
        System.out.println("\n--- Items with name containing '" + itemName + "' ---");
        while (current != null) {
            if (current.itemName.toLowerCase().contains(itemName.toLowerCase())) {
                displayItemInfo(current);
                System.out.println("---");
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No items found with name containing '" + itemName + "'");
        }
    }
    
    public void calculateTotalValue() {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        
        double totalValue = 0;
        Item current = head;
        
        System.out.println("\n--- Inventory Value Calculation ---");
        while (current != null) {
            double itemValue = current.quantity * current.price;
            totalValue += itemValue;
            System.out.println(current.itemName + " (ID: " + current.itemId + "): " 
                + current.quantity + " x $" + current.price + " = $" + itemValue);
            current = current.next;
        }
        
        System.out.println("\nTotal Inventory Value: $" + totalValue);
    }
    
    public void sortByName(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("Not enough items to sort!");
            return;
        }
        
        head = mergeSortByName(head, ascending);
        System.out.println("Inventory sorted by name in " + (ascending ? "ascending" : "descending") + " order!");
    }
    
    public void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("Not enough items to sort!");
            return;
        }
        
        head = mergeSortByPrice(head, ascending);
        System.out.println("Inventory sorted by price in " + (ascending ? "ascending" : "descending") + " order!");
    }
    
    private Item mergeSortByName(Item head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;
        
        Item left = mergeSortByName(head, ascending);
        Item right = mergeSortByName(nextToMiddle, ascending);
        
        return mergeByName(left, right, ascending);
    }
    
    private Item mergeSortByPrice(Item head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;
        
        Item left = mergeSortByPrice(head, ascending);
        Item right = mergeSortByPrice(nextToMiddle, ascending);
        
        return mergeByPrice(left, right, ascending);
    }
    
    private Item getMiddle(Item head) {
        if (head == null) return head;
        
        Item slow = head;
        Item fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private Item mergeByName(Item left, Item right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;
        
        Item result;
        
        boolean condition = ascending ? 
            left.itemName.compareToIgnoreCase(right.itemName) <= 0 :
            left.itemName.compareToIgnoreCase(right.itemName) >= 0;
        
        if (condition) {
            result = left;
            result.next = mergeByName(left.next, right, ascending);
        } else {
            result = right;
            result.next = mergeByName(left, right.next, ascending);
        }
        
        return result;
    }
    
    private Item mergeByPrice(Item left, Item right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;
        
        Item result;
        
        boolean condition = ascending ? left.price <= right.price : left.price >= right.price;
        
        if (condition) {
            result = left;
            result.next = mergeByPrice(left.next, right, ascending);
        } else {
            result = right;
            result.next = mergeByPrice(left, right.next, ascending);
        }
        
        return result;
    }
    
    public void displayAllItems() {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        
        System.out.println("\n--- All Inventory Items ---");
        Item current = head;
        int position = 1;
        
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayItemInfo(current);
            current = current.next;
            position++;
        }
    }
    
    private void displayItemInfo(Item item) {
        System.out.println("Item ID: " + item.itemId);
        System.out.println("Item Name: " + item.itemName);
        System.out.println("Quantity: " + item.quantity);
        System.out.println("Price: $" + item.price);
        System.out.println("Total Value: $" + (item.quantity * item.price));
    }
    
    private Item findItemById(int itemId) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Specific Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Item Quantity");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Calculate Total Inventory Value");
            System.out.println("9. Sort by Name (Ascending)");
            System.out.println("10. Sort by Name (Descending)");
            System.out.println("11. Sort by Price (Ascending)");
            System.out.println("12. Sort by Price (Descending)");
            System.out.println("13. Display All Items");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    scanner.nextLine();
                    System.out.print("Enter Item Name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    int itemId = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: $");
                    double price = scanner.nextDouble();
                    
                    if (choice == 1) {
                        inventory.addAtBeginning(itemName, itemId, quantity, price);
                    } else if (choice == 2) {
                        inventory.addAtEnd(itemName, itemId, quantity, price);
                    } else {
                        System.out.print("Enter Position: ");
                        int position = scanner.nextInt();
                        inventory.addAtPosition(itemName, itemId, quantity, price, position);
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    int removeId = scanner.nextInt();
                    inventory.removeByItemId(removeId);
                    break;
                    
                case 5:
                    System.out.print("Enter Item ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateQuantity(updateId, newQuantity);
                    break;
                    
                case 6:
                    System.out.print("Enter Item ID to search: ");
                    int searchId = scanner.nextInt();
                    inventory.searchById(searchId);
                    break;
                    
                case 7:
                    scanner.nextLine();
                    System.out.print("Enter Item Name to search: ");
                    String searchName = scanner.nextLine();
                    inventory.searchByName(searchName);
                    break;
                    
                case 8:
                    inventory.calculateTotalValue();
                    break;
                    
                case 9:
                    inventory.sortByName(true);
                    break;
                    
                case 10:
                    inventory.sortByName(false);
                    break;
                    
                case 11:
                    inventory.sortByPrice(true);
                    break;
                    
                case 12:
                    inventory.sortByPrice(false);
                    break;
                    
                case 13:
                    inventory.displayAllItems();
                    break;
                    
                case 14:
                    System.out.println("Thank you for using Inventory Management System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}