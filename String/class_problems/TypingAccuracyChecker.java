package String.class_problems;


import java.util.Scanner;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: Both strings must have equal length.");
            return;
        }

        int matches = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy;

        if (original.length() == 0) {
            accuracy = 100.0;
        } else {
            accuracy = (matches * 100.0) / original.length();
        }

        System.out.println("\nTotal Characters: " + original.length());
        System.out.println("Matching Characters: " + matches);
        System.out.printf("Accuracy: %.2f%%%n", accuracy);

        if (firstMismatch == -1) {
            System.out.println("No mismatches found. Perfect typing!");
        } else {
            System.out.println("First mismatch position: "
                    + (firstMismatch + 1));
            System.out.println("Expected character: "
                    + original.charAt(firstMismatch));
            System.out.println("Typed character: "
                    + typed.charAt(firstMismatch));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}
