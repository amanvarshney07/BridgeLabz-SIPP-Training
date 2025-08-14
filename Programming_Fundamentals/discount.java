package day_2;

public class discount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double fee = 125000;
        double discountPercent = 10;
        double discount = (discountPercent / 100) * fee;
        double finalFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);

	}

}
