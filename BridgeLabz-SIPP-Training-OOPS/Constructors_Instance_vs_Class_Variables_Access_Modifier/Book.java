package Constructors_Instance_vs_Class_Variables_Access_Modifier;

public class Book {
    String title;
    String author;
    double price;

    
    public Book() {
        this.title = "Song of ice and fire";
        this.author = "George RR Martin";
        this.price = 999.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: ₹" + price);
    }

    public static void main(String[] args) {
        Book defaultBook = new Book();  
        Book javaBook = new Book("Java Programming", "James Gosling", 499.99);

        defaultBook.display();
        javaBook.display();
    }
}

