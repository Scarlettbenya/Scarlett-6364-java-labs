package mcfadden.scarlett.lab2;

public class RockPaperScissors {
public enum Choice {
    ROCK, PAPER, SCISSORS;
}
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Invalid number of arguments. Please provide exactly two arguments.");
            return;
        }

        String player1 = args[0].toUpperCase();
        String player2 = args[1].toUpperCase();

        Choice player1Choice;
        Choice player2Choice;

        try {
            player1Choice = Choice.valueOf(player1);
            player2Choice = Choice.valueOf(player2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid choice(s). Valid choices are 'rock', 'paper', or 'scissors'.");
            return;
        }

        System.out.println("Player 1 chooses: " + player1.toLowerCase());
        System.out.println("Player 2 chooses: " + player2.toLowerCase());

        if (player1Choice == player2Choice) {
            System.out.println("It's a tie!");
        } else if (
            (player1Choice == Choice.ROCK && player2Choice == Choice.SCISSORS) ||
            (player1Choice == Choice.SCISSORS && player2Choice == Choice.PAPER) ||
            (player1Choice == Choice.PAPER && player2Choice == Choice.ROCK)
        ) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }
}
