package Methods;

import java.util.*;

public class Number_Check {
    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a == b) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        for (int num : arr) {
            if (isPositive(num)) {
                System.out.println(num + " is Positive and " + (isEven(num) ? "Even" : "Odd"));
            } else {
                System.out.println(num + " is Negative");
            }
        }

        int result = compare(arr[0], arr[4]);
        if (result == 1)
            System.out.println("First element is Greater than Last");
        else if (result == 0)
            System.out.println("First and Last elements are Equal");
        else
            System.out.println("First element is Less than Last");
    }
}

