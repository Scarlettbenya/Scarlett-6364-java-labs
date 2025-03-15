//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//last update: 10/03/2025

package mcfadden.scarlett.lab12;

import java.awt.event.*;
import javax.swing.*;
import mcfadden.scarlett.lab10.*;

// คลาส MobileDeviceV12 สืบทอดมาจาก MobileDeviceV11
public class MobileDeviceV12 extends MobileDeviceV11 {

    // Constructor กำหนดชื่อของหน้าต่าง
    public MobileDeviceV12(String title) {
        super(title);
    }

    // เมธอดที่ใช้จัดการกับอีเวนต์ของช่องกรอกข้อมูล
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e); // เรียกใช้งาน actionPerformed ของคลาสแม่

        // กำหนดชื่อให้กับ JTextField แต่ละตัว
        deviceNameField.setName("Device Name");
        brandField.setName("Brand");
        priceField.setName("Price");

        // ตรวจสอบว่าอีเวนต์มาจาก JTextField ตัวไหน
        Object srcObject = e.getSource();
        if (srcObject == deviceNameField) {
            handleNormalTextField(deviceNameField, brandField); // ตรวจสอบค่าที่กรอก และเปิดใช้งานช่องถัดไป
        } else if (srcObject == brandField) {
            handleNormalTextField(brandField, priceField);
        } else if (srcObject == priceField) {
            handlePosNumTextField(priceField, osComboBox); // ตรวจสอบว่าเป็นตัวเลขบวกหรือไม่
        }
    }

    // เมธอดสำหรับตรวจสอบค่าที่ป้อนใน JTextField และเปิด/ปิดช่องถัดไป
    public void handleNormalTextField(JTextField textFD, JComponent nextComponent) {
        // รีเซ็ตชื่อของฟิลด์เพื่อให้แน่ใจว่ามีค่า name สำหรับแสดงผล
        deviceNameField.setName(" Device Name");
        brandField.setName(" Brand");
        priceField.setName(" Price");

        // ถ้าผู้ใช้ไม่ได้ป้อนค่า หรือช่องว่าง
        if (textFD.getText() == null || textFD.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + textFD.getName(), 
                                          "Message", JOptionPane.INFORMATION_MESSAGE);
            textFD.requestFocusInWindow(); // โฟกัสกลับไปที่ช่องที่ว่าง
            nextComponent.setEnabled(false); // ปิดใช้งานช่องถัดไป
        } else {
            JOptionPane.showMessageDialog(this, textFD.getName() + " is changed to " + textFD.getText(), 
                                          "Message", JOptionPane.INFORMATION_MESSAGE);
            nextComponent.setEnabled(true); // เปิดใช้งานช่องถัดไป
        }
    }

    // เมธอดสำหรับตรวจสอบค่าที่ป้อนใน priceField ว่าเป็นจำนวนบวกหรือไม่
    private static void handlePosNumTextField(JTextField textFD, JComboBox<String> nextComponent) {
        try {
            int priceFieldInt = Integer.parseInt(textFD.getText()); // แปลงข้อความเป็นตัวเลข

            if (priceFieldInt <= 0) { // ถ้าค่าที่ป้อน <= 0 ให้แสดงข้อความแจ้งเตือน
                JOptionPane.showMessageDialog(null, "Price must be a positive number in " + textFD.getName() + ".", 
                                              "Message", JOptionPane.INFORMATION_MESSAGE);
                textFD.requestFocusInWindow(); // โฟกัสกลับไปที่ช่องป้อนราคา
                nextComponent.setEnabled(false); // ปิดใช้งานช่องถัดไป
            } else { // ถ้าค่าถูกต้อง
                JOptionPane.showMessageDialog(null, textFD.getName() + " is changed to " + textFD.getText(), 
                                              "Message", JOptionPane.INFORMATION_MESSAGE);
                nextComponent.setEnabled(true); // เปิดใช้งานช่องถัดไป
            }
        } catch (NumberFormatException e) { // ถ้าผู้ใช้ป้อนค่าที่ไม่ใช่ตัวเลข
            JOptionPane.showMessageDialog(null, "Please enter a valid number in " + textFD.getName() + ".", 
                                          "Message", JOptionPane.INFORMATION_MESSAGE);
            textFD.requestFocusInWindow(); // โฟกัสกลับไปที่ช่องป้อนราคา
            nextComponent.setEnabled(false); // ปิดใช้งานช่องถัดไป
        }
    }

    // เมธอดเพิ่ม Event Listener ให้กับ JTextField
    @Override
    public void addListeners() {
        super.addListeners(); // เรียก addListeners() ของคลาสแม่
        deviceNameField.addActionListener(this);
        brandField.addActionListener(this);
        priceField.addActionListener(this);
    }

    // เมธอดสร้างและแสดง GUI
    public static void createAndShowGUI() {
        MobileDeviceV12 msw12 = new MobileDeviceV12("Mobile Device V12"); // สร้างอินสแตนซ์ของ GUI
        msw12.addListeners(); // เพิ่ม event listeners
        msw12.setFrameFeatures(); // ตั้งค่าหน้าต่าง
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
