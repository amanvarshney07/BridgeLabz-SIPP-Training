package Built_In_Functions;

import java.util.Scanner;

public class MaxOfThree {

    public static int readInteger(Scanner sc) {
        return sc.nextInt();
    }

    public static int findMax(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        int num1 = readInteger(sc);
        int num2 = readInteger(sc);
        int num3 = readInteger(sc);

        int max = findMax(num1, num2, num3);
        System.out.println("Maximum: " + max);
    }
}

