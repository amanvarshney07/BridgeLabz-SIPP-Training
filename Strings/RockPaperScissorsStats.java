package Strings;

import java.util.Scanner;

public class RockPaperScissorsStats {

    public static String getComputerChoice() {
        double r = Math.random();
        if (r < 0.33) return "rock";
        else if (r < 0.66) return "paper";
        else return "scissors";
    }

    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "draw";
        } else if (user.equals("rock") && computer.equals("scissors")) {
            return "user";
        } else if (user.equals("scissors") && computer.equals("paper")) {
            return "user";
        } else if (user.equals("paper") && computer.equals("rock")) {
            return "user";
        } else {
            return "computer";
        }
    }

    public static String[][] calculateStats(String[][] gameResults) {
        int userWins = 0, compWins = 0, draws = 0;
        for (int i = 0; i < gameResults.length; i++) {
            String result = gameResults[i][2];
            if (result.equals("user")) userWins++;
            else if (result.equals("computer")) compWins++;
            else draws++;
        }
        int total = gameResults.length;
        int userPercent = (userWins * 100) / total;
        int compPercent = (compWins * 100) / total;

        String[][] stats = new String[2][3];
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = userPercent + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = compPercent + "%";

        return stats;
    }

    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("\nGame\tUser\tComputer\tWinner");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i + 1) + "\t" + gameResults[i][0] + "\t" + gameResults[i][1] + "\t\t" + gameResults[i][2]);
        }

        System.out.println("\nSummary:");
        System.out.println("Player\tWins\tWin %");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[][] gameResults = new String[n][3];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String user = sc.nextLine().toLowerCase();
            String computer = getComputerChoice();
            String winner = findWinner(user, computer);
            gameResults[i][0] = user;
            gameResults[i][1] = computer;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(gameResults);
        displayResults(gameResults, stats);
    }
}

