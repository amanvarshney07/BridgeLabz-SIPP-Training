package Methods;

import java.util.*;

public class BMICalculator {
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightMeters = data[i][1] / 100.0;
            double bmi = weight / (heightMeters * heightMeters);
            data[i][2] = bmi;
        }
    }

    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) status[i] = "Underweight";
            else if (bmi < 24.9) status[i] = "Normal";
            else if (bmi < 29.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] personData = new double[10][3];
        for (int i = 0; i < 10; i++) {
            personData[i][0] = sc.nextDouble(); 
            personData[i][1] = sc.nextDouble(); 
        }

        calculateBMI(personData);
        String[] bmiStatus = getBMIStatus(personData);

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ": Weight = " + personData[i][0] +
                    " kg, Height = " + personData[i][1] + " cm, BMI = " + personData[i][2] +
                    ", Status = " + bmiStatus[i]);
        }
    }
}

