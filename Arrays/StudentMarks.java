package Arrays;
import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int num = sc.nextInt();
        int[][] marks = new int[num][3];
        double[] percentage = new double[num];
        char[] grade = new char[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";

                System.out.print(subject + ": ");
                int mark = sc.nextInt();

                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid input. Please enter a value between 0 and 100.");
                    j--;
                } else {
                    marks[i][j] = mark;
                }
            }
        }
        for (int i = 0; i < num; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 80) grade[i] = 'B';
            else if (percentage[i] >= 70) grade[i] = 'C';
            else if (percentage[i] >= 60) grade[i] = 'D';
            else grade[i] = 'F';
        }

        
        System.out.println("\nStudent Report:");
        for (int i = 0; i < num; i++) {
            System.out.println("Student " + (i + 1) +
                " - Physics: " + marks[i][0] +
                ", Chemistry: " + marks[i][1] +
                ", Maths: " + marks[i][2] +
                ", Percentage: " + String.format("%.2f", percentage[i]) + "%" +
                ", Grade: " + grade[i]);
        }

        sc.close();
    }
}
