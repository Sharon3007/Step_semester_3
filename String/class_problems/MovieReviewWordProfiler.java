package String.class_problems;


import java.util.Scanner;

public class MovieReviewWordProfiler {

    static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            int length = cleanWord.length();

            if (length == 0) {
                continue;
            }

            if (length <= 4) {
                shortCount++;
            } else if (length <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("\nWord Length Profile");
        System.out.println("Short Words (1-4 letters): " + shortCount);
        System.out.println("Medium Words (5-8 letters): " + mediumCount);
        System.out.println("Long Words (9+ letters): " + longCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        classifyWordLengths(review);

        sc.close();
    }
}

