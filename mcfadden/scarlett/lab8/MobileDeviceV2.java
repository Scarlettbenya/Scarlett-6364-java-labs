package mcfadden.scarlett.lab8;
import java.awt.*;
import javax.swing.*;

class MobileDeviceV2 extends MobileDeviceV1 {
    private JComboBox<String> osComboBox;  // ประกาศตัวแปรสำหรับ JComboBox
    private JTextArea featuresTextArea; // ประกาศตัวแปรสำหรับ JTextArea

    public MobileDeviceV2(String title) {
        super(title); // เรียกคอนสตรัคเตอร์
    }

    @Override // Override เมธอด addComponents เพื่อเพิ่มคอมโพเนนต์เพิ่มเติม
    protected void addComponents() {
        super.addComponents(); // เรียกใช้งานเมธอด addComponents

        JPanel extraPanel = new JPanel(new GridLayout(2, 2)); // สร้างแผง extraPanel สำหรับจัดวางคอมโพเนนต์เพิ่มเติม โดยใช้ GridLayout
        
        extraPanel.add(new JLabel("Operating System:")); // แถวที่ 1, คอลัมน์ที่ 1: เพิ่ม JLabel เพื่อแสดงข้อความ "Operating System:"
        String[] osOptions = {"Android", "iOS", "Windows", "Others"}; // สร้างอาร์เรย์ของตัวเลือก
        osComboBox = new JComboBox<>(osOptions); // สร้าง JComboBox โดยใช้ข้อมูลจากอาร์เรย์ osOptions
        osComboBox.setSelectedIndex(0); // กำหนดให้ JComboBox เลือกตัวเลือกแรก
        extraPanel.add(osComboBox); // แถวที่ 1, คอลัมน์ที่ 2: เพิ่ม JComboBox ลงใน extraPanel
        
        extraPanel.add(new JLabel("Features:")); // เพิ่ม JLabel 
        featuresTextArea = new JTextArea(3, 25); // สร้าง JTextArea สำหรับกรอกข้อมูลคุณสมบัติ โดยกำหนดขนาดให้มี 3 แถว และ 25 คอลัมน์
        JScrollPane scrollPane = new JScrollPane(featuresTextArea); // ใน featuresTextArea เพิ่ม JScrollPane เพื่อให้มีแถบเลื่อนเมื่อเนื้อหามากเกินพื้นที่
        extraPanel.add(scrollPane); // เพิ่ม JScrollPane ที่มี featuresTextArea ลงใน extraPanel
        
        mainPanel.add(extraPanel, BorderLayout.CENTER); // เพิ่ม extraPanel ลงใน mainPanel โดยวางไว้ที่ตำแหน่งกลาง
    }

    public static void createAndShowGUI() { // เมธอด createAndShowGUI สำหรับสร้างและแสดงหน้าต่าง MobileDeviceV1
        MobileDeviceV2 msw2 = new MobileDeviceV2("Mobile Device V2"); // สร้างอ็อบเจ็กต์ MobileDeviceV1 และกำหนดชื่อหน้าต่าง
        msw2.setFrameFeatures(); // เรียกเมธอด setFrameFeatures เพื่อยืนยันการตั้งค่าของหน้าต่าง
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // เรียกเมธอดสร้างและแสดงหน้าต่าง MobileDeviceV2
            }
        });
    }
}
