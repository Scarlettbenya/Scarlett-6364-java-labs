//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//โปรแกรมนี้แสดง โปรแกรมนี้เป็นโปรแกรมสำหรับการจัดการและปรับแต่งสตริงสองตัวตามเงื่อนไขที่กำหนด โดยอ่านค่าจากอาร์กิวเมนต์ในบรรทัดคำสั่ง (args[]) และทำการเปลี่ยนแปลงข้อมูลตามลักษณะของตัวอักษรในแต่ละสตริงก่อนรวมสตริงเข้าด้วยกัน
//last update: 02/12/2024
package mcfadden.scarlett.lab2;

public class SimpleStringManipulator {
    public static void main(String[] args) {
        //โปรแกรมจะตรวจสอบว่ามีการส่งอาร์กิวเมนต์เข้ามา 2 ค่าหากไม่ครบ จะพิมพ์ข้อความแสดงข้อผิดพลาดและจบการทำงาน
        if (args.length != 2) { 
            System.err.println("Error: Invalid number of arguments. Please provide exactly two strings as arguments.");
            return;
        }
        //อ่านค่าจากอาร์กิวเมนต์และกำหนดให้ตัวแปร
        String first = args[0]; 
        String second = args[1];
        //หากอาร์กิวเมนต์ใดว่างเปล่า โปรแกรมจะส่งข้อความแจ้งข้อผิดพลาดและจบการทำงาน
        if (first.isEmpty() || second.isEmpty()) {
            System.err.println("Error: Arguments must be non-empty strings.");
            return;
        }
        //ตรวจสอบตัวอักษรตัวแรกว่าเป็นสระหรือไม่
        char firstChar = first.charAt(0);
        if (isVowel(firstChar)) {
            first = Character.toUpperCase(firstChar) + first.substring(1); //หากเป็นสระแปลงตัวอักษรตัวแรกเป็นตัวพิมพ์ใหญ่
        } else {
            first = Character.toLowerCase(firstChar) + first.substring(1); //หากไม่เป็นสระแปลงตัวอักษรตัวแรกเป็นตัวพิมพ์เล็ก
        }

        char lastChar = second.charAt(second.length() - 1); //ตรวจสอบตัวอักษรตัวสุดท้ายว่าเป็นพยัญชนะหรือไม่
        if (isConsonant(lastChar)) {
            second = second.substring(0, second.length() - 1) + Character.toUpperCase(lastChar); //หากเป็นพยัญชนะแปลงตัวอักษรตัวสุดท้ายเป็นตัวพิมพ์ใหญ่
        } else {
            second = second.substring(0, second.length() - 1) + Character.toLowerCase(lastChar); //หากไม่เป็นพยัญชนะแปลงตัวอักษรตัวสุดท้ายเป็นตัวพิมพ์เล็ก
        }

        String result = first + second; //นำสตริงทั้งสองที่ผ่านการปรับแต่งแล้วมารวมกัน

        System.out.println("First String: " + args[0]); //แสดงสตริงต้นฉบับและผลลัพธ์ในรูปแบบข้อความ
        System.out.println("Second String: " + args[1]);
        System.out.println("Resulting String: " + result);
    }
    //แปลงตัวอักษรเป็นตัวพิมพ์เล็กและตรวจสอบว่าเป็นสระ a, e, i, o, u หรือไม่
    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    //ตรวจสอบว่าตัวอักษรนั้นเป็นตัวอักษรภาษาอังกฤษและไม่ใช่สระ
    private static boolean isConsonant(char c) {
        return Character.isLetter(c) && !isVowel(c);
    }
}

