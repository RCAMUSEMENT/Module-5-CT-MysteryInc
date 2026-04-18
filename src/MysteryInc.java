import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ryley's Mystery Inc. Product Search - The Spooky Calculation
 * Student Name: Ryley Carlson
 * CSC372 Module 5 Discussion
 * Date: 2026-04-18
 * Description: Shaggy and Scooby are multiplying snacks before the ghost finds them!
 */
public class MysteryInc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- THE GHOST OF THE EMPTY PANTRY ---");
        System.out.println("Shaggy: \"Like, we gotta count these snacks fast, Scoob, before that ghost finds us!\"");

        try {
            // Start the chase! 5 doors to check.
            double totalSnacks = countSnacksRecursive(5, sc);

            if (totalSnacks > 0) {
                System.out.println("\nCase Closed! We got " + totalSnacks + " snacks! Time for a Scooby Snack!");
            } else {
                System.out.println("\nShaggy: \"Like, no snacks?! This is a nightmare!\"");
            }
        } catch (Exception e) {
            System.out.println("\n[Sound of a ghost rattling chains!]");
            System.out.println("Velma: \"Ruh-roh! The ghost caught up! Logic error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    /**
     * Recursive method: Each 'count' is a door Shaggy opens while running.
     */
    public static double countSnacksRecursive(int doorsLeft, Scanner sc) {
        // 1. THE BASE CASE: We made it to the end of the hallway!
        if (doorsLeft == 0) {
            System.out.println("\nScooby: \"Ree did it! No more doors!\"");
            return 1.0; // Return 1 so it doesn't change the multiplication total
        }

        try {
            System.out.println("\n[Shaggy opens door #" + doorsLeft + "...]");
            System.out.print("How many snacks are inside? ");
            double foundSnacks = sc.nextDouble();

            // 2. THE EARLY EXIT (The "Zero" Scare):
            if (foundSnacks == 0) {
                System.out.println("Shaggy: \"ZOINKS! This room is empty! It's a trap! Run back, Scoob!\"");
                return 0.0; // This multiplies everything by 0 and stops the search
            }

            System.out.println("Scooby: \"Rasty! " + foundSnacks + " snacks! Keep running!\"");

            // 3. THE RECURSIVE STEP:
            // Shaggy holds onto the snacks he found and runs to the next door.
            return foundSnacks * countSnacksRecursive(doorsLeft - 1, sc);

        } catch (InputMismatchException e) {
            // Daphne to the rescue when Shaggy fumbles the input
            System.out.println("Daphne: \"Jeepers, Shaggy! Put down the pizza and enter a real number!\"");
            sc.next(); // Clear the "ghost" input
            return countSnacksRecursive(doorsLeft, sc); // Stay at the same door and try again
        }
    }
}
