class BookCategory {
    public String name = "Books";
    public double minPrice = 5.0;
    public double maxPrice = 100.0;
}

class ClothingCategory {
    public String name = "Clothing"; 
    public double minPrice = 10.0;
    public double maxPrice = 200.0;
}

class Product<T> {
    private String name;
    private double price;
    private T category;
    
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public T getCategory() { return category; }
    
    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

class Marketplace {
    
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double currentPrice = product.getPrice();
        double newPrice = currentPrice - (currentPrice * percentage / 100);
        product.setPrice(newPrice);
        System.out.println("Applied " + percentage + "% discount to " + product.getName() 
                         + ". New price: $" + newPrice);
    }
    
    public static <T extends Product<?>> void bulkDiscount(java.util.List<T> products, double percentage) {
        for (T product : products) {
            applyDiscount(product, percentage);
        }
    }
}

public class SimpleMarketplace {
    public static void main(String[] args) {
        System.out.println("=== Simple Marketplace Demo ===\n");
        
        Product<BookCategory> book1 = new Product<>("Java Book", 45.99, new BookCategory());
        Product<BookCategory> book2 = new Product<>("Python Guide", 39.99, new BookCategory());
        
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 25.99, new ClothingCategory());
        Product<ClothingCategory> jeans = new Product<>("Jeans", 79.99, new ClothingCategory());
        
        System.out.println("Original Prices:");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(shirt);
        System.out.println(jeans);
        System.out.println();
        
        System.out.println("Applying Discounts:");
        Marketplace.applyDiscount(book1, 15.0);
        Marketplace.applyDiscount(shirt, 20.0);
        
        java.util.List<Product<?>> allProducts = new java.util.ArrayList<>();
        allProducts.add(book2);
        allProducts.add(jeans);
        
        System.out.println("\nBulk discount on remaining products:");
        Marketplace.bulkDiscount(allProducts, 10.0);
        
        System.out.println("\nFinal Prices:");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(shirt);
        System.out.println(jeans);
    }
}