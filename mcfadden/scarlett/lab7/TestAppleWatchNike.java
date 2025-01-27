package mcfadden.scarlett.lab7;

public class TestAppleWatchNike {
    public static void main(String[] args) {
        // สร้างออบเจ็กต์ AppleWatchNike โดยกำหนดสี ราคา รุ่น ขนาดตัวเรือน 
        // ความจุแบตเตอรี่ และระยะเวลาการใช้งานแบตเตอรี่
        AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0, 
        "Nike SE", 42.5, 75, 7.5);
        
        // แสดงรายละเอียดของ nikeWatch
        System.out.println(nikeWatch);

        // เรียกใช้งานเมทอดแสดงข้อมูลการวิ่ง 
        nikeWatch.displayRunningStats();

        // เรียกใช้งานเมทอดแสดงอัตราการเต้นของหัวใจ 
        nikeWatch.displayHeartRates();

        // เรียกใช้งานเมทอดแสดงจำนวนชั่วโมงการนอนของผู้ใช้
        nikeWatch.displaySleepHours();

        // ตรวจสอบว่า nikeWatch เป็นอุปกรณ์ประเภทนาฬิกาหรือไม่ 
        System.out.println("Is this a watch? " + nikeWatch.isWatch());

        // กำหนดให้ตัวแปร basWatch ซึ่งเป็นตัวแปรชนิด AppleWatch อ้างอิงไปที่ออบเจ็กต์ nikeWatch
        // ซึ่งเป็นการใช้ตัวแปรของคลาสแม่ในการอ้างถึงออบเจ็กต์ของคลาสลูก (Polymorphism)
        AppleWatch basWatch = nikeWatch;

        // แสดงรายละเอียดของ basWatch ซึ่งชี้ไปยังออบเจ็กต์เดียวกับ nikeWatch
        System.out.println("Through base reference: " + basWatch);
    }
}

