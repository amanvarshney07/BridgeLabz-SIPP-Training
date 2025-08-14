package day_2;
import java.util.*;
public class centiToFeetandInches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        double heightCm = scanner.nextDouble();
        double totalInches = heightCm / 2.54;
        int feet = (int)(totalInches / 12);
        double inches = totalInches % 12;
        System.out.printf("Your height in cm is %.2f, while in feet is %d and inches is %.2f\n",
                heightCm, feet, inches);

	}

}
