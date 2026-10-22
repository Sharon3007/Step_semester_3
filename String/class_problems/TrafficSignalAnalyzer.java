package String.class_problems;


import java.util.Scanner;

public class TrafficSignalAnalyzer {

    static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Signal log is empty.");
            return;
        }

        int currentStreak = 1;
        int longestStreak = 1;

        char currentColor = signalLog.charAt(0);
        char longestColor = currentColor;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak Color: " + longestColor);
        System.out.println("Longest Streak Length: " + longestStreak);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log (R, Y, G): ");
        String signalLog = sc.nextLine().toUpperCase();

        findLongestStreak(signalLog);

        sc.close();
    }
}

