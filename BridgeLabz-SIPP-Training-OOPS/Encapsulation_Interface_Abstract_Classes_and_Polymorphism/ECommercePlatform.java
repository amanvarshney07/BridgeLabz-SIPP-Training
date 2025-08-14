package Encapsulation_Interface_Abstract_Classes_and_Polymorphism;


interface Taxable {
 double calculateTax();
 String getTaxDetails();
}

abstract class Product {
 private int productId;
 private String name;
 private double price;

 public Product(int productId, String name, double price) {
     this.productId = productId;
     this.name = name;
     this.price = price;
 }

 // Encapsulation: Getters and Setters
 public int getProductId() { return productId; }
 public String getName() { return name; }
 public double getPrice() { return price; }
 public void setPrice(double price) { this.price = price; }

 public abstract double calculateDiscount();

 public void displayProduct() {
     System.out.println("Product ID: " + productId);
     System.out.println("Name: " + name);
     System.out.println("Price: " + price);
 }
}

class Electronics extends Product implements Taxable {
 public Electronics(int productId, String name, double price) {
     super(productId, name, price);
 }

 public double calculateDiscount() {
     return getPrice() * 0.10; // 10% discount
 }

 public double calculateTax() {
     return getPrice() * 0.18; // 18% tax
 }

 public String getTaxDetails() {
     return "Electronics Tax: 18%";
 }
}

class Clothing extends Product implements Taxable {
 public Clothing(int productId, String name, double price) {
     super(productId, name, price);
 }

 public double calculateDiscount() {
     return getPrice() * 0.20; // 20% discount
 }

 public double calculateTax() {
     return getPrice() * 0.12; // 12% tax
 }

 public String getTaxDetails() {
     return "Clothing Tax: 12%";
 }
}

class Groceries extends Product {
 public Groceries(int productId, String name, double price) {
     super(productId, name, price);
 }

 public double calculateDiscount() {
     return getPrice() * 0.05; // 5% discount
 }
}

public class ECommercePlatform {
 public static void printFinalPrice(Product[] products) {
     for (Product product : products) {
         System.out.println("===========");
         product.displayProduct();

         double discount = product.calculateDiscount();
         double tax = 0;

         if (product instanceof Taxable) {
             Taxable taxable = (Taxable) product;
             tax = taxable.calculateTax();
             System.out.println(taxable.getTaxDetails());
         }

         double finalPrice = product.getPrice() + tax - discount;
         System.out.printf("Discount: ₹%.2f\n", discount);
         System.out.printf("Tax: ₹%.2f\n", tax);
         System.out.printf("Final Price: ₹%.2f\n", finalPrice);
         System.out.println("===========\n");
     }
 }

 public static void main(String[] args) {
     Product p1 = new Electronics(101, "Smartphone", 20000);
     Product p2 = new Clothing(102, "Jeans", 1500);
     Product p3 = new Groceries(103, "Rice", 1000);

     Product[] productList = {p1, p2, p3};
     printFinalPrice(productList);
 }
}

