package Methods;

import java.util.Scanner;

public class NumberCheckerUtility {
    
    public static int countDigits(int number) {
    	if (number == 0) return 1; 
        int count = 0;
        number = Math.abs(number);
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] getDigitsArray(int number) {
    	    number = Math.abs(number); 
    	    int count = 0;
    	    int temp = number;
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
    	        digits[i] = number % 10;
    	        number /= 10;
    	    }

    	    return digits;
    	}

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] digitFrequencies(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;
            result[i][1] = freq[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        int[] digits = getDigitsArray(number);

        System.out.println("Count of digits: " + countDigits(number));
        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + sumOfSquares(digits));
        System.out.println("Is Harshad number? " + (isHarshadNumber(number, digits) ? "Yes" : "No"));

        System.out.println("Digit frequencies:");
        int[][] freq = digitFrequencies(digits);
        for (int[] pair : freq) {
            if (pair[1] > 0) {
                System.out.println("Digit " + pair[0] + ": " + pair[1] + " time(s)");
            }
        }

        sc.close();
    }
}

