package bridgelabz;

import java.util.*;

public class Area_Of_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("base and height in cm : ");
		int base = sc.nextInt();
		int height = sc.nextInt();
		
		double Area = 0.5 * base * height ; 
		double inch = Area / 2.54;
		
		System.out.println ("The Area of the triangle in sq in is " + inch + "  and sq cm is "+ Area);

	}

}
