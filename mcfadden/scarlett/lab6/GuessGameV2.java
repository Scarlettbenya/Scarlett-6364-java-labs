//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//last update: 10/01/2025
package mcfadden.scarlett.lab6;

import java.util.Scanner;

public class GuessGameV2 extends GuessGame { // คลาส GuessGameV2 ที่สืบทอดคุณสมบัติจากคลาส GuessGame
    private int Guesses; // ตัวแปรเก็บจำนวนครั้งที่ผู้เล่นได้เดา
    public static Scanner scanner = new Scanner(System.in); // ใช้รับข้อมูลจากผู้เล่นผ่านคีย์บอร์ด

    public GuessGameV2() { // ตัวสร้างแบบไม่มีพารามิเตอร์
        super(); // เรียกใช้ตัวสร้างของคลาสแม่ GuessGame
    }

    public GuessGameV2(int min, int max, int maxTries) { // ตัวสร้างแบบกำหนดค่าเริ่มต้น
        super(min, max, maxTries); // เรียกใช้ตัวสร้างของคลาสแม่และกำหนดค่า min, max, maxTries
    }

    public void configureGame(int min, int max, int maxTries, int attempts, int answer) {     
        // ฟังก์ชันสำหรับตั้งค่าคอนฟิกเกมใหม่
        setMin(min); // กำหนดค่าต่ำสุด
        setMax(max); // กำหนดค่าสูงสุด
        setMaxTries(maxTries); // กำหนดจำนวนครั้งสูงสุด
        setAnswer(answer); // กำหนดคำตอบ
        setAttempts(attempts); // กำหนดจำนวนครั้งที่เดาเริ่มต้น
    }

    public boolean playSingleGame() { // ฟังก์ชันสำหรับเล่นเกมครั้งเดียว
        generateAnswer(); // สร้างคำตอบแบบสุ่มใหม่
        System.out.println("Welcome to the Guessing Game V2!"); // แสดงข้อความต้อนรับผู้เล่น
    
        // วนลูปให้ผู้เล่นเดาจนกว่าจะถึงจำนวนครั้งสูงสุด
        while (getAttempts() < getMaxTries()) {
            // แสดงข้อความขอให้ผู้เล่นป้อนเลขในช่วงที่กำหนด
            System.out.print("Enter an integer between " + getMin() + " and " + getMax() + ": ");
            int guess = scanner.nextInt(); // รับค่าตัวเลขที่ผู้เล่นเดา
            setAttempts(getAttempts() + 1); // เพิ่มตัวนับจำนวนครั้งที่ผู้เล่นเดา

            if (guess == getAnswer()) { // ตรวจสอบว่าผู้เล่นเดาตรงกับคำตอบหรือไม่
                // หากเดาถูก แสดงข้อความแสดงความยินดี
                System.out.println("Congratulations! You've guessed the number in " + getAttempts() + " attempts.");
                return true; // สิ้นสุดเกมและคืนค่า true เพื่อบอกว่าชนะ
            } else if (guess < getAnswer()) { 
                // หากตัวเลขที่เดาน้อยกว่าคำตอบ แนะนำให้เดาตัวเลขที่สูงขึ้น
                System.out.println("Try a higher number!");
            } else { 
                // หากตัวเลขที่เดามากกว่าคำตอบ แนะนำให้เดาตัวเลขที่ต่ำลง
                System.out.println("Try a lower number!");
            }
            Guesses += getAttempts(); // เพิ่มจำนวนครั้งที่ผู้เล่นได้เดาเข้าไปใน Guesses
        }

        // หากผู้เล่นใช้จำนวนครั้งที่เดาสูงสุดแล้วแต่ยังไม่ถูก แสดงข้อความเฉลยคำตอบ
        System.out.println("Sorry, you've used all your attempts. The correct answer was: " + getAnswer());
        return false; // คืนค่า false เพื่อบอกว่าแพ้
    }

    public String toString() { // ฟังก์ชันสำหรับแสดงค่าการตั้งค่าของเกมในรูปแบบข้อความ
        return "Game Configuration: [Min: " + getMin() + ", Max: " + getMax() + ", MaxTries: " + getMaxTries() + ", Attempts: " + getAttempts() + "]";
    }
}

