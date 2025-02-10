package mcfadden.scarlett.lab9;
import java.awt.*;
import javax.swing.*;

public class MobileDeviceV6 extends MobileDeviceV5 {
    // Constructor สำหรับ MobileDeviceV6 รับ title เป็นพารามิเตอร์และเรียกใช้ constructor ของ MobileDeviceV5
    public MobileDeviceV6(String title) {
        super(title);
    }

    @Override
    public void addComponents() {
        // เรียกใช้เมธอด addComponents() ของคลาส MobileDeviceV5
        super.addComponents();

        // ปรับแต่ง Component ต่าง ๆ ใน Container ด้วยเมธอด customizeComponents()
        customizeComponents(getContentPane());
    }

    // เมธอดสำหรับปรับแต่ง Component ใน Container
    private void customizeComponents(Container container) {
        // วนลูปผ่าน Component ทุกตัวใน Container
        for (Component component : container.getComponents()) {
            // ตรวจสอบว่า Component เป็น JLabel
            if (component instanceof JLabel label) {
                label.setFont(new Font("Arial", Font.BOLD, 14)); // ตั้งค่า font เป็น Arial ตัวหนา ขนาด 14
                label.setForeground(new Color(0x000080)); // ตั้งค่าสีข้อความเป็นสีน้ำเงินเข้ม
            } 
            // ตรวจสอบว่า Component เป็น JTextField
            else if (component instanceof JTextField textField) {
                textField.setBackground(Color.LIGHT_GRAY); // ตั้งค่าสีพื้นหลังเป็นสีเทาอ่อน
                textField.setForeground(Color.DARK_GRAY);  // ตั้งค่าสีข้อความเป็นสีเทาเข้ม
            } 
            // ตรวจสอบว่า Component เป็น JTextArea
            else if (component instanceof JTextArea textArea) {
                textArea.setBackground(new Color(255, 255, 200)); // ตั้งค่าสีพื้นหลังเป็นสีเหลืองอ่อน
                textArea.setForeground(Color.DARK_GRAY);         // ตั้งค่าสีข้อความเป็นสีเทาเข้ม
                textArea.setFont(new Font("Arial", Font.ITALIC, 12)); // ตั้งค่า font เป็น Arial ตัวเอียง ขนาด 12
                textArea.setLineWrap(true);                      // เปิดใช้งานการตัดคำเมื่อข้อความเกินขอบ
                textArea.setWrapStyleWord(true);                 // เปิดใช้งานการตัดคำแบบสมบูรณ์
            } 
            // ตรวจสอบว่า Component เป็น JList
            else if (component instanceof JList<?> list) {
                list.setBackground(Color.LIGHT_GRAY);           // ตั้งค่าสีพื้นหลังเป็นสีเทาอ่อน
                list.setForeground(new Color(0x006400));        // ตั้งค่าสีข้อความเป็นสีเขียวเข้ม
                list.setFont(new Font("Arial", Font.BOLD, 12)); // ตั้งค่า font เป็น Arial ตัวหนา ขนาด 12
                list.setSelectionBackground(Color.YELLOW);      // ตั้งค่าสีพื้นหลังเมื่อเลือกเป็นสีเหลือง
                list.setSelectionForeground(Color.BLACK);       // ตั้งค่าสีข้อความเมื่อเลือกเป็นสีดำ
            } 
            // ตรวจสอบว่า Component เป็น JButton
            else if (component instanceof JButton button) {
                switch (button.getText()) {
                    // กรณีปุ่มมีข้อความเป็น "OK"
                    case "OK" -> {
                        button.setForeground(Color.GREEN);    // ตั้งค่าสีข้อความเป็นสีเขียว
                        button.setBackground(Color.WHITE);    // ตั้งค่าสีพื้นหลังเป็นสีขาว
                    }
                    // กรณีปุ่มมีข้อความเป็น "Cancel"
                    case "Cancel" -> {
                        button.setForeground(Color.RED);      // ตั้งค่าสีข้อความเป็นสีแดง
                        button.setBackground(Color.WHITE);    // ตั้งค่าสีพื้นหลังเป็นสีขาว
                    }
                }
            } 
            // หาก Component เป็น Container (เช่น JPanel) ให้เรียกใช้เมธอดนี้แบบ recursive
            else if (component instanceof Container childContainer) {
                customizeComponents(childContainer);
            }
        }
    }

    // เมธอดสำหรับสร้าง GUI และแสดงหน้าต่าง
    public static void createAndShowGUI() {
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");
        mdv6.setFrameFeatures();
    }

    // เมธอด main สำหรับรันโปรแกรม
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
