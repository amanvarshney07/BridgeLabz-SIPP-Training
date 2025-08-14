package bridgelabz;

import java.util.*;
public class Number_Of_rounds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        double side1 = scanner.nextDouble();

        double side2 = scanner.nextDouble();

        double side3 = scanner.nextDouble();

       
        double perimeter = side1 + side2 + side3;

      
        int totalRounds = (int) Math.ceil(5000 / perimeter);

        
        System.out.println("The total number of rounds the athlete will run is " + totalRounds + " to complete 5 km.");

        scanner.close();
	}

}