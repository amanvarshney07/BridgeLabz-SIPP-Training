package Arrays;
import java.util.Scanner;

public class Employee_bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int EMPLOYEES = 10;

        double[] salary = new double[EMPLOYEES];
        double[] years = new double[EMPLOYEES];
        double[] bonus = new double[EMPLOYEES];
        double[] newSalary = new double[EMPLOYEES];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < EMPLOYEES; i++) {
            System.out.println("Employee " + (i + 1));
            System.out.print("Enter salary: ");
            double sal = sc.nextDouble();
            System.out.print("Enter years of service: ");
            double yr = sc.nextDouble();

            if (sal <= 0 || yr < 0) {
                System.out.println("Invalid input. Try again.");
                i--;
                continue;
            }

            salary[i] = sal;
            years[i] = yr;
        }

        for (int i = 0; i < EMPLOYEES; i++) {
            if (years[i] > 5)
                bonus[i] = salary[i] * 0.05;
            else
                bonus[i] = salary[i] * 0.02;

            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\nTotal Bonus Paid: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        sc.close();
    }
}

