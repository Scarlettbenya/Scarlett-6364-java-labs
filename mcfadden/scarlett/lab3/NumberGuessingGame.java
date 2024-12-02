package mcfadden.scarlett.lab3;

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Welcome to a number guessing game!");

        int min = 1;
        int max = 10;
        int number = min + (int)Math.random() * (max - min) + 1;
        int chances = 5 ;

        int i, guess;
        for (i = 1; i <= chances; i++) {
            System.out.print("Enter an integer between 1 and 10:");
            guess = x.nextInt();
            if (number == guess ) {
                System.out.println("Congratulations!");
                if (i == 1) {
                    System.out.println("You have tried 1 time");
                }
                else {
                    System.out.println("You have tried " + i + " times");
                }
                x.close();
                break;
            }
            else if (number > guess && i != chances) {
                System.out.println("Try a higher number!");

            }
            else if (number < guess && i != chances) {
                System.out.println("Try a lower number!");
            }
            if (i == chances) {
                System.out.println("You have tried 5 times. You ran out of guesses");
                System.out.println("The answer is " + number);
                x.close();
            }
        }
    } 
}
    
