package bridgelabz;

import java.util.*;

public class Chocolate_Distribution {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        int numberOfChocolates = scanner.nextInt();

        int numberOfChildren = scanner.nextInt();

        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        System.out.println("The number of chocolates each child gets is " + chocolatesPerChild + " and the number of remaining chocolates is " + remainingChocolates);

        scanner.close();
    }
}