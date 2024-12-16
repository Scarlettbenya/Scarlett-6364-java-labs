package mcfadden.scarlett.lab4;
import java.util.Scanner;

public class NumberGuessingMethodGames {
    static int number;
    static int min, max, chances;
    static Scanner x = new Scanner(System.in);
    
    public static void configure( ) { //กำหนดค่าเริ่มต้นของเกม
        Scanner x = new Scanner(System.in);
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
    }
    public static void genAnswer() { //สุ่มตัวเลขที่ผู้เล่นต้องทายให้อยู่ในช่วง min ถึง max
        number = min + (int) (Math.random() * (max - min + 1));

    }
    public static void playGame() { //เป็นส่วนหลักของเกมที่ทำให้ผู้เล่นได้ทายตัวเลข โดยมีการวนลูปสำหรับการทาย และสามารถเล่นซ้ำได้
        char playagain;
        do {
            genAnswer();
            System.out.println("Welcome to a number guessing game!");
            int i, guess;
            for (i = 1; i <= chances; i++) {
                System.out.print("Enter an integer between " +  min + " and " + max + ":");
                guess = x.nextInt();
                if (guess < min || guess > max){
                    i -= 1 ;
                    System.out.println("The number must be between " + min + " and " + max);
                }
                else if (number == guess ) {
                    System.out.println("Congratulations!");
                    if (i == 1) {
                        System.out.println("You have tried 1 time");
                    }
                    else {
                       System.out.println("You have tried " + i + " times");
                    }
                    break;
                }
                else if (number > guess && i != chances) {
                    System.out.println("Try a higher number!");

                }
                else if (number < guess && i != chances) {
                    System.out.println("Try a lower number!");
                }
                if (i == chances) {
                    System.out.println("You have tried " + chances + " times. You ran out of guesses");
                    System.out.println("The answer is " + number);
                }
            } 

            System.out.print("Do you want to play again? (y/Y to continue): ");
            playagain = x.next().charAt(0);
        } while (playagain == 'y' || playagain == 'Y');

        System.out.println("Thank you for playing our games. Bye!");
        x.close();
    }
    public static void main(String[] args) { //เป็นจุดเริ่มต้นของโปรแกรม เรียกใช้เมธอด configure() เพื่อตั้งค่า และเริ่มเล่นเกมด้วยการเรียก playGame()
        configure();
        playGame();
    }   
}
