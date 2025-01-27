package mcfadden.scarlett.lab7;

public class IPadAir extends MobileDevice {
    // ตัวแปรส่วนตัวที่ใช้เก็บข้อมูลขนาดพื้นที่จัดเก็บ
    private double storage;

    // ตัวแปรคงที่ที่เก็บชื่อชิปของ iPad Air (ชื่อของชิปนี้ไม่สามารถเปลี่ยนแปลงได้)
    private static final String CHIP_NAME = "Apple M2";

    // คอนสตรัคเตอร์ที่รับพารามิเตอร์สี, ราคา และพื้นที่จัดเก็บของ iPad Air
    public IPadAir(String color, double price, double storage) {
        super(color, price);  // เรียกคอนสตรัคเตอร์ของ MobileDevice เพื่อกำหนดสีและราคา
        this.storage = storage;  // กำหนดพื้นที่จัดเก็บให้กับ iPad Air
    }

    // เมธอด getter สำหรับพื้นที่จัดเก็บ
    public double getStorage() {
        return storage;  // คืนค่าพื้นที่จัดเก็บของ iPad Air
    }

    // เมธอด setter สำหรับการตั้งค่าพื้นที่จัดเก็บใหม่
    public void setStorage(double storage) {
        this.storage = storage;  // ตั้งค่าพื้นที่จัดเก็บใหม่ให้กับ iPad Air
    }

    // เมธอด static สำหรับคืนค่าชื่อชิปของ iPad Air
    public static String getChipName() {
        return CHIP_NAME;  // คืนค่าชื่อชิปของ iPad Air ที่เก็บไว้ในตัวแปรคงที่
    }

    // เมธอดที่ใช้ตรวจสอบว่าอุปกรณ์นี้เป็นนาฬิกาหรือไม่
    public boolean isWatch() {
        return false;  // คืนค่า false เพราะ iPad Air ไม่ใช่นาฬิกา
    }

    // เมธอด toString() ที่ใช้ในการแสดงรายละเอียดของ iPad Air
    @Override
    public String toString() {
        // คืนค่าข้อความที่แสดงข้อมูลของ iPad Air เช่น สี, ราคา, ขนาดพื้นที่จัดเก็บ และชื่อชิป
        return "IPadAir [" + "color='" + getColor() + ", price=" + getPrice() + ", storage=" + storage + ", chip='" + CHIP_NAME + "]";
    }
}

