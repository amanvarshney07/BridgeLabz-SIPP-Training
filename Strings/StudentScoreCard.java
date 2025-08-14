package Strings;

import java.util.*;

public class StudentScoreCard {

    static final int SUBJECTS = 3;
    static final String[] SUBJECT_NAMES = {"Physics", "Chemistry", "Math"};
    static final String[] STUDENT_NAMES = {"Alice", "Bob", "Charlie", "David", "Eva"};

    public static int[][] generateScores(int studentCount) {
        Random rand = new Random();
        int[][] scores = new int[studentCount][SUBJECTS];
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < SUBJECTS; j++) {
                scores[i][j] = rand.nextInt(90) + 10; 
            }
        }
        return scores;
    }
    public static double[][] calculatePercentage(int[][] scores) {
        int studentCount = scores.length;
        double[][] result = new double[studentCount][3]; 
        for (int i = 0; i < studentCount; i++) {
            int total = 0;
            for (int j = 0; j < SUBJECTS; j++) {
                total += scores[i][j];
            }
            double average = total / (double) SUBJECTS;
            double percentage = Math.round((total / (SUBJECTS * 100.0)) * 10000) / 100.0;
            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = percentage;
        }
        return result;
    }
    public static char[] calculateGrades(double[][] percentages) {
        char[] grades = new char[percentages.length];
        for (int i = 0; i < percentages.length; i++) {
            double percent = percentages[i][2];
            if (percent >= 80)
                grades[i] = 'A';
            else if (percent >= 70)
                grades[i] = 'B';
            else if (percent >= 60)
                grades[i] = 'C';
            else if (percent >= 50)
                grades[i] = 'D';
            else if (percent >= 40)
                grades[i] = 'E';
            else
                grades[i] = 'R';
        }
        return grades;
    }
    public static void displayScorecard(int[][] scores, double[][] percents, char[] grades) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n", 
                          "Name", "Physics", "Chemistry", "Math", "Total", "Average", "Percent", "Grade");
        System.out.println("----------------------------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10s ", STUDENT_NAMES[i]);
            for (int j = 0; j < SUBJECTS; j++) {
                System.out.printf("%-10d ", scores[i][j]);
            }
            System.out.printf("%-10.0f %-10.2f %-10.2f %-10c%n",
                              percents[i][0], percents[i][1], percents[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        int studentCount = STUDENT_NAMES.length;

        int[][] scores = generateScores(studentCount);
        double[][] results = calculatePercentage(scores);
        char[] grades = calculateGrades(results);

        displayScorecard(scores, results, grades);
    }
}

