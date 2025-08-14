package Java_Control_Flow_Concepts;

import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Enter Akbar's age: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Enter Anthony's age: ");
        int ageAnthony = scanner.nextInt();
        System.out.print("Enter Amar's height: ");
        double heightAmar = scanner.nextDouble();
        System.out.print("Enter Akbar's height: ");
        double heightAkbar = scanner.nextDouble();
        System.out.print("Enter Anthony's height: ");
        double heightAnthony = scanner.nextDouble();

        String youngest = "Amar";
        int minAge = ageAmar;

        if (ageAkbar < minAge) {
            youngest = "Akbar";
            minAge = ageAkbar;
        }
        if (ageAnthony < minAge) {
            youngest = "Anthony";
        }

        // Finding the tallest
        String tallest = "Amar";
        double maxHeight = heightAmar;

        if (heightAkbar > maxHeight) {
            tallest = "Akbar";
            maxHeight = heightAkbar;
        }
        if (heightAnthony > maxHeight) {
            tallest = "Anthony";
        }

        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);

        scanner.close();
    }
}

