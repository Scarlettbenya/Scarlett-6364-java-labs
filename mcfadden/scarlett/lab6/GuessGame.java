//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//last update: 10/01/2025
package mcfadden.scarlett.lab6;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    private int min; //กำหนดตัวแปร
    private int max;
    private int maxTries;
    private int answer;
    private int attempts;
    private int[] guesses;

    public static Scanner scanner = new Scanner(System.in); //ใช้รับข้อมูลจากผู้เล่น

    public GuessGame() {
        this(1, 100, 10); // กำหนดค่าเริ่มต้นของเกม หากไม่มีการกำหนดค่าใหม่
    }

    public GuessGame(int min, int max, int maxTries) { // ตัวสร้าง (Constructor) แบบมีพารามิเตอร์
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
        this.answer = 0;
        this.attempts = 0;
        this.guesses = new int[maxTries];
    }
// ฟังก์ชัน getter และ setter สำหรับการเข้าถึงและปรับเปลี่ยนค่าต่าง ๆ
    public int getMin() {
        return min; // คืนค่าต่ำสุด
    }

    public void setMin(int min) {
        this.min = min; // เปลี่ยนค่าต่ำสุด
    }

    public int getMax() {
        return max; // คืนค่าสูงสุด
    }

    public void setMax(int max) {
        this.max = max; // เปลี่ยนค่าสูงสุด
    }

    public int getMaxTries() {
        return maxTries; // คืนค่าจำนวนครั้งสูงสุด
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries; // เปลี่ยนจำนวนครั้งสูงสุด
    }

    public int getAttempts() {
        return attempts; // คืนค่าจำนวนครั้งที่เดาไปแล้ว
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts; // เปลี่ยนค่าจำนวนครั้งที่เดา
    }

    public int getAnswer() {
        return answer; // คืนค่าคำตอบที่สุ่มออกมา
    }

    public void setAnswer(int answer) {
        this.answer = answer; // กำหนดคำตอบใหม่
    }

    public void configureGame(int min, int max, int maxTries) {
        this.min = min; // กำหนดค่าต่ำสุดใหม่
        this.max = max; // กำหนดค่าสูงสุดใหม่
        this.maxTries = maxTries; // กำหนดจำนวนครั้งสูงสุดใหม่
    }

    public void generateAnswer() {
        Random rand = new Random(); // ใช้คลาส Random สำหรับสุ่มตัวเลข
        answer = rand.nextInt(max - min + 1) + min;
    }

    public boolean playSingleGame() { // ฟังก์ชันสำหรับเล่นเกมครั้งเดียว

        generateAnswer(); // สร้างคำตอบแบบสุ่มใหม่สำหรับเกมนี้
    
        System.out.println("Welcome to the Guessing Game!"); // แสดงข้อความต้อนรับผู้เล่น
    
        // วนลูปเพื่อให้ผู้เล่นเดาเลขจนกว่าจะถึงจำนวนครั้งสูงสุดที่กำหนดไว้
        while (attempts < maxTries) {
            // แสดงข้อความขอให้ผู้เล่นป้อนเลขในช่วงที่กำหนด
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            int guess = scanner.nextInt(); // รับข้อมูลจากผู้เล่น (เดาตัวเลข)
            guesses[attempts] = guess; // บันทึกตัวเลขที่ผู้เล่นเดาในอาร์เรย์
    
            // ตรวจสอบว่าผู้เล่นเดาตรงกับคำตอบหรือไม่
            if (guess == answer) {
                // หากเดาถูก แสดงข้อความแสดงความยินดี พร้อมจำนวนครั้งที่ใช้
                System.out.println("Congratulations! You've guessed the number in " + (attempts + 1) + " attempts.");
                return true; // สิ้นสุดเกมและคืนค่า true เพื่อบอกว่าชนะ
            } else if (guess < answer) {
                // หากตัวเลขที่เดาน้อยกว่าคำตอบ แนะนำให้เดาตัวเลขที่สูงขึ้น
                System.out.println("Try a higher number!");
            } else {
                // หากตัวเลขที่เดามากกว่าคำตอบ แนะนำให้เดาตัวเลขที่ต่ำลง
                System.out.println("Try a lower number!");
            }
    
            attempts++; // เพิ่มตัวนับจำนวนครั้งที่ผู้เล่นเดา
        }
    
        // หากผู้เล่นใช้จำนวนครั้งที่เดาสูงสุดแล้วแต่ยังไม่ถูก แสดงข้อความเฉลยคำตอบ
        System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);
        return false; // คืนค่า false เพื่อบอกว่าแพ้
    }
    
}


