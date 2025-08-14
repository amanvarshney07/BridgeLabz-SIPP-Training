package Arrays;
import java.util.*;
public class Store_digits {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int num=sc.nextInt();
	int maxdigit=10;
	int[] digits=new int[maxdigit];
	int index=0;
	while(num!=0 && index<maxdigit) {
		digits[index] = num%10;
		num/=10;
		index++;
	}
	 if (index == 0) {
         System.out.println("No digits found.");
         return;
     }
	 
	 int largest=-1;
	 int secondlargest=-1;
	 for(int i=0;i<digits.length;i++) {
		 if(digits[i]>largest) {
			 secondlargest=largest;
			 largest=digits[i];
		 }else if (digits[i] > secondlargest && digits[i] != largest) {
			 secondlargest=digits[i];
		 }
	 }
	 System.out.println(largest);
	 System.out.println(secondlargest);

	
	}
}
