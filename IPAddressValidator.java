import java.util.Scanner;

public class IPAddressValidator {

    public static boolean isValidIPv4(String ip) {
        
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an IPv4 address: ");
        String ip = scanner.nextLine();

        if (isValidIPv4(ip)) {
            System.out.println("✅ \"" + ip + "\" → Valid IPv4 address");
        } else {
            System.out.println("❌ \"" + ip + "\" → Invalid IPv4 address");
        }

        scanner.close();
    }
}
