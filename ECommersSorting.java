import java.util.*;
import java.util.stream.Collectors;
public class ECommersSorting {
    record Product(String name, double price, double rating, double discount){}

    static Map<String, Comparator<Product>> sorters = Map.of(
        "price_low", Comparator.comparing(Product::price),
        "price_high", Comparator.comparing(Product::price).reversed(),
        "rating_high", Comparator.comparing(Product::rating).reversed(),
        "discount_high", Comparator.comparing(Product::discount).reversed(),
        "best_deal", Comparator.comparing((Product p) -> p.price() * (1 - p.discount())),
        "premium", Comparator.comparing(Product::rating).reversed().thenComparing(Product::price).reversed()
    );
    static List<Product> products = List.of(
        new Product("Laptop", 1200.0, 4.5, 0.1),
        new Product("Phone", 800.0, 4.8, 0.15),
        new Product("Tablet", 400.0, 4.2, 0.2),
        new Product("Watch", 300.0, 4.0, 0.05),
        new Product("Headphones", 150.0, 4.6, 0.25)
    );
      static void sort(String campaign) {
        products.stream().sorted(sorters.get(campaign)).forEach(System.out::println);
        System.out.println();
    }
    public static void main(String[] args) {
        Arrays.asList("price_low", "rating_high", "discount_high", "best_deal", "premium").forEach(ECommersSorting::sort);
    }
}
