//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//โปรแกรมนี้แสดง โปรแกรม NumberGuessingOOPGame เป็นเกมทายหมายเลขที่ให้ผู้เล่นทายหมายเลขที่ระบบเลือกขึ้นจากช่วงที่กำหนด ผู้เล่นจะมีจำนวนครั้งในการทายที่จำกัด
//last update: 10/01/2025
package mcfadden.scarlett.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGame {
     
    public static Scanner input = new Scanner(System.in); // สร้าง Scanner สำหรับรับข้อมูลจากผู้ใช้
    private GuessGame game; // ตัวแปรอ้างอิงถึงเกม

    public void configure() {
        System.out.print("Enter the min value: "); // ขอค่าต่ำสุดจากผู้ใช้
        int min = input.nextInt(); // รับค่าต่ำสุด
        System.out.print("Enter the max value: "); // ขอค่าสูงสุดจากผู้ใช้
        int max = input.nextInt(); // รับค่าสูงสุด
        System.out.print("Enter the maximum number of tries: "); // ขอจำนวนครั้งที่สามารถเดาได้สูงสุด
        int maxTries = input.nextInt(); // รับจำนวนครั้งที่อนุญาตให้เดา

        this.game = new GuessGame(min, max, maxTries); // สร้างเกมใหม่ด้วยค่าที่กำหนด
    }

    public void playGames() {
        boolean playAgain; // ตัวแปรสำหรับตรวจสอบว่าผู้ใช้ต้องการเล่นอีกหรือไม่
        do {
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
        NumberGuessingOOPGame program = new NumberGuessingOOPGame(); // สร้างอินสแตนซ์ของเกม
        program.configure(); // กำหนดค่าเกม
        program.playGames(); // เริ่มเล่นเกม
    }
}

