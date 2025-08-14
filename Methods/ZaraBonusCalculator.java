package Methods;

import java.util.Random;

public class ZaraBonusCalculator {

    public static double[][] generateEmployeeData(int count) {
        double[][] data = new double[count][2];
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            data[i][0] = 10000 + rand.nextInt(90000);
            data[i][1] = rand.nextInt(11); 
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] empData) {
        double[][] result = new double[empData.length][2];

        for (int i = 0; i < empData.length; i++) {
            double salary = empData[i][0];
            double years = empData[i][1];
            double bonusPercent = years > 5 ? 0.05 : 0.02;
            double bonus = salary * bonusPercent;
            double newSalary = salary + bonus;

            result[i][0] = bonus;
            result[i][1] = newSalary;
        }
        return result;
    }

    public static void displayBonusTable(double[][] empData, double[][] bonusData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        System.out.println("Emp\tOldSalary\tYears\tBonus\t\tNewSalary");
        for (int i = 0; i < empData.length; i++) {
            double oldSal = empData[i][0];
            double yrs = empData[i][1];
            double bonus = bonusData[i][0];
            double newSal = bonusData[i][1];

            totalOldSalary += oldSal;
            totalNewSalary += newSal;
            totalBonus += bonus;

            System.out.printf("%d\t%.2f\t%.0f\t%.2f\t%.2f\n", i + 1, oldSal, yrs, bonus, newSal);
        }

        System.out.println("\nSummary:");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus Paid: %.2f\n", totalBonus);
    }

    public static void main(String[] args) {
        int numEmployees = 10;
        double[][] employeeData = generateEmployeeData(numEmployees);
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);
        displayBonusTable(employeeData, bonusData);
    }
}

