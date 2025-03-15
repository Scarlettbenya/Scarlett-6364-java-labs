//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//last update: 10/03/2025

package mcfadden.scarlett.lab12;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import mcfadden.scarlett.lab7.*;

// คลาส MobileDeviceV13 สืบทอดจาก MobileDeviceV12 และใช้ ActionListener
public class MobileDeviceV13 extends MobileDeviceV12 implements ActionListener {
    protected JButton addButton, displayButton; // ปุ่มสำหรับเพิ่มและแสดงรายการอุปกรณ์
    protected ArrayList<MobileDevice> mobileList; // รายการเก็บข้อมูลอุปกรณ์

    // Constructor รับค่าชื่อหน้าต่างและกำหนดค่าเริ่มต้น
    public MobileDeviceV13(String title) {
        super(title);
        mobileList = new ArrayList<>(); // สร้างอาร์เรย์ลิสต์สำหรับเก็บอุปกรณ์
    }

    // เมธอดเพิ่มองค์ประกอบต่าง ๆ ลงใน GUI
    @Override
    public void addComponents() {
        super.addComponents(); // เรียกใช้เมธอดของคลาสแม่
        addButton = new JButton("Add"); // ปุ่มเพิ่มอุปกรณ์
        displayButton = new JButton("Display"); // ปุ่มแสดงรายการอุปกรณ์
        buttonPanel.add(addButton); // เพิ่มปุ่มลงใน Panel
        buttonPanel.add(displayButton);
    }
    
    // เมธอดเพิ่ม Event Listener ให้กับปุ่มต่าง ๆ
    @Override
    public void addListeners() {
        super.addListeners(); // เรียกใช้เมธอดของคลาสแม่
        addButton.addActionListener(this); // กำหนดให้ปุ่ม Add ตอบสนองต่อการกด
        displayButton.addActionListener(this); // กำหนดให้ปุ่ม Display ตอบสนองต่อการกด
    }

    // เมธอดจัดการเมื่อมีการกดปุ่ม
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource(); // ตรวจสอบว่าผู้ใช้กดปุ่มไหน
        if (src == addButton) {
            handleAddButton(); // เรียกเมธอดสำหรับเพิ่มอุปกรณ์
        } else if (src == displayButton) {
            handleDisplayButton(); // เรียกเมธอดสำหรับแสดงรายการอุปกรณ์
        } else {
            super.actionPerformed(e); // เรียกใช้งาน actionPerformed ของคลาสแม่
        }
    }

    // เมธอดสำหรับเพิ่มอุปกรณ์เข้าไปในรายการ
    public void handleAddButton() {
        String name = deviceNameField.getText().trim(); // ดึงชื่ออุปกรณ์จากช่องกรอก
        String brand = brandField.getText().trim(); // ดึงยี่ห้อจากช่องกรอก
        String priceText = priceField.getText().trim(); // ดึงราคาจากช่องกรอก
        String type = smartphoneButton.isSelected() ? "SmartPhone" : "Tablet"; // ตรวจสอบประเภทอุปกรณ์
        
        double price = Double.parseDouble(priceText); // แปลงราคาจาก String เป็น double

        MobileDevice newDevice;
        if (smartphoneButton.isSelected()) {
            newDevice = new SmartPhone(name, brand, price); // สร้างอ็อบเจ็กต์ Smartphone
        } else {
            newDevice = new Tablet(name, brand, price); // สร้างอ็อบเจ็กต์ Tablet
        }

        mobileList.add(newDevice); // เพิ่มอุปกรณ์ลงในรายการ
        JOptionPane.showMessageDialog(this,
            type + " " + name + " is added", // แสดงข้อความแจ้งเตือนว่าอุปกรณ์ถูกเพิ่ม
            "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    // เมธอดสำหรับแสดงรายการอุปกรณ์ทั้งหมดที่เพิ่มไว้
    public void handleDisplayButton() {
        if (mobileList.isEmpty()) { // ถ้ารายการว่างให้แจ้งเตือนผู้ใช้
            JOptionPane.showMessageDialog(this,
                "No devices to display", // แสดงข้อความแจ้งเตือน
                "Message", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder(); // ใช้ StringBuilder เพื่อสร้างข้อความรายการอุปกรณ์
        for (MobileDevice device : mobileList) {
            sb.append(device.toString()).append("\n"); // เพิ่มข้อมูลอุปกรณ์แต่ละตัวในรายการ
        }

        JOptionPane.showMessageDialog(this, sb.toString(), // แสดงรายการอุปกรณ์ทั้งหมด
            "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    // เมธอดสร้างและแสดง GUI
    public static void createAndShowGUI() {
        MobileDeviceV13 msw13 = new MobileDeviceV13("Mobile Device V13"); // สร้างอินสแตนซ์ของ GUI
        msw13.addListeners(); // เพิ่ม event listeners
        msw13.setFrameFeatures(); // ตั้งค่าหน้าต่าง
    }

    // เมธอด main สำหรับเริ่มต้นโปรแกรม
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // ใช้ invokeLater เพื่อให้ GUI ทำงานใน Event Dispatch Thread
            public void run() {
                createAndShowGUI(); // เรียกเมธอดที่สร้างและแสดง GUI
            }
        });
    }
}
