package String.class_problems;


import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter Rock, Paper, or Scissors: ");
            String player = sc.nextLine().trim();

            if (!player.equalsIgnoreCase("Rock") &&
                !player.equalsIgnoreCase("Paper") &&
                !player.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move! Try again.");
                i--;
                continue;
            }

            player = player.substring(0, 1).toUpperCase()
                    + player.substring(1).toLowerCase();

            String computer = moves[random.nextInt(3)];

            playerMoves[i] = player;
            computerMoves[i] = computer;

            if (player.equals(computer)) {
                results[i] = "Draw";
                draws++;
            } else if (
                (player.equals("Rock") && computer.equals("Scissors")) ||
                (player.equals("Paper") && computer.equals("Rock")) ||
                (player.equals("Scissors") && computer.equals("Paper"))
            ) {
                results[i] = "Win";
                wins++;
            } else {
                results[i] = "Loss";
                losses++;
            }

            System.out.println("Computer's Move: " + computer);
            System.out.println("Result: " + results[i]);
        }

        System.out.println("\n========== FINAL SCOREBOARD ==========");
        System.out.printf("%-10s %-15s %-18s %-10s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%-10d %-15s %-18s %-10s%n",
                    i + 1, playerMoves[i],
                    computerMoves[i], results[i]);
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("\nTotal Wins   : " + wins);
        System.out.println("Total Losses : " + losses);
        System.out.println("Total Draws  : " + draws);
        System.out.printf("Win Percentage: %.2f%%%n", winPercentage);

        sc.close();
    }
}
