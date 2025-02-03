package mcfadden.scarlett.lab8;
import java.awt.*;
import javax.swing.*;

class MobileDeviceV1 extends MySimpleWindow {
    protected JTextField deviceNameField, brandField, priceField; // ประกาศตัวแปรสำหรับช่องกรอกข้อมูล
    protected JRadioButton smartphoneButton, tabletButton; // ประกาศตัวแปรสำหรับปุ่มเลือก
    
    public MobileDeviceV1(String title) {
        super(title);  // เรียกคอนสตรัคเตอร์ของคลาสMySimpleWindow
        addComponents(); // เพิ่มคอมโพเนนต์ต่าง ๆ ลงในหน้าต่าง
        setFrameFeatures(); // ตั้งค่าคุณสมบัติพื้นฐานของหน้าต่าง เช่น การแสดงผลและตำแหน่งหน้าต่าง
        
    }
    
    @Override // Override เมธอด addComponents เพื่อเพิ่มคอมโพเนนต์เฉพาะสำหรับ MobileDeviceV1
    protected void addComponents() {
        super.addComponents(); // เรียกใช้งานเมธอด addComponents
        
        JPanel formPanel = new JPanel(new GridLayout(4, 2)); // สร้างแผง formPanel สำหรับจัดวางแบบฟอร์ม
        
        formPanel.add(new JLabel("Device Name:")); // แถวที่ 1: เพิ่ม JLabel "Device Name:" และช่องกรอกข้อความสำหรับชื่ออุปกรณ์
        deviceNameField = new JTextField(15); // กำหนดความกว้างของช่องกรอกเป็น 15 คอลัมน์
        formPanel.add(deviceNameField);
        
        formPanel.add(new JLabel("Brand:")); // แถวที่ 2: เพิ่ม JLabel "Brand:" และช่องกรอกข้อความสำหรับยี่ห้อของอุปกรณ์
        brandField = new JTextField(15);
        formPanel.add(brandField);
        
        formPanel.add(new JLabel("Price:")); // แถวที่ 3: เพิ่ม JLabel "Price:" และช่องกรอกข้อความสำหรับราคาของอุปกรณ์
        priceField = new JTextField(15);
        formPanel.add(priceField);
        
        formPanel.add(new JLabel("Type:")); // แถวที่ 4: เพิ่ม JLabel "Type:" และแผงสำหรับปุ่มเลือกประเภทอุปกรณ์
        JPanel typePanel = new JPanel(); // สร้างแผง typePanel สำหรับจัดวางปุ่มเลือกประเภท
        smartphoneButton = new JRadioButton("Smartphone", true); // สร้างปุ่มเลือก "Smartphone" โดยกำหนดให้เลือกเป็นค่าเริ่มต้น (true)
        tabletButton = new JRadioButton("Tablet"); // สร้างปุ่มเลือก "Tablet" โดยไม่กำหนดให้เลือกเป็นค่าเริ่มต้น
        
        ButtonGroup typeGroup = new ButtonGroup(); // สร้างกลุ่ม ButtonGroup เพื่อให้ปุ่มเลือกทำงานแบบเลือกได้เพียงอันเดียว
        typeGroup.add(smartphoneButton);
        typeGroup.add(tabletButton);
        typePanel.add(smartphoneButton); // เพิ่มปุ่มเลือกทั้งสองลงในแผง typePanel
        typePanel.add(tabletButton);
        formPanel.add(typePanel); // เพิ่มแผง typePanel ลงใน formPanel
        
        mainPanel.setLayout(new BorderLayout()); // กำหนดเลย์เอาต์ของ mainPanel
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public static void createAndShowGUI() { // เมธอด createAndShowGUI สำหรับสร้างและแสดงหน้าต่าง MobileDeviceV1
        MobileDeviceV1 msw1 = new MobileDeviceV1("Mobile Device V1"); // สร้างอ็อบเจ็กต์ MobileDeviceV1 และกำหนดชื่อหน้าต่าง
        msw1.setFrameFeatures(); // เรียกเมธอด setFrameFeatures เพื่อยืนยันการตั้งค่าของหน้าต่าง
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // เรียกเมธอดสร้างและแสดงหน้าต่าง MobileDeviceV1
            }
        });
    }
}
