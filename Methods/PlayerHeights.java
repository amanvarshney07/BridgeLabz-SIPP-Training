package Methods;

import java.util.Scanner;

public class PlayerHeights {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[11];

        System.out.println("Enter the heights");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = sc.nextInt();
        }

        int sum = getSum(heights);
        double mean = getMean(sum, heights.length);
        int min = getShortest(heights);
        int max = getTallest(heights);

        System.out.println("\nShortest Height: " + min + " cm");
        System.out.println("Tallest Height: " + max + " cm");
        System.out.printf("Mean Height: %.2f cm\n", mean);
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static double getMean(int sum, int count) {
        return (double) sum / count;
    }

    public static int getShortest(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static int getTallest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
}
