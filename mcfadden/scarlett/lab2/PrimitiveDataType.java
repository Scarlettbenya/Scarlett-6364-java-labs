//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//โปรแกรมนี้แสดงการแปลงข้อมูล การคำนวณ และการทำงานพื้นฐานกับประเภทข้อมูลต่างๆ ที่ได้มาจากตัวแปรที่กำหนดไว้
//last update: 02/12/2024
package mcfadden.scarlett.lab2;

public class PrimitiveDataType {
    public static void main(String[] args) { //เริ่มต้นการทำงานของโปรแกรม
        String studentNumber = "673040636-4"; //กำหนดตัวแปร
        String firstName = "Scarlett";

        byte myByte = (byte) firstName.length(); //เก็บค่าความยาวของ firstName โดยแปลงเป็น byte
        short myShort = (short) (myByte * 21); //คำนวณโดยการคูณ myByte ด้วย 21
        int myInt = Integer.parseInt(studentNumber.replace("-", "").substring(3, 10)); //นำเลขหกตัวสุดท้ายของ studentNumber ด้วย substring() และลบ (-) ด้วยreplace() และแปลงค่าเป็นจำนวนเต็ม 
        long myLong = Long.parseLong(studentNumber.replace("-", "")); //ลบเครื่องหมาย (-)ด้วยreplace() ใน studentNumber
        float myFloat = (float) (myByte / 100.0f); //คำนวณจากการหาร myByte ด้วย 100.0f
        double myDouble = Double.parseDouble("0." + studentNumber.replace("-", "").substring(studentNumber.length() - 5)); //สร้างจากเลข 5 หลักสุดท้ายของ studentNumber ลบเครื่องหมาย (-)ด้วยreplace()
        char myChar = firstName.charAt(0); //เก็บตัวอักษรแรกของ firstName
        boolean myBoolean = (Character.getNumericValue(studentNumber.charAt(studentNumber.length() - 1)) % 2 != 0); //ตรวจสอบว่าตัวเลขสุดท้ายของ studentNumber เป็นเลขคี่หรือไม่
    
        System.out.println("Student ID: " + studentNumber);//แสดงผลลัพธ์ออกมาทางหน้าจอ
        System.out.println("First Name: " + firstName);
        System.out.println("Byte Value: " + myByte);
        System.out.println("Short Value: " + myShort);
        System.out.println("Int Value: " + myInt);
        System.out.println("Long Value: " + myLong);
        System.out.println("Float Value: " + myFloat);
        System.out.println("Double Value: " + myDouble);
        System.out.println("Char Value: " + myChar);
        System.out.println("Boolean Value: " + myBoolean);
        }
    }
    