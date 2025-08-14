package Constructors_Instance_vs_Class_Variables_Access_Modifier;

public class LibraryManagement {
    String title;
    String author;
    double price;
    boolean isAvailable;
    public LibraryManagement(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, the book '" + title + "' is currently not available.");
        }
    }

    public void displayDetails() {
        System.out.println("Title: " + title +
                           ", Author: " + author +
                           ", Price: ₹" + price +
                           ", Available: " + (isAvailable ? "Yes" : "No"));
    }

    
    public static void main(String[] args) {
    	LibraryManagement book1 = new LibraryManagement("The Alchemist", "Paulo Coelho", 299.0, true);
        book1.displayDetails();

        book1.borrowBook();  
        book1.displayDetails();

        book1.borrowBook(); 
    }
}

