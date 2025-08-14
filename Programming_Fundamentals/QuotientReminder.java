package bridgelabz;

import java.util.Scanner;

public class QuotientReminder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("write divisor and divident:");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		double quotient = num1 / num2;
		double reminder = num1 % num2;
		
		System.out.println(" The Quotient is "+ quotient+ " and Reminder is "+ reminder + " of two number "+ num1+" and "+ num2 );
	}

}
