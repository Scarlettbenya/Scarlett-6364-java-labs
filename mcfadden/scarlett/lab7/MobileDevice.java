package mcfadden.scarlett.lab7;

public abstract class MobileDevice {
    // กำหนดตัวแปร instance สำหรับเก็บข้อมูลสีและราคา
    protected String color; // สีของอุปกรณ์
    protected double price; // ราคาของอุปกรณ์

    // คอนสตรักเตอร์ (Constructor) สำหรับกำหนดค่าเริ่มต้นของสีและราคา
    public MobileDevice(String color, double price) {
        this.color = color;
        this.price = price;
    }

    // เมทอดสำหรับคืนค่าข้อมูลสีของอุปกรณ์
    public String getColor() {
        return color;
    }

    // เมทอดสำหรับตั้งค่าข้อมูลสีของอุปกรณ์
    public void setColor(String color) {
        this.color = color;
    }

    // เมทอดสำหรับคืนค่าราคาของอุปกรณ์
    public Double getPrice() {
        return price;
    }

    // เมทอดสำหรับตั้งค่าราคาของอุปกรณ์
    public void setPrice(double price) {
        this.price = price;
    }

    // เมทอดแบบ abstract ใช้ตรวจสอบว่าอุปกรณ์เป็นนาฬิกาหรือไม่
    // คลาสที่สืบทอดจาก MobileDevice ต้อง override เมทอดนี้
    public abstract boolean isWatch();
}

