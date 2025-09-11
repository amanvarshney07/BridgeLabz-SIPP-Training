import java.util.*;
import java.time.LocalDate;

public class ExpiringMemberships {
    record Member(String name, LocalDate expiryDate) {}
    
    static List<Member> members = List.of(
        new Member("John Doe", LocalDate.now().plusDays(15)),
        new Member("Jane Smith", LocalDate.now().plusDays(45)),
        new Member("Bob Johnson", LocalDate.now().plusDays(5)),
        new Member("Alice Brown", LocalDate.now().plusDays(60)),
        new Member("Carol White", LocalDate.now().plusDays(25)),
        new Member("David Lee", LocalDate.now().plusDays(35)),
        new Member("Emma Wilson", LocalDate.now().plusDays(10)),
        new Member("Frank Miller", LocalDate.now().plusDays(50)),
        new Member("Grace Taylor", LocalDate.now().plusDays(20)),
        new Member("Henry Davis", LocalDate.now().plusDays(3))
    );
    
    public static void main(String[] args) {
        members.stream()
            .filter(m -> m.expiryDate().isBefore(LocalDate.now().plusDays(30)))
            .forEach(System.out::println);
    }
}