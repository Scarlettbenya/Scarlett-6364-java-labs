package mcfadden.scarlett.lab11;

import java.awt.event.*;
import javax.swing.*;

public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener{
    // Constructor สำหรับคลาส MobileDeviceCompleteV2
    public MobileDeviceCompleteV2(String title) {
        super(title);  // เรียกใช้งาน constructor ของคลาสพ่อ
    }

    // เมธอดนี้ใช้เพิ่ม ActionListener ให้กับฟิลด์ต่างๆ
    public void addListeners() {
        deviceNameField.addActionListener(this);  // เพิ่ม ActionListener ให้กับ deviceNameField
        brandField.addActionListener(this);       // เพิ่ม ActionListener ให้กับ brandField
        priceField.addActionListener(this);       // เพิ่ม ActionListener ให้กับ priceField
    }

    // เมธอดนี้จะถูกเรียกเมื่อมีการกดปุ่ม Enter ในฟิลด์ต่างๆ
    @Override
    public void actionPerformed(ActionEvent e) {
        // ถ้าผู้ใช้กด Enter ในฟิลด์ deviceNameField
        if (e.getSource() == deviceNameField ) {
            JOptionPane.showMessageDialog(this, "You pressed Enter in Device Name Field: " + deviceNameField.getText());
        }
        // ถ้าผู้ใช้กด Enter ในฟิลด์ brandField
        if (e.getSource() == brandField ) {
            JOptionPane.showMessageDialog(this, "Brand field says: " + brandField.getText());
        }
        // ถ้าผู้ใช้กด Enter ในฟิลด์ priceField
        if (e.getSource() == priceField ) {
            JOptionPane.showMessageDialog(this, "Price entered: " + priceField.getText());
        }
    }

    // เมธอดนี้ใช้สำหรับสร้างและแสดง GUI
    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 window = new MobileDeviceCompleteV2("Mobile Device Complete2");
        window.addComponents();  // เพิ่มคอมโพเนนต์ต่างๆ ให้กับหน้าต่าง
        window.addListeners();   // เพิ่ม listeners ให้กับฟิลด์ต่างๆ
        window.addMenus();       // เพิ่มเมนูต่างๆ ให้กับหน้าต่าง
        window.setFrameFeatures();  // ตั้งค่าคุณสมบัติของหน้าต่าง
    }

    // เมธอด main ที่จะเรียกใช้การแสดง GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run(){
                createAndShowGUI();  // เรียกใช้เมธอดสร้างและแสดง GUI
            }
        }));
    }
}
