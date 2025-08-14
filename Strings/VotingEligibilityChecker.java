package Strings;

import java.util.Scanner;

public class VotingEligibilityChecker {

    public static int[] getStudentAges(int count) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            ages[i] = sc.nextInt();
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    public static void displayVotingTable(String[][] data) {
        System.out.println("Age\tCan Vote");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        int[] studentAges = getStudentAges(10);
        String[][] eligibility = checkVotingEligibility(studentAges);
        displayVotingTable(eligibility);
    }
}

