package Strings;

import java.util.Scanner;

public class BMICalculator {

    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25) status = "Normal";
        else if (bmi < 30) status = "Overweight";
        else status = "Obese";
        return new String[]{toStringValue(bmi), status};
    }

    public static String toStringValue(double num) {
        int intPart = (int) num;
        double frac = num - intPart;
        int fracPart = (int)(frac * 100);
        return intPart + "." + (fracPart < 10 ? "0" + fracPart : "" + fracPart);
    }

    public static String[][] computeBMITable(double[][] data) {
        String[][] result = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double weight = data[i][0];
            double height = data[i][1];
            String[] bmiData = calculateBMI(weight, height);
            result[i][0] = toStringValue(height);
            result[i][1] = toStringValue(weight);
            result[i][2] = bmiData[0];
            result[i][3] = bmiData[1];
        }
        return result;
    }

    public static void displayTable(String[][] table) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1] + "\t\t" + table[i][2] + "\t" + table[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hwData = new double[10][2];
        for (int i = 0; i < 10; i++) {
            hwData[i][0] = sc.nextDouble();
            hwData[i][1] = sc.nextDouble();
        }
        String[][] bmiTable = computeBMITable(hwData);
        displayTable(bmiTable);
    }
}

