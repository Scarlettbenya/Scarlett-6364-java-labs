package mcfadden.scarlett.lab9;
import javax.swing.*;
import java.awt.*;

public class MobileDeviceV7 extends MobileDeviceV6 {
    // Constructor สำหรับ MobileDeviceV7 รับ title เป็นพารามิเตอร์และเรียกใช้ constructor ของ MobileDeviceV6
    public MobileDeviceV7(String title) {
        super(title);
    }

    @Override
    public void addComponents() {
        // เรียกใช้เมธอด addComponents() จาก MobileDeviceV6
        super.addComponents();

        // ตั้งค่าเริ่มต้นสำหรับฟิลด์ข้อมูล
        deviceNameField.setText("Samsung Galaxy S25 Ultra"); // ชื่ออุปกรณ์
        brandField.setText("Samsung");                       // ยี่ห้อ
        priceField.setText("46900");                         // ราคา

        // กำหนดให้ปุ่ม Smartphone ถูกเลือก
        smartphoneButton.setSelected(true);

        // กำหนดระบบปฏิบัติการเป็น "Android"
        osComboBox.setSelectedItem("Android");

        // กำหนดรายละเอียดฟีเจอร์ของอุปกรณ์ใน TextArea
        featuresTextArea.setText(
                "- 200MP Camera\n" +
                "- 1TB Storage\n" +
                "- Snapdragon Gen 4 Processor\n" +
                "- 5000mAh Battery\n" +
                "- 6.8-inch AMOLED Display\n" +
                "- 120Hz Refresh Rate\n" +
                "- Fast Charging"
        );

        // ตั้งค่าคะแนนเริ่มต้นใน Slider เป็น 9
        RatingSlider.setValue(9);

        // สร้างและเพิ่มภาพของอุปกรณ์โดยใช้ ReadImage
        ReadImage imagePanel = new ReadImage("mcfadden/scarlett/lab9/images/S25-ultra.jpg", 0.55f); 
        // ตั้งค่าขนาดที่ต้องการของ Panel สำหรับรูปภาพ
        imagePanel.setPreferredSize(new Dimension(30, 400));

        // เพิ่ม Panel สำหรับรูปภาพลงใน Content Pane ด้านล่างของหน้าต่าง
        getContentPane().add(imagePanel, BorderLayout.SOUTH);       
    }

    // เมธอดสำหรับสร้าง GUI และแสดงหน้าต่าง
    public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
        mdv7.setFrameFeatures(); // ตั้งค่าคุณสมบัติของหน้าต่าง
        mdv7.pack();             // จัดขนาดหน้าต่างตามเนื้อหาภายใน
    }

    // เมธอด main สำหรับรันโปรแกรม
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // เรียกใช้เมธอดสำหรับสร้าง GUI
            }
        });
    }
}
