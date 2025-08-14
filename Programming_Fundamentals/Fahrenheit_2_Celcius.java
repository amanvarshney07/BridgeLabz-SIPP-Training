package bridgelabz;
import java.util.*;
public class Fahrenheit_2_Celcius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("temp. in fahrenheit: ");
		int a =	sc.nextInt();
		int b = (a-32)* 5/9;
		System.out.println("temp. in celcius:" + b);

	}

}
