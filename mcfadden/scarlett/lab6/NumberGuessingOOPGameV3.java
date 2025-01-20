//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//โปรแกรมนี้แสดง NumberGuessingOOPGameV3 เป็นเวอร์ชันที่พัฒนาขึ้นของเกมทายหมายเลข โดยใช้หลักการของการเขียนโปรแกรมเชิงวัตถุ (Object-Oriented Programming) และเพิ่มฟังก์ชันการทำงานใหม่ๆ เช่น การบันทึกประวัติการเล่นเกมและการให้ตัวเลือกมากขึ้นในการโต้ตอบกับผู้ใช้
//last update: 20/01/2025
package mcfadden.scarlett.lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberGuessingOOPGameV3 {

    public static Scanner input = new Scanner(System.in); // สร้าง Scanner สำหรับรับข้อมูลจากผู้ใช้
    private int min, max, maxTries; // ตัวแปรเก็บค่าต่ำสุด ค่าสูงสุด และจำนวนครั้งที่อนุญาตให้เดา
    private ArrayList<GuessGameV3> gameRecords = new ArrayList<>(); // อาร์เรย์ลิสต์สำหรับเก็บประวัติของเกม

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
        GuessGameV3 newGame = new GuessGameV3(min, max, maxTries); // สร้างเกมใหม่
        gameRecords.add(newGame); // เพิ่มเกมใหม่ไปยังประวัติ
    }

    public void playGames() {
        configure(); // เริ่มต้นเกมใหม่
        GuessGameV3 currentGame = gameRecords.get(gameRecords.size() - 1); // ดึงเกมล่าสุดจากประวัติ
        currentGame.playSingleGame(); // เล่นเกมหนึ่งรอบ
        boolean quit = false; // ตัวแปรตรวจสอบว่าผู้ใช้ต้องการออกจากเกมหรือไม่

        while (!quit) {
            System.out.println("Do you want to:"); // เมนูให้ผู้ใช้เลือก
            System.out.println("1. Play again");
            System.out.println("2. View game records");
            System.out.println("3. Quit");

            int choice = input.nextInt(); // รับคำเลือกจากผู้ใช้
            switch (choice) {
                case 1:
                    playGames(); // ถ้าผู้ใช้เลือกเล่นใหม่ เริ่มเล่นเกมอีกครั้ง
                    break;
                case 2:
                    viewRecords(); // ถ้าผู้ใช้เลือกดูประวัติเกม แสดงประวัติของเกม
                    break;
                case 3:
                    System.out.println("Thank you for playing the Number Guessing Game!"); // ขอบคุณผู้เล่นก่อนออกจากเกม
                    System.exit(0); // ออกจากโปรแกรม
                default:
                    System.out.println("Invalid choice. Please try again."); // ถ้าผู้ใช้เลือกไม่ถูกต้อง
            }
        }
    }

    public void viewRecords() {
        System.out.println("View:"); // เมนูให้ผู้ใช้เลือกดูประวัติ
        System.out.println("1. Complete Records");
        System.out.println("2. Specific Game Record");

        int choice = input.nextInt(); // รับคำเลือกจากผู้ใช้
        switch (choice) {
            case 1:
                System.out.println("Complete Records:"); // แสดงประวัติทั้งหมด
                for (int i = 0; i < gameRecords.size(); i++) {
                    System.out.println("Game " + (i + 1) + ": " + gameRecords.get(i).getGameLog()); // แสดงประวัติของเกมแต่ละเกม
                }
                break;
            case 2:
                System.out.print("Enter the game number to view: "); // ถามผู้ใช้เลขของเกมที่ต้องการดู
                int gameNumber = input.nextInt(); // รับหมายเลขเกม
                if (gameNumber > 0 && gameNumber <= gameRecords.size()) {
                    System.out.println(gameRecords.get(gameNumber - 1).getGameLog()); // แสดงข้อมูลของเกมที่เลือก
                } else {
                    System.out.println("Invalid game number."); // ถ้าเลขเกมไม่ถูกต้อง
                }
                break;
            default:
                System.out.println("Invalid choice. Please try again."); // ถ้าผู้ใช้เลือกไม่ถูกต้อง
        }
    }

    public static void main(String[] args) {
        NumberGuessingOOPGameV3 program = new NumberGuessingOOPGameV3(); // สร้างอินสแตนซ์ของเกม
        program.playGames(); // เริ่มเล่นเกม
    }
}
