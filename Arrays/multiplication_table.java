package Arrays;
import java.util.*;
import java.util.Scanner;

public class multiplication_table {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int number[] = new int[10];
		for(int i=0;i<10;i++) {
			number[i]=sc.nextInt();
			
		}
		for(int i=0;i<10;i++) {
			System.out.println("Multiplication table for " + number[i] + ":");
			for(int j=1;j<10;j++) {
				System.out.println(number[i] + " x " + j + " = " + (number[i] * j));
			}
			 System.out.println(); 
			
			
		}
		
	
  }

}
