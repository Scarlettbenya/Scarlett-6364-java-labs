package mcfadden.scarlett.lab7;
import java.util.Arrays;
import java.util.Comparator;

// คลาส SortMobileDevices ใช้สำหรับเปรียบเทียบและเรียงลำดับอุปกรณ์ MobileDevice ตามเงื่อนไขที่กำหนด
class SortMobileDevices implements Comparator<MobileDevice> {
    @Override
    public int compare(MobileDevice d1, MobileDevice d2) {
        // เปรียบเทียบราคาของอุปกรณ์ก่อนเป็นลำดับแรก
        int priceComparison = Double.compare(d1.getPrice(), d2.getPrice());
        if (priceComparison != 0) {
            return priceComparison; // ถ้าราคาไม่เท่ากัน ให้เรียงตามราคา
        }

        // ตรวจสอบว่าทั้งสองอุปกรณ์เป็น IPadAir หรือไม่
        if (d1 instanceof IPadAir && d2 instanceof IPadAir) {
            IPadAir iPad1 = (IPadAir) d1;
            IPadAir iPad2 = (IPadAir) d2;
            
            // เปรียบเทียบความจุ (storage) ของ iPadAir
            int storageComparison = Double.compare(iPad1.getStorage(), iPad2.getStorage());
            if (storageComparison != 0) {
                return storageComparison; // ถ้าความจุไม่เท่ากัน ให้เรียงตามความจุ
            }
            
            // เปรียบเทียบสีของ iPadAir
            return iPad1.getColor().compareTo(iPad2.getColor());
        }

        // ตรวจสอบว่าทั้งสองอุปกรณ์เป็น AppleWatch หรือไม่
        if (d1 instanceof AppleWatch && d2 instanceof AppleWatch) {
            AppleWatch watch1 = (AppleWatch) d1;
            AppleWatch watch2 = (AppleWatch) d2;
            
            // เปรียบเทียบชื่อรุ่น (model name) ของ AppleWatch
            int modelComparison = watch1.getModelName().compareTo(watch2.getModelName());
            if (modelComparison != 0) {
                return modelComparison; // ถ้ารุ่นไม่เหมือนกัน ให้เรียงตามชื่อรุ่น
            }
            
            // เปรียบเทียบสีของ AppleWatch
            return watch1.getColor().compareTo(watch2.getColor());
        }

        // ถ้าทั้งสองอุปกรณ์เป็นคนละประเภท (iPadAir กับ AppleWatch) ให้เปรียบเทียบตามสี
        return d1.getColor().compareTo(d2.getColor());
    }

    public static void main (String[] args) {
        // สร้างอาร์เรย์ของ MobileDevice และใส่ข้อมูลตัวอย่าง
        MobileDevice[] devices = new MobileDevice[7];

        // เพิ่ม iPadAir ที่มีสีและราคาต่างกัน
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        
        // iPadAir ที่มีราคาเท่ากันแต่ความจุแตกต่างกัน
        devices[2] = new IPadAir("Space Gray", 19900.0, 128);
        devices[3] = new IPadAir("Silver", 19900.0, 64);
        
        // เพิ่ม AppleWatch ที่มีราคาต่างกัน
        devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        
        // AppleWatch ที่มีราคาเท่ากันแต่เป็นคนละรุ่น
        devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
        devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");

        // ใช้ Arrays.sort() เพื่อเรียงลำดับอุปกรณ์โดยใช้ SortMobileDevices เป็นตัวเปรียบเทียบ
        Arrays.sort(devices, new SortMobileDevices());

        // แสดงผลลัพธ์หลังจากเรียงลำดับแล้ว
        System.out.println("Mobile devices sorted by multiple criteria");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }
}

