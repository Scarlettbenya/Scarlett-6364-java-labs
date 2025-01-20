//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//last update: 10/01/2025
package mcfadden.scarlett.lab6;

public class GuessGameV3 extends GuessGameV2 {
    private static final int MAX_GAMES = 100; // จำนวนเกมสูงสุดที่สามารถเก็บได้
    private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAMES]; // อาร์เรย์สำหรับเก็บประวัติของเกม
    private static int recordIndex = 0; // ติดตามจำนวนประวัติที่เก็บไว้

    private int[] guesses; // อาร์เรย์สำหรับเก็บการเดาทั้งหมดในเกม
    private int guessCount; // จำนวนครั้งที่เดาในเกมปัจจุบัน
    private boolean win; // ตรวจสอบว่าเกมนั้นผู้เล่นชนะหรือไม่

    public GuessGameV3() {
        super();
    }

    // ตัวสร้างสำหรับ GuessGameV3
    public GuessGameV3(int min, int max, int maxTries) {
        super(min, max, maxTries); // เรียกใช้ตัวสร้างของคลาสแม่
        this.guessCount = 0; // ตั้งค่าจำนวนการเดาเริ่มต้นเป็น 0
        this.win = false; // ตั้งค่าสถานะเริ่มต้นว่าผู้เล่นยังไม่ชนะ
        this.guesses = new int[maxTries]; // สร้างอาร์เรย์สำหรับเก็บการเดา
    }

    public void configureGame(int min, int max, int maxTries, int attempts, int answer) {
        super.configureGame(min, max, maxTries, attempts, answer); // ตั้งค่าการเกมโดยเรียกใช้เมธอดจากคลาสแม่
        this.guesses = new int[maxTries]; // สร้างอาร์เรย์ใหม่สำหรับเก็บการเดา
        this.guessCount = 0; // รีเซ็ตจำนวนการเดา
        this.win = false; // รีเซ็ตสถานะผู้ชนะ
    }

    public boolean playSingleGame() {
        generateAnswer(); // สร้างคำตอบสุ่มใหม่
        System.out.println("Welcome to the Record-Keeping Number Guessing Game!");

        while (getAttempts() < getMaxTries()) { // เล่นจนกว่าจะหมดจำนวนครั้งที่อนุญาต
            System.out.print("Enter an integer between " + getMin() + " and " + getMax() + ": ");
            int guess = scanner.nextInt(); // รับค่าที่ผู้เล่นเดา

            // เก็บค่าที่เดาไว้ในอาร์เรย์
            guesses[guessCount++] = guess;
            setAttempts(getAttempts() + 1); // เพิ่มจำนวนครั้งที่ใช้

            if (guess == getAnswer()) { // ตรวจสอบว่าผู้เล่นเดาถูกหรือไม่
                System.out.println("Congratulations! You've guessed the number in " + getAttempts() + " attempts.");
                win = true; // ตั้งค่าสถานะว่าผู้เล่นชนะ
                return true; // สิ้นสุดเกม
            } else if (guess < getAnswer()) { // ถ้าคำตอบต่ำเกินไป
                System.out.println("Try a higher number!");
            } else { // ถ้าคำตอบสูงเกินไป
                System.out.println("Try a lower number!");
            }
        }
        System.out.println("Sorry, you've used all your attempts. The correct answer was: " + getAnswer());
        win = false; // ตั้งค่าสถานะว่าผู้เล่นแพ้
        return false; // สิ้นสุดเกม
    }

    // เพิ่มประวัติของเกมไปยังอาร์เรย์ gameRecords
    public static void addGameRecord(GuessGameV3 game) {
        if (recordIndex < MAX_GAMES) { // ตรวจสอบว่าสามารถเพิ่มได้หรือไม่
            gameRecords[recordIndex++] = game; // เพิ่มเกมไปในอาร์เรย์
        } else {
            System.out.println("Maximum game record limit reached. Cannot add more records.");
        }
    }

    // สร้างและคืนค่าสตริงที่สรุปผลของเกม
    public String getGameLog() {
        StringBuilder log = new StringBuilder();
        log.append("Range: [").append(getMin()).append("-").append(getMax()).append("]") // แสดงช่วงของตัวเลข
           .append(", Max Tries: ").append(getMaxTries()) // แสดงจำนวนครั้งที่อนุญาตให้เดา
           .append(", Attempts: ").append(getAttempts()) // แสดงจำนวนครั้งที่ใช้ไป
           .append(", Result: ").append(win ? "Win" : "Loss") // แสดงผลว่าเกมชนะหรือแพ้
           .append(", Guesses: "); // แสดงการเดาทั้งหมด

        for (int i = 0; i < guessCount; i++) {
            log.append(guesses[i]); // เพิ่มแต่ละค่าที่เดาลงในข้อความ
            if (i < guessCount - 1) log.append(", "); // ใส่เครื่องหมายคั่นระหว่างตัวเลข
        }
        return log.toString(); // คืนค่าข้อความสรุปของเกม
    }
}
