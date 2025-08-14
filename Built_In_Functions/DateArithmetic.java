package Built_In_Functions;

import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dateInput = sc.nextLine(); 
        LocalDate date = LocalDate.parse(dateInput);

        LocalDate addedDate = date.plusDays(7).plusMonths(1).plusYears(2);
        LocalDate finalDate = addedDate.minusWeeks(3);

        System.out.println("Original Date: " + date);
        System.out.println("After adding 7 days, 1 month, and 2 years: " + addedDate);
        System.out.println("After subtracting 3 weeks: " + finalDate);
    }
}

