package Methods;

import java.util.Scanner;

public class CollinearityChecker{

    public static boolean areCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        int slope1Numerator = y2 - y1;
        int slope1Denominator = x2 - x1;

        int slope2Numerator = y3 - y2;
        int slope2Denominator = x3 - x2;

        return slope1Numerator * slope2Denominator == slope2Numerator * slope1Denominator;
    }

    public static boolean areCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        int area = x1 * (y2 - y3) +
                   x2 * (y3 - y1) +
                   x3 * (y1 - y2);
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coordinates for 3 points:");

        System.out.print("x1: ");
        int x1 = sc.nextInt();
        System.out.print("y1: ");
        int y1 = sc.nextInt();

        System.out.print("x2: ");
        int x2 = sc.nextInt();
        System.out.print("y2: ");
        int y2 = sc.nextInt();

        System.out.print("x3: ");
        int x3 = sc.nextInt();
        System.out.print("y3: ");
        int y3 = sc.nextInt();

        boolean slopeCheck = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaCheck = areCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("\nUsing Slope Method: " + (slopeCheck ? "Points are collinear" : "Points are not collinear"));
        System.out.println("Using Area Method: " + (areaCheck ? "Points are collinear" : "Points are not collinear"));
    }
}

