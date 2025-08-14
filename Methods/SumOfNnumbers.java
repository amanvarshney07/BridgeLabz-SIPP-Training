package Methods;
import java.util.*;
public class SumOfNnumbers {
	public static int sumofNnumbers(int n) {
		int sum = n*(n+1)/2;
		return sum;
	}
	 public static void main(String[] args) {
	   Scanner sc= new Scanner(System.in);
	   
	   int n=sc.nextInt();
	   int sum = sumofNnumbers(n);
	   System.out.println(sum);
	 }
}
