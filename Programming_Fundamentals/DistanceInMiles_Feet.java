package bridgelabz;

import java.util.*;

public class DistanceInMiles_Feet {
	public static void main(String[] args) {
		System.out.print("Distance in feet: ");
		Scanner sc = new Scanner(System.in);
		float feet = sc.nextInt();
		
		float yard = feet / 3;
		float mile = yard / 1760;
		
		System.out.println("Distance in mile is "+ mile + " and in yard is "+yard);
	}

}
