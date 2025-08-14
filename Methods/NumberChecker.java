package Methods;

import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int count = countDigits(number);
        int[] digits = getDigits(number);
        boolean isDuck = isDuckNumber(digits);
        boolean isArmstrong = isArmstrongNumber(digits, number);
        int[] largestTwo = getTwoLargest(digits);
        int[] smallestTwo = getTwoSmallest(digits);

        System.out.println("Digit Count: " + count);

        System.out.print("Digits: ");
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i] + " ");
        }

        System.out.println("\nIs Duck Number? " + isDuck);
        System.out.println("Is Armstrong Number? " + isArmstrong);
        System.out.println("Largest: " + largestTwo[0] + ", Second Largest: " + largestTwo[1]);
        System.out.println("Smallest: " + smallestTwo[0] + ", Second Smallest: " + smallestTwo[1]);
    }

    public static int countDigits(int num) {
    	if (num == 0) return 1; 
        int count = 0;
        num = Math.abs(num);
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static int[] getDigits(int num) {
        num = Math.abs(num); 

        int count = 0;
        int temp = num;
        if (temp == 0) {
            count = 1;
        } else {
            while (temp > 0) {
                count++;
                temp /= 10;
            }
        }

        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }

        return digits;
    }


    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrongNumber(int[] digits, int originalNum) {
        int sum = 0;
        int power = digits.length;
        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow(digits[i], power);
        }
        return sum == originalNum;
    }

    public static int[] getTwoLargest(int[] digits) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > max1) {
                max2 = max1;
                max1 = digits[i];
            } else if (digits[i] > max2 && digits[i] != max1) {
                max2 = digits[i];
            }
        }
        if (max2 == Integer.MIN_VALUE) max2 = max1;
        return new int[]{max1, max2};
    }

    public static int[] getTwoSmallest(int[] digits) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < min1) {
                min2 = min1;
                min1 = digits[i];
            } else if (digits[i] < min2 && digits[i] != min1) {
                min2 = digits[i];
            }
        }
        if (min2 == Integer.MAX_VALUE) min2 = min1;
        return new int[]{min1, min2};
    }
}

