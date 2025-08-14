package Methods;
import java.util.*;
public class TrigonometryCalculator {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        
        double[] trigValues = calculateTrigonometricFunctions(angle);
        
        System.out.println("Sine: " + trigValues[0]);
        System.out.println("Cosine: " + trigValues[1]);
        System.out.println("Tangent: " + trigValues[2]);

	}
	public static double[] calculateTrigonometricFunctions(double angle) {
		double radians = Math.toRadians(angle);
		double[] results = new double[3];
        results[0] = Math.sin(radians);
        results[1] = Math.cos(radians);
        results[2] = Math.tan(radians);
        return results;
		
	}

}
