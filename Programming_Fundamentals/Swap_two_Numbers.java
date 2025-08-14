package bridgelabz;

import java.util.*;
public class Swap_two_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int firstElement = sc.nextInt();
		int secondElement = sc.nextInt();
		int temp = firstElement;
		firstElement = secondElement;
		temp = secondElement;
		System.out.println("firstElement: "+firstElement+"secondElement"+secondElement);


		sc.close();
	}

}