package mcfadden.scarlett.lab4;

import java.util.Scanner;

public class NumberGuessingMethodGamesV3 {
    static int number; // Randomly generated number
    static int min, max, chances; // Range and number of attempts
    static int[] guesses; // Array to store guesses
    static int totalGames = 0, totalWins = 0, totalGuesses = 0, highScore = Integer.MAX_VALUE; // Statistics
    static Scanner x = new Scanner(System.in);

    public static void configure() {
        System.out.print("Enter the min value: ");
        min = x.nextInt();
        do {
            System.out.print("Enter the max value: ");
            max = x.nextInt();
            if (max < min) {
                System.out.println("The max value must be at least equal to the min value.");
            }
        } while (max < min);

        do {
            System.out.print("Enter the maximum number of tries: ");
            chances = x.nextInt();
            if (chances <= 0) {
                System.out.println("The maximum number of tries must be greater than 0.");
            }
        } while (chances <= 0);

        guesses = new int[chances];
    }

    public static void genAnswer() {
        number = min + (int) (Math.random() * (max - min + 1));
    }

    public static boolean playGame() {
        genAnswer();
        System.out.println("Welcome to a number guessing game!");
        int i, guess;
        boolean win = false;

        for (i = 0; i < chances; i++) {
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            guess = x.nextInt();

            if (guess < min || guess > max) {
                System.out.println("The number must be between " + min + " and " + max);
                i--;
                continue;
            }

            guesses[i] = guess;
            totalGuesses++;

            if (number == guess) {
                System.out.println("Congratulations!");
                System.out.println("You guessed it in " + (i + 1) + " attempts.");
                win = true;
                totalWins++;
                if (i + 1 < highScore) {
                    highScore = i + 1; // Update high score
                }
                break;
            } else if (number > guess) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        }

        if (!win) {
            System.out.println("You ran out of guesses. The answer was " + number);
        }

        totalGames++;
        displayGameLog(win, i + 1);
        return win;
    }

    public static void displayGameLog(boolean win, int numTries) {
        System.out.println("Game log: Answer: " + number + ", Guesses: " + numTries + ", Win: " + win);
    }

    public static void displayAllGamesStats() {
        System.out.println("===== All Games Stats =====");
        System.out.println("Total games played: " + totalGames);
        System.out.println("Total games won: " + totalWins);
        System.out.printf("Win ratio: %.2f%%\n", (totalWins / (double) totalGames) * 100);
        System.out.printf("Average number of guesses per game: %.2f\n", (totalGuesses / (double) totalGames));
        if (highScore == Integer.MAX_VALUE) {
            System.out.println("High score: No winning games yet.");
        } else {
            System.out.println("High score (fewest guesses in a winning game): " + highScore);
        }
    }

    public static void displayGuessesLoop() {
        char option;
        do {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any key to quit: ");
            option = x.next().charAt(0);

            if (option == 'a') {
                displayGuesses();
            } else if (option == 'g') {
                System.out.print("Enter the guess number to view: ");
                int n = x.nextInt();
                if (n > 0 && n <= chances && guesses[n - 1] != 0) {
                    System.out.println("Guess " + n + ": " + guesses[n - 1]);
                } else {
                    System.out.println("Invalid guess number.");
                }
            }
        } while (option == 'a' || option == 'g');
    }

    public static void displayGuesses() {
        for (int i = 0; i < guesses.length && guesses[i] != 0; i++) {
            System.out.println("Guess " + (i + 1) + ": " + guesses[i]);
        }
    }

    public static void playGames() {
        boolean quitGame = true;
        do {
            playGame();
            displayGuessesLoop();
            System.out.print("Want to play again (Y or y): ");
            String reply = x.next();
            if (!reply.equalsIgnoreCase("y")) {
                quitGame = false;
                displayAllGamesStats();
                System.out.println("Thank you for playing our games. Bye!");
            }
        } while (quitGame);
    }

    public static void main(String[] args) {
        configure();
        playGames();
        x.close();
    }
}

