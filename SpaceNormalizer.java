import java.util.Scanner;

public class SpaceNormalizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String output = input.replaceAll("\\s+", " ");

        System.out.println("Normalized: " + output);

        scanner.close();
    }
}
