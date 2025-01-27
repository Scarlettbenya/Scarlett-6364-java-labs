package mcfadden.scarlett.lab7;
import java.util.Comparator;
import java.util.Arrays;

public class SortMobileDevicesbyPrice implements Comparator<MobileDevice> {
    
    // เมทอด compare() ใช้เปรียบเทียบราคาของอุปกรณ์สองเครื่อง
    public int compare(MobileDevice device1, MobileDevice device2) {
        // เปรียบเทียบราคาจากน้อยไปมาก (Ascending order)
        return Double.compare(device1.getPrice(), device2.getPrice());
    }

    public static void main(String[] args) {
        // สร้างอาร์เรย์ของอุปกรณ์ MobileDevice จำนวน 4 เครื่อง
        MobileDevice[] devices = new MobileDevice[4];

        // เพิ่ม iPadAir และ AppleWatch ลงในอาร์เรย์ โดยกำหนดสี ราคา และสเปกต่าง ๆ
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        devices[2] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        devices[3] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");

        // เรียงลำดับอุปกรณ์ตามราคาโดยใช้ SortMobileDevicesbyPrice เป็นตัวเปรียบเทียบ
        Arrays.sort(devices, new SortMobileDevicesbyPrice());

        // แสดงผลอุปกรณ์หลังจากเรียงลำดับแล้ว
        System.out.println("Mobile devices sorted by price:");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }
}

