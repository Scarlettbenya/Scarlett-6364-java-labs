//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//โปรแกรมนี้แสดง วิเคราะห์ข้อมูลในอาเรย์ของตัวเลข โดยใช้ฟังก์ชันต่าง ๆ ในการหาค่าต่ำสุด (min) และค่าสูงสุด (max), คำนวณค่าเฉลี่ยสะสม และตรวจสอบว่าอาเรย์เรียงลำดับหรือไม่ พร้อมทั้งแสดงผลการทำงานของฟังก์ชัน
//last update: 23/12/2024
package mcfadden.scarlett.lab5;

import java.util.Arrays;

public class NumberAnalyzer { 

    public static int[] findMinMax(int[] numbers) { // ฟังก์ชันนี้หาเลขที่น้อยที่สุด (min) และมากที่สุด (max) 
        int min = numbers[0]; //กำหนดค่าเริ่มต้นของ min เป็นตัวแรกในอาเรย์
        int max = numbers[0]; //กำหนดค่าเริ่มต้นของ max เป็นตัวแรกในอาเรย์
        for (int num : numbers) { //วนลูปผ่านทุกตัวเลขในอาเรย์
            if (num < min) min = num; //ถ้าตัวเลขปัจจุบันน้อยกว่า min ให้ปรับค่า min
            if (num > max) max = num; //ถ้าตัวเลขปัจจุบันมากกว่า max ให้ปรับค่า max
        }
        return new int[]{min, max};
    }

    public static double[] calculateRunningAverages(int[] numbers) { // ฟังก์ชันนี้คำนวณค่าเฉลี่ยสะสมสำหรับแต่ละตำแหน่งในอาเรย์
        double[] averages = new double[numbers.length]; //สร้างอาเรย์สำหรับเก็บค่าเฉลี่ย
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            averages[i] = sum / (i + 1); // คำนวณค่าเฉลี่ยสะสมและเก็บในตำแหน่งที่เกี่ยวข้อง
        }
        return averages; //คืนค่าอาเรย์ที่มีค่าเฉลี่ยสะสม
    }

    public static boolean isSorted(int[] numbers) { //ฟังก์ชันนี้ตรวจสอบว่าอาเรย์เรียงลำดับจากน้อยไปมากหรือไม่
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) return false; //ถ้าตัวเลขปัจจุบันน้อยกว่าตัวก่อนหน้า คืนค่า false
        }
        return true; // ถ้าลูปจบและไม่มีปัญหา ถือว่าเรียงลำดับแล้ว คืนค่า true
    }

    public static void main(String[] args) {
        int[] numbers1 = {9, 2, 6, 1, 3};
		System.out.println("Testing with array: " + Arrays.toString(numbers1));
        int[] numbers2 = {1, 2, 3, 4, 5};

        int[] minMax = findMinMax(numbers1); // เรียกใช้ฟังก์ชันหา min และ max แล้วแสดงผล
        System.out.println("Minimum value: " + minMax[0]);
        System.out.println("Maximum value: " + minMax[1]);

        double[] runningAverages = calculateRunningAverages(numbers1); // เรียกใช้ฟังก์ชันคำนวณค่าเฉลี่ยสะสมแล้วแสดงผล
        System.out.println("\nRunning averages:");
        for (int i = 0; i < runningAverages.length; i++) { // แสดงค่าเฉลี่ยสะสมของแต่ละตำแหน่ง
            System.out.printf("Position %d: %.2f\n", i, runningAverages[i]);
        }
		// ทดสอบว่าอาเรย์เรียงลำดับหรือไม่
        System.out.println("\nTesting if arrays are sorted:");
		printArray(numbers1);
        System.out.println("\nnumbers1 is sorted: " + isSorted(numbers1));
		printArray(numbers2);
        System.out.println("\nnumbers2 is sorted: " + isSorted(numbers2));
    }
	private static void printArray(int[] numbers) { // ฟังก์ชันแสดงค่าในอาเรย์
		for (int num : numbers) {
			System.out.print(num + " ");
		}
	}
}
