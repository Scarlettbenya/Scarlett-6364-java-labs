package mcfadden.scarlett.lab4;

import java.util.Scanner;

public class NumberGuessingMethodGamesV2 {
    static final int MAX_TRIES = 10; // Maximum tries
    static int[] guesses = new int[MAX_TRIES]; // Array to store guesses
    static int numTries = 0; // Number of attempts made

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to a number guessing game!");
            System.out.print("Enter the min value: ");
            int min = sc.nextInt();
            System.out.print("Enter the max value: ");
            int max = sc.nextInt();

            System.out.print("Enter the maximum number of tries: ");
            int maxTries = sc.nextInt();
            int target = (int) (Math.random() * (max - min + 1)) + min;

            numTries = 0; // Reset guesses count
            boolean guessedCorrectly = false;

            while (numTries < maxTries) {
                System.out.printf("Enter an integer between %d and %d: ", min, max);
                int guess = sc.nextInt();
                guesses[numTries++] = guess; // Store guess

                if (guess > target) {
                    System.out.println("Try a lower number!");
                } else if (guess < target) {
                    System.out.println("Try a higher number!");
                } else {
                    System.out.println("Congratulations!");
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts! Better luck next time.");
            }

            displayGuessesLoop(sc); // Allow reviewing guesses

            System.out.print("Want to play again (Y or y): ");
            char choice = sc.next().charAt(0);
            playAgain = (choice == 'Y' || choice == 'y');
        }

        System.out.println("Thank you for playing our games. Bye!");
        sc.close();
    }

    // Method to display all guesses
    public static void displayGuesses() {
        for (int i = 0; i < numTries; i++) {
            System.out.println("Guess " + (i + 1) + ": " + guesses[i]);
        }
    }

    // Method for interactive review of guesses
    public static void displayGuessesLoop(Scanner sc) {
        char choice;
        do {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
            choice = sc.next().charAt(0);

            if (choice == 'a') {
                displayGuesses();
            } else if (choice == 'g') {
                System.out.print("Enter the guess number: ");
                int guessNumber = sc.nextInt();
                if (guessNumber >= 1 && guessNumber <= numTries) {
                    System.out.println("Guess " + guessNumber + ": " + guesses[guessNumber - 1]);
                } else {
                    System.out.println("Invalid guess number!");
                }
            }
        } while (choice == 'a' || choice == 'g');
    }
}


