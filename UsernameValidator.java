import java.util.Scanner;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        
        return username.matches("^[A-Za-z][A-Za-z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        if (isValidUsername(username)) {
            System.out.println("✅ \"" + username + "\" → Valid");
        } else {
            System.out.println("❌ \"" + username + "\" → Invalid");
        }

        scanner.close();
    }
}
