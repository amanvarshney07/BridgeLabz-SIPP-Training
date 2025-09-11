import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenue {
    record Order(String customer, double total) {}
    
    static List<Order> orders = List.of(
        new Order("John Doe", 250.0),
        new Order("Jane Smith", 150.0),
        new Order("John Doe", 300.0),
        new Order("Bob Johnson", 180.0),
        new Order("Jane Smith", 220.0),
        new Order("Alice Brown", 400.0),
        new Order("John Doe", 120.0),
        new Order("Carol White", 350.0),
        new Order("Bob Johnson", 280.0),
        new Order("Alice Brown", 190.0)
    );
    
    public static void main(String[] args) {
        orders.stream()
            .collect(Collectors.groupingBy(Order::customer, Collectors.summingDouble(Order::total)))
            .forEach((customer, total) -> System.out.println(customer + ": $" + total));
    }
}