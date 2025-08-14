package Methods;
import java.util.*;
public class Smallest_largest {
    public static int[] smallOrlarge(int a,int b,int c) {
    	int smallest = Math.min(a, Math.min(b, c));
    	int largest = Math.max(a, Math.max(b,c));
    	return new int[] {smallest,largest};
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c= sc.nextInt();
		
		int[] result = smallOrlarge(a,b,c);
		System.out.println("Smallest number is: " + result[0]);
        System.out.println("Largest number is: " + result[1]);

	}

}
