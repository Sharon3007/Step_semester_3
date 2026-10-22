package String.class_problems;


import java.util.Scanner;

public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length ||
            sectionA.length == 0) {
            System.out.println("Invalid array sizes.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }

        System.out.println("\nSection A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        if (totalA == totalB) {
            System.out.println("Status: Balanced");
        } else {
            System.out.println("Status: Not Balanced");
        }

        int maxQuantity = sectionA[0];
        String maxSection = "Section A";
        int maxIndex = 0;

        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }

        System.out.println("Highest Quantity: " + maxQuantity);
        System.out.println("Section: " + maxSection);
        System.out.println("Index: " + maxIndex);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of item categories: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of categories must be positive.");
            sc.close();
            return;
        }

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        System.out.println("Enter quantities for Section A:");
        for (int i = 0; i < n; i++) {
            sectionA[i] = sc.nextInt();
        }

        System.out.println("Enter quantities for Section B:");
        for (int i = 0; i < n; i++) {
            sectionB[i] = sc.nextInt();
        }

        analyzeInventory(sectionA, sectionB);

        sc.close();
    }
}
