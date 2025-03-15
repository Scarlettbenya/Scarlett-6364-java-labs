//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//last update: 12/03/2025

package mcfadden.scarlett.lab12;
import java.io.Serializable;
import mcfadden.scarlett.lab7.*;

class SmartPhone extends MobileDevice implements Serializable {
    // กำหนดค่าคงที่ประเภทของอุปกรณ์เป็น "SmartPhone"
    protected static final String TYPE = "SmartPhone";
    
    // กำหนดตัวแปรสำหรับเก็บชื่อและแบรนด์ของสมาร์ทโฟน
    protected String name;
    protected String brand;
    
    // คอนสตรักเตอร์ที่ใช้กำหนดค่าเริ่มต้นของชื่อ, แบรนด์ และราคา
    public SmartPhone(String name, String brand, double price) {
        super(brand, price); // เรียกใช้คอนสตรักเตอร์ของคลาสแม่
        this.name = name;
        this.brand = brand;
    }
    
    // คอนสตรักเตอร์ที่ใช้กำหนดค่าเริ่มต้นของชื่อ, แบรนด์, ราคา และสี
    public SmartPhone(String name, String brand, double price, String color) {
        super(color, price); // เรียกใช้คอนสตรักเตอร์ของคลาสแม่
        this.name = name;
        this.brand = brand;
        this.color = color; // กำหนดค่าสีของสมาร์ทโฟน
    }
    
    // เมธอดที่ใช้แสดงข้อมูลของสมาร์ทโฟนในรูปแบบสตริง
    @Override
    public String toString() {
        return TYPE + ": " + name + " (" + brand + ") " + price + " Baht";
    }

    // เมธอดที่ใช้ตรวจสอบว่าอุปกรณ์เป็นนาฬิกาหรือไม่ (ยังไม่ได้ถูกนำมาใช้งาน)
    @Override
    public boolean isWatch() {
        // ขว้างข้อผิดพลาดเพื่อระบุว่ายังไม่ได้ดำเนินการเมธอดนี้
        throw new UnsupportedOperationException("Unimplemented method 'isWatch'");
    }
}

