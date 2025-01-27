package mcfadden.scarlett.lab7;

public class TestMobileDevices {
    public static void main(String[] args) {
        // สร้างออบเจ็กต์ IPadAir 2 เครื่อง พร้อมระบุสี ราคา และขนาดความจุ
        IPadAir ipadAir1 = new IPadAir("Rose Gold", 19900.0, 64);
        IPadAir ipadAir2 = new IPadAir("Silver", 24900.0, 256);
        
        // สร้างออบเจ็กต์ AppleWatch พร้อมระบุสี ราคา และรุ่น
        AppleWatch appleWatch1 = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        
        // แสดงชื่อชิปของ IPadAir
        System.out.println("IPadAir chip name is " + IPadAir.getChipName());
        
        // ตรวจสอบว่า ipadAir2 เป็นนาฬิกาหรือไม่
        if (ipadAir2.isWatch()) {
            System.out.println(ipadAir2 + " is a watch");
        } else {
            System.out.println(ipadAir2 + " is not a watch");
        }
        
        // เปรียบเทียบราคาของ ipadAir1 และ ipadAir2
        comparePrice(ipadAir1, ipadAir2);
        
        // เปรียบเทียบราคาของ ipadAir1 และ appleWatch1
        comparePrice(ipadAir1, appleWatch1);
    }

    // เมทอดสำหรับเปรียบเทียบราคาของอุปกรณ์ MobileDevice สองเครื่อง
    public static void comparePrice(MobileDevice device1, MobileDevice device2) {
        if(device1.getPrice() < device2.getPrice()) {
            System.out.println(device1 + " is cheaper than " + device2);
        } else if (device1.getPrice() > device2.getPrice()) {
            System.out.println(device2 + " is cheaper than " + device1);
        }
    }
}

