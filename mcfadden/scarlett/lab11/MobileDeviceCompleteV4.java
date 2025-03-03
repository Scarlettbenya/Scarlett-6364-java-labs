package mcfadden.scarlett.lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2 {
    // ประกาศตัวแปร JMenuItem สำหรับเมนู "Color"
    protected JMenuItem colorMI;

    // Constructor สำหรับคลาส MobileDeviceCompleteV4
    public MobileDeviceCompleteV4(String title) {
        super(title);  // เรียกใช้ constructor ของคลาสพ่อ (MobileDeviceCompleteV2)
    }

    // เมธอดนี้ใช้สำหรับเพิ่มเมนู "Config" และ "Color"
    @Override
    protected void addMenus() {
        super.addMenus();  // เรียกใช้งาน addMenus จากคลาสพ่อ
        configMenu = new JMenu("Config");  // สร้างเมนู "Config"
        colorMenu = new JMenu("Color");    // สร้างเมนูย่อย "Color"
        colorMI = new JMenuItem("Custom"); // สร้างเมนูไอเท็ม "Custom"
        colorMenu.add(colorMI);            // เพิ่มเมนูไอเท็มเข้าไปในเมนู "Color"
        configMenu.add(colorMenu);         // เพิ่มเมนู "Color" เข้าไปในเมนู "Config"
        menuBar.add(configMenu);           // เพิ่มเมนู "Config" ไปที่แถบเมนู
    }

    // เมธอดนี้ใช้สำหรับเพิ่ม ActionListener ให้กับเมนูไอเท็ม
    @Override
    public void addListeners() {
        colorMI.addActionListener(this);  // เพิ่ม ActionListener ให้กับ colorMI
    }

    // เมธอดนี้จะถูกเรียกเมื่อมีการคลิกเมนูไอเท็ม
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);  // เรียกใช้งาน actionPerformed ของคลาสพ่อ
        Object src = e.getSource(); // รับแหล่งที่มาของเหตุการณ์
        // ถ้าผู้ใช้คลิกที่เมนู "Custom" (colorMI)
        if (src == colorMI) {
            Color oldColor = deviceNameField.getForeground();  // รับสีปัจจุบันของข้อความใน deviceNameField
            Color newColor = JColorChooser.showDialog(this, "Choose Text Color", oldColor);  // แสดง dialog ให้ผู้ใช้เลือกสี
            if (newColor == null) { return; }  // ถ้าผู้ใช้ไม่เลือกสีใหม่ให้ยกเลิก
            // เปลี่ยนสีข้อความในฟิลด์ต่างๆ
            deviceNameField.setForeground(newColor); 
            brandField.setForeground(newColor); 
            priceField.setForeground(newColor); 
        }
    }

    // เมธอดนี้ใช้สำหรับสร้างและแสดง GUI
    public static void createAndShowGUI() {
        MobileDeviceCompleteV4 window = new MobileDeviceCompleteV4("Mobile Device Complete V4");
        window.addComponents();  // เพิ่มคอมโพเนนต์ต่างๆ ให้กับหน้าต่าง
        window.addMenus();       // เพิ่มเมนูต่างๆ ให้กับหน้าต่าง
        window.setFrameFeatures();  // ตั้งค่าคุณสมบัติของหน้าต่าง
        window.addListeners();   // เพิ่ม listeners ให้กับเมนูและฟิลด์
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
