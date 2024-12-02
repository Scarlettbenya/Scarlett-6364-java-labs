//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//โปรแกรมนี้แสดง โปรแกรมนี้เป็นการจำลองเกมRock-Paper-Scissorsโดยรับinputจากผู้เล่นสองคนผ่านอาร์กิวเมนต์ในบรรทัดคำสั่ง (args[]) และแสดงผลลัพธ์ว่าใครชนะหรือเสมอกัน
//last update: 02/12/2024
package mcfadden.scarlett.lab2;

public class RockPaperScissors {
//กำหนดตัวเลือกในรูปแบบ enum
public enum Choice { 
    ROCK, PAPER, SCISSORS;
}
    public static void main(String[] args) {
        if (args.length != 2) { //โปรแกรมจะตรวจสอบว่าผู้เล่นได้ระบุอาร์กิวเมนต์มาครบ 2 ตัว หากไม่ครบ จะส่งข้อความแสดงข้อผิดพลาดและจบการทำงาน
            System.out.println("Error: Invalid number of arguments. Please provide exactly two arguments.");
            return;
        }

        String player1 = args[0].toUpperCase(); //แปลงค่าที่ผู้เล่นป้อนให้เป็นตัวพิมพ์ใหญ่ด้วย toUpperCase() เพื่อให้ตรงกับชื่อใน enum
        String player2 = args[1].toUpperCase();

        Choice player1Choice; //กำหนดchoice
        Choice player2Choice;

        try {
            player1Choice = Choice.valueOf(player1); //ใช้ Choice.valueOf() เพื่อตรวจสอบว่าค่าที่ป้อนมาตรงกับ enum หรือไม่
            player2Choice = Choice.valueOf(player2);
        } catch (IllegalArgumentException e) {//หากไม่ถูกต้อง จะจับข้อผิดพลาด (IllegalArgumentException) และแสดงข้อความแจ้งเตือน
            System.out.println("Error: Invalid choice(s). Valid choices are 'rock', 'paper', or 'scissors'.");
            return;
        }

        System.out.println("Player 1 chooses: " + player1.toLowerCase()); //แปลงค่าที่ป้อนให้กลับเป็นตัวพิมพ์เล็ก toLowerCase()
        System.out.println("Player 2 chooses: " + player2.toLowerCase());

        if (player1Choice == player2Choice) { //หากทั้งสองเลือกเหมือนกัน
            System.out.println("It's a tie!");
        } else if ( //ใช้เงื่อนไขเปรียบเทียบว่า Player 1 ชนะหรือไม่
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
