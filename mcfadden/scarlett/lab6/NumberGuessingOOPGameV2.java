//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//โปรแกรมนี้แสดง โปรแกรม NumberGuessingOOPGameV2 เป็นเกมทายหมายเลขที่ใช้หลักการเขียนโปรแกรมเชิงวัตถุ (OOP) โดยมีการใช้งานคลาส GuessGameV2 สำหรับการทำงานหลักของเกม โปรแกรมนี้จะให้ผู้เล่นสามารถกำหนดค่าต่างๆ ที่ใช้ในการเล่นเกมได้ เช่น ช่วงของตัวเลขที่สามารถทายได้และจำนวนครั้งที่อนุญาตให้ทาย
//last update: 20/01/2025
package mcfadden.scarlett.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGameV2 {
     
    public static Scanner input = new Scanner(System.in); // สร้าง Scanner สำหรับรับข้อมูลจากผู้ใช้
    private GuessGameV2 game; // ตัวแปรอ้างอิงถึงเกม GuessGameV2
    private int min, max, maxTries; // ตัวแปรสำหรับเก็บค่าต่ำสุด, ค่าสูงสุด และจำนวนครั้งที่อนุญาตให้เดา

    public void configure() {
        do {
            System.out.print("Enter the min value: "); // ขอค่าต่ำสุดจากผู้ใช้
            min = input.nextInt(); // รับค่าต่ำสุด
            System.out.print("Enter the max value: "); // ขอค่าสูงสุดจากผู้ใช้
            max = input.nextInt(); // รับค่าสูงสุด
            if (max < min) { // ตรวจสอบว่าค่าสูงสุดน้อยกว่าค่าต่ำสุดหรือไม่
                System.out.println("max must be greater than or equal to min."); // แสดงข้อความแจ้งข้อผิดพลาด
            }
        } while (max < min); // ทำซ้ำจนกว่าค่าสูงสุดจะมากกว่าหรือเท่ากับค่าต่ำสุด

        do {
            System.out.print("Enter the maximum number of tries: "); // ขอจำนวนครั้งที่สามารถเดาได้สูงสุด
            maxTries = input.nextInt(); // รับจำนวนครั้งที่อนุญาตให้เดา
            if (maxTries <= 0) { // ตรวจสอบว่าจำนวนครั้งน้อยกว่าหรือเท่ากับ 0 หรือไม่
                System.out.println("maxTries must be greater than 0."); // แสดงข้อความแจ้งข้อผิดพลาด
            }
        } while (maxTries <= 0); // ทำซ้ำจนกว่าจำนวนครั้งจะมากกว่า 0
        this.game = new GuessGameV2(min, max, maxTries); // สร้างเกมใหม่ด้วยค่าที่กำหนด
    }

    public void playGames() {
        boolean playAgain; // ตัวแปรสำหรับตรวจสอบว่าผู้ใช้ต้องการเล่นอีกหรือไม่
        do {
            System.out.println(game); // แสดงข้อมูลของเกมปัจจุบัน
            boolean result = this.game.playSingleGame(); // เล่นเกมหนึ่งรอบและเก็บผลลัพธ์
            System.out.println(result ? "You win!" : "Better luck next time."); // แสดงผลว่าชนะหรือแพ้
            System.out.print("Do you want to play again? (y/n): "); // ถามผู้ใช้ว่าต้องการเล่นอีกหรือไม่
            playAgain = input.next().equalsIgnoreCase("y"); // รับคำตอบจากผู้ใช้
            if (playAgain) {
                configure(); // ถ้าผู้ใช้ต้องการเล่นอีก ให้กำหนดค่าเกมใหม่
            }
        } while (playAgain); // เล่นเกมซ้ำจนกว่าผู้ใช้จะเลือกไม่เล่นอีก

        System.out.println("Thank you for playing the Number Guessing Game!"); // ขอบคุณผู้เล่นหลังจบเกม
    }

    public static void main(String[] args) {
        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2(); // สร้างอินสแตนซ์ของเกม
        program.configure(); // กำหนดค่าเกม
        program.playGames(); // เริ่มเล่นเกม
    }
}


