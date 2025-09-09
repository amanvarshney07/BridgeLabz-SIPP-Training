import java.util.Scanner;

public class CreditCardValidator {

    public static boolean isValidCard(String cardNumber) {
        
        cardNumber = cardNumber.replaceAll("\\s+", "");

        if (!cardNumber.matches("\\d{16}")) {
            return false;
        }
        if (cardNumber.startsWith("4")) {
           
            return true;
        } else if (cardNumber.startsWith("5")) {
            
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter credit card number: ");
        String cardNumber = scanner.nextLine();

        if (isValidCard(cardNumber)) {
            System.out.println("✅ \"" + cardNumber + "\" → Valid card number");
        } else {
            System.out.println("❌ \"" + cardNumber + "\" → Invalid card number");
        }

        scanner.close();
    }
}
