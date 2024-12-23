//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//โปรแกรมนี้แสดง โปรแกรมช่วยสาธิตการทำงานของ Recursion ใน 3 รูปแบบ คือการคำนวณตัวเลข การจัดการอาเรย์ และการตรวจสอบข้อมูลที่มีความสมมาตร (Palindrome) โดยแสดงผลลัพธ์ที่เข้าใจง่ายและมีความหลากหลาย
//last update: 23/12/2024
package mcfadden.scarlett.lab5;

public class RecursiveMethods {
    public static int sumOfDigits(int number) { //ฟังก์ชันนี้จะรับค่าจำนวนเต็ม number และคำนวณผลรวมของตัวเลขแต่ละหลักใน number
        if (number == 0) {
            return 0;
        }
        return (number % 10) + sumOfDigits(number / 10);
    }
    public static void reverseArray(int[] arr, int start, int end) { //ฟังก์ชันนี้ใช้สลับค่าระหว่างตำแหน่งเริ่มต้นและตำแหน่งสุดท้าย
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end]; //เมื่อ start >= end จะหยุดทำงาน
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
    }
    public static boolean isPalindrome(int[] arr, int start, int end) { //ฟังก์ชันนี้ใช้ตรวจสอบว่าอาเรย์เป็น Palindrome หรือไม่
        if (start >= end) { //เปรียบเทียบค่าตำแหน่งเริ่มต้นกับตำแหน่งสุดท้าย
            return true; //ถ้าค่าทั้งหมดเท่ากันให้คืนค่า true
        }
        if (arr[start] != arr[end]) { //ถ้าค่าทั้งสองไม่เท่ากัน ให้คืนค่า false
            return false;
        }
        return isPalindrome(arr, start + 1, end - 1);
    }
    public static void main(String[] args) {
        int num = 11111; 
        System.out.println("Sum of digits in " + num + ": " + sumOfDigits(num)); //เรียกใช้ฟังก์ชัน sumOfDigits เพื่อหาผลรวมของตัวเลขแต่ละหลักในจำนวนเต็ม
        int number = 12345;
        System.out.println("Sum of digits in " + number + ": " + sumOfDigits(number));

        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Original array: ");
        printArray(array); //ใช้ printArray เพื่อแสดงค่าในอาเรย์
        reverseArray(array, 0, array.length - 1);
        System.out.println("Reversed array: ");
        printArray(array);

        int[] palindromeArray = {1, 2, 3, 2, 1};
        System.out.println("Testing palindrome");
        printArray(palindromeArray);
        System.out.println("Is palindrome: " + isPalindrome(palindromeArray, 0, palindromeArray.length - 1)); //เรียกใช้ฟังก์ชัน isPalindrome เพื่อตรวจสอบว่าอาเรย์นี้เป็น Palindrome หรือไม่

        int[] nonPalindromeArray = {1, 2, 1};
        System.out.println("Testing palindrome");
        printArray(nonPalindromeArray);
        System.out.println("Is palindrome: " + isPalindrome(nonPalindromeArray, 0, nonPalindromeArray.length - 1));
    }
    private static void printArray(int[] arr) { //ใช้พิมพ์ค่าทุกตัวในอาเรย์แยกด้วยช่องว่าง
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}