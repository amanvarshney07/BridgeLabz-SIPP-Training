package day_2;
import java.util.*;
public class discount_perc {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int fee=sc.nextInt();
		double discountPercent =sc.nextInt();
		double discount = (discountPercent / 100) * fee;
		double finalFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);

		
	}

}
