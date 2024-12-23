//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//โปรแกรมนี้แสดง โปรแกรมที่ทำการสร้างและดำเนินการกับเมทริกซ์ (Matrix) ตามคำสั่งที่ผู้ใช้ป้อนเข้าไปในรูปแบบต่าง ๆ โค้ดมีการจัดการเมทริกซ์อย่างหลากหลายประเภท เช่น การสร้างเมทริกซ์จากการป้อนข้อมูล, การสุ่มค่าระหว่าง 0 ถึง 9, การสร้างเมทริกซ์ที่มีแต่เลข 0 หรือ 1, และการสร้างเมทริกซ์แบบเส้นทแยงมุม (Diagonal Matrix) นอกจากนี้ยังมีฟังก์ชันการดำเนินการกับเมทริกซ์หลายประเภท เช่น การหาผลรวมของแถวและคอลัมน์, การหาค่าต่ำสุดและค่าสูงสุด, การคำนวณทรานสโพส และการแสดงผลบนเส้นทแยงมุม
//last update: 23/12/2024
package mcfadden.scarlett.lab5;
import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {

    private static int[][] matrix;
    private static int rows;
    private static int columns;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueProgram = true;
        while (continueProgram) { // ลูปทำงานหลักจนกว่าผู้ใช้จะออก
            displayCreationMenu(); // แสดงเมนูการสร้างเมทริกซ์
            int choice = scanner.nextInt(); // รับตัวเลือกจากผู้ใช้

            if (choice >= 1 && choice <= 4) { 
                // For options 1-4, get matrix dimensions
                System.out.print("Enter number of rows: ");
                rows = scanner.nextInt();
                System.out.print("Enter number of columns: ");
                columns = scanner.nextInt();

                if (rows <= 0 || columns <= 0) { // ตรวจสอบว่ามิติของเมทริกซ์ต้องมากกว่า 0
                    System.out.println("Error: Dimensions must be greater than 0");
                    continue;
                }

                matrix = new int[rows][columns]; // สร้างเมทริกซ์ตามมิติที่ผู้ใช้กำหนด
                createMatrix(choice); // เรียกใช้ฟังก์ชันสร้างเมทริกซ์ตามตัวเลือก
            } else if (choice == 5) { // กรณีเลือกสร้างเมทริกซ์แบบเส้นทแยงมุม
                // Diagonal matrix must be square
                System.out.print("Enter size of square matrix: ");
                rows = columns = scanner.nextInt();

                if (rows <= 0) { // ตรวจสอบว่าขนาดต้องมากกว่า 0
                    System.out.println("Error: Size must be greater than 0");
                    continue;
                }

                matrix = new int[rows][rows]; // สร้างเมทริกซ์จัตุรัส
                createDiagonalMatrix(); // เรียกใช้ฟังก์ชันสร้างเมทริกซ์แบบเส้นทแยงมุม
            } else { // กรณีเลือกตัวเลือกไม่ถูกต้อง
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.println("\nCreated Matrix:");
            displayMatrix(matrix); // แสดงเมทริกซ์ที่สร้างขึ้น

            // Operations menu loop
            boolean continueOperations = true; // ลูปสำหรับการดำเนินการกับเมทริกซ์
            while (continueOperations) {
                displayOperationsMenu(); // แสดงเมนูการดำเนินการกับเมทริกซ์
                int operation = scanner.nextInt(); // รับตัวเลือกจากผู้ใช้

                switch (operation) {
                    case 1:
                        transposeMatrix(); // คำนวณเมทริกซ์แบบทรานสโพส
                        break;
                    case 2:
                        calculateSums(); // คำนวณผลรวมของแถวและคอลัมน์
                        break;
                    case 3:
                        findMinMax(); // หาค่าต่ำสุดและค่าสูงสุดในเมทริกซ์
                        break;
                    case 4:
                        displayDiagonal(); // แสดงค่าบนเส้นทแยงมุม
                        break;
                    case 5:
                        continueOperations = false; // ออกจากลูปการดำเนินการ
                        continueProgram = false; // ออกจากลูปหลักของโปรแกรม
                        break;
                    default:
                        System.out.println("Invalid operation choice.");
                }
            }
        }

        scanner.close();
    }

    private static void displayCreationMenu() { // แสดงเมนูให้ผู้ใช้เลือกวิธีการสร้างเมทริกซ์
        System.out.println("Matrix Creation Menu:");
        System.out.println("1. User Input Matrix");
        System.out.println("2. Random Matrix (0-9)");
        System.out.println("3. All Zeros Matrix");
        System.out.println("4. All Ones Matrix");
        System.out.println("5. Diagonal Matrix");
        System.out.print("Enter your choice: ");
    }

    private static void createMatrix(int choice) { // สร้างเมทริกซ์ตามตัวเลือกของผู้ใช้
        switch (choice) {
            case 1:
                System.out.println("Enter matrix elements:"); // ให้ผู้ใช้ป้อนค่าของแต่ละองค์ประกอบในเมทริกซ์
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                break;
            case 2:
                Random random = new Random(); // สร้างเมทริกซ์ที่มีค่าระหว่าง 0-9 แบบสุ่ม
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = random.nextInt(10);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < rows; i++) { // สร้างเมทริกซ์ที่มีค่าเป็น 0 ทุกองค์ประกอบ
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = 0;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < rows; i++) { // สร้างเมทริกซ์ที่มีค่าเป็น 1 ทุกองค์ประกอบ
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = 1;
                    }
                }
                break;
        }
    }

    private static void createDiagonalMatrix() { // สร้างเมทริกซ์แบบเส้นทแยงมุม (Diagonal Matrix)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                matrix[i][j] = (i == j) ? 1 : 0; // กรอกค่าบนเส้นทแยงมุมเป็น 1 ส่วนที่เหลือเป็น 0
            }
        }
    }

    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " "); // แสดงค่าทุกองค์ประกอบในแต่ละแถว
            }
            System.out.println(); // ขึ้นบรรทัดใหม่หลังจากแสดงแต่ละแถว
        }
    }

    private static void displayOperationsMenu() {
        System.out.println("\nMatrix Operations Menu:");
        System.out.println("1. Find Transpose of the Matrix");
        System.out.println("2. Calculate Sum of Rows and Columns");
        System.out.println("3. Find Minimum and Maximum Elements");
        System.out.println("4. Display Diagonal Elements");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void transposeMatrix() {
        int[][] transpose = new int[columns][rows]; // สร้างเมทริกซ์ใหม่สำหรับเก็บค่า transposed
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j]; // ทำการทรานสโพส
            }
        }
        System.out.println("\nTransposed Matrix:");
        displayMatrix(transpose); // แสดงเมทริกซ์ที่ได้รับการทรานสโพส
    }

    private static void calculateSums() {
        System.out.println("\nRow sums:");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < columns; j++) {
                rowSum += matrix[i][j]; // คำนวณผลรวมของแถว
            }
            System.out.println("Row " + (i + 1) + " sum: " + rowSum); // แสดงผลรวมของแถว
        }

        System.out.println("\nColumn sums:");
        for (int j = 0; j < columns; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j]; // คำนวณผลรวมของคอลัมน์
            }
            System.out.println("Column " + (j + 1) + " sum: " + colSum); // แสดงผลรวมของคอลัมน์
        }
    }

    private static void findMinMax() {
        int min = Integer.MAX_VALUE; // กำหนดค่าต่ำสุดเริ่มต้น
        int max = Integer.MIN_VALUE; // กำหนดค่าสูงสุดเริ่มต้น

        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) min = element; // หาค่าต่ำสุด
                if (element > max) max = element; // หาค่าสูงสุด
            }
        }

        System.out.println("\nMinimum element: " + min);
        System.out.println("Maximum element: " + max);
    }

    private static void displayDiagonal() {
        if (rows != columns) {
            System.out.println("\nMatrix is not square. Cannot display diagonal elements."); // ตรวจสอบว่าเมทริกซ์เป็นจัตุรัสหรือไม่
            return;
        }

        System.out.println("Diagonal elements:");
        for (int i = 0; i < rows; i++) {
            System.out.print(matrix[i][i] + " "); // แสดงค่าบนเส้นทแยงมุม
        }
        System.out.println(); // ขึ้นบรรทัดใหม่หลังจากแสดงค่าทุกตัว
    }
}
