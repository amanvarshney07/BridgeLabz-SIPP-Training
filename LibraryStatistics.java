import java.util.*;
import java.util.stream.Collectors;

public class LibraryStatistics {
    record Book(String title, String genre, int pages) {}
    
    static List<Book> books = List.of(
        new Book("The Great Gatsby", "Fiction", 180),
        new Book("To Kill a Mockingbird", "Fiction", 281),
        new Book("1984", "Dystopian", 328),
        new Book("Pride and Prejudice", "Romance", 432),
        new Book("The Catcher in the Rye", "Fiction", 277),
        new Book("Brave New World", "Dystopian", 268),
        new Book("Jane Eyre", "Romance", 507),
        new Book("Lord of the Flies", "Fiction", 224),
        new Book("Fahrenheit 451", "Dystopian", 249),
        new Book("Wuthering Heights", "Romance", 416)
    );
    
    public static void main(String[] args) {
        books.stream()
            .collect(Collectors.groupingBy(Book::genre, Collectors.summarizingInt(Book::pages)))
            .forEach((genre, stats) -> System.out.println(genre + " - Total: " + stats.getSum() + 
                ", Average: " + String.format("%.1f", stats.getAverage()) + 
                ", Max: " + stats.getMax() + " pages"));
    }
}