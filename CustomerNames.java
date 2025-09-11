import java.util.*;

public class CustomerNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> customers = new ArrayList<>();
        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            System.out.print("Enter customer " + (i+1) + " name: ");
            customers.add(sc.nextLine());
        }
        customers.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
        sc.close();
    }
}