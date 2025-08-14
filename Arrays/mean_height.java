package Arrays;
import java.util.*;
public class mean_height {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	
	int arr[]=new int[11];
	for(int i=0;i<11;i++) {
		arr[i]=sc.nextInt();	
	}
	int sum=0;
	for(int i=0;i<11;i++) {
		sum +=arr[i];
	}
	int mean = sum/11;
	System.out.println(mean);

}
}
