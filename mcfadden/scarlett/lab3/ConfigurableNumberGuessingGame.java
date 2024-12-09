package mcfadden.scarlett.lab3;

import java.util.Scanner;

public class ConfigurableNumberGuessingGame {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int min = 0, max = 0, chances = 0; //กำหนดค่าตัวแปร

        System.out.print("Enter the min value:"); //รับค่า min
        min = x.nextInt();

        do{ //ตรวจสอบ max ถ้าน้อยกว่า min ให้รับค่าใหม่
            System.out.print("Enter the max value:");
            max = x.nextInt();
            if (max < min){
                System.out.println("The max value must be at least equal to the min value");
            }
        }while (max < min);
        do{ //ตรวจสอบโอกาสในการเล่น ถ้าน้อยกว่าหรือเท่ากับ0ให้รับค่าใหม่
            System.out.print("Enter the maximum number of tries:");
            chances = x.nextInt();
            if (chances < 1){
                System.out.println("The maximum number of tries must be greater than 0");
            }
        }while (chances < 1);

        System.out.println("Welcome to a number guessing game!");
        int number = min + (int)(Math.random() * ((max - min) + 1)); //สุ่มคำตอบ

        int i, guess; 
        for (i = 1; i <= chances; i++) {
            System.out.print("Enter an integer between " +  min + " and " + max + ":");
            guess = x.nextInt();
            if (guess < min || guess > max){ //ตรวจสอบค่าที่อยู่นอกช่วงคำตอบในการเดา และให้ป้อนคำตอบใหม่โดยไม่เสียโอกาส
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
                x.close();
                break;
            }
            else if (number > guess && i != chances) {
                System.out.println("Try a higher number!");

            }
            else if (number < guess && i != chances) {
                System.out.println("Try a lower number!");
            }
            if (i == chances) { //กรณีหมดโอกาส
                System.out.println("You have tried " + chances + " times. You ran out of guesses");
                System.out.println("The answer is " + number);
                x.close();
            }
        }
    }     
}