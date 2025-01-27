package mcfadden.scarlett.lab7;

// คลาส AppleWatch เป็นคลาสที่สืบทอด (extends) มาจากคลาส MobileDevice
public class AppleWatch extends MobileDevice {
    // ตัวแปร modelName ใช้เก็บชื่อรุ่นของ Apple Watch
    private String modelName;

    // เมธอดสร้าง (Constructor) สำหรับกำหนดค่าเริ่มต้นให้กับ Apple Watch
    public AppleWatch(String color, double price, String modelName) {
        // เรียกใช้ Constructor ของคลาสแม่ (MobileDevice)
        super(color, price);
        // กำหนดค่าชื่อรุ่นให้กับตัวแปร modelName
        this.modelName = modelName;
    }

    // เมธอดสำหรับคืนค่าชื่อรุ่นของ Apple Watch
    public String getModelName() {
        return modelName;
    }

    // เมธอดสำหรับเปลี่ยนค่าชื่อรุ่นของ Apple Watch
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    // เมธอดสำหรับตรวจสอบว่าเป็นนาฬิกาหรือไม่ (ในที่นี้คืนค่าเป็น true เสมอ)
    public boolean isWatch() {
        return true;
    }

    // เมธอดสำหรับแปลงข้อมูลของ Apple Watch เป็นข้อความ
    public String toString() {
        return "AppleWatch [" + "color=" + getColor() + ", price=" + getPrice() + ", modelName=" + getModelName() + "]";
    }
}

