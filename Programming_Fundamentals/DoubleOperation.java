package bridgelabz;
 import java.util.*;
public class DoubleOperation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter value for a: ");
		double a = scanner.nextDouble();

		System.out.print("Enter value for b: ");
		double b = scanner.nextDouble();

		System.out.print("Enter value for c: ");
		double c = scanner.nextDouble();

		double result1 = a + b * c;
		double result2 = a * b + c;
		double result3 = c + a / b;
		double result4 = a % b + c;

		System.out.println("The results of Double Operations are:");
        System.out.printf("a + b * c = %.2f\n", result1);
        System.out.printf("a * b + c = %.2f\n", result2);
        System.out.printf("c + a / b = %.2f\n", result3);
        System.out.printf("a %% b + c = %.2f\n", result4); 

        
        scanner.close();
	}
}
