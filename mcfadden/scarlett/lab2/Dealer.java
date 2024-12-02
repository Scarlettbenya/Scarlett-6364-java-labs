package mcfadden.scarlett.lab2;
public class Dealer { //สร้างคลาสที่ชื่อว่า Dealer โดยกำหนดการเข้าถึงของคลาสนี้เป็นแบบ Public
    public static void main(String[] args) { //เริ่มต้นการทำงานของโปรแกรม
        if (args.length != 3){
            System.err.println("Error: Invalid number of arguments. Please provide exactly three arguments.");
            return; //โปรแกรมจะตรวจสอบว่าผู้ใช้ป้อนข้อมูลมาทั้งหมด 3 ค่าหรือไม่ ถ้าไม่ใช่ จะพิมพ์ข้อความแสดงข้อผิดพลาดและหยุดการทำงานทันที
        }
            String nameofdealer = args[0]; //กำหนดค่าตัวแปร
            String numofclients = args[1];
            String gender = args[2];
            
            System.out.println("Dealer's Name: " + nameofdealer); //แสดงผลลัพธ์ออกมาทางหน้าจอ
            System.out.println("Number of clients: " + numofclients);
            System.out.println("Gender: " + gender);
        

        
    }

    
}
