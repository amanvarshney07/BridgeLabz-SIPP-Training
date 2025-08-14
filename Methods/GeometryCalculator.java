package Methods;

import java.util.Scanner;

public class GeometryCalculator {

    
    public static double findEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void findLineEquation(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            System.out.println("This is a vertical line. Line equation: x = " + x1);
        } else {
            double m = (y2 - y1) / (x2 - x1);  // slope
            double b = y1 - m * x1;           // y-intercept
            System.out.println("Line Equation: y = " + m + "x + " + b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        double distance = findEuclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance: " + distance);

        findLineEquation(x1, y1, x2, y2);
    }
}
