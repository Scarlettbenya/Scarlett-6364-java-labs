package mcfadden.scarlett.lab10;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

public class MobileDeviceV9 extends MobileDeviceV8 implements ActionListener {
    protected JFileChooser fileChooser; // ตัวเลือกไฟล์สำหรับเปิดหรือบันทึกไฟล์

    // Constructor สำหรับกำหนดชื่อหน้าต่าง
    public MobileDeviceV9(String title) {
        super(title);
    }

    // เมธอดเพิ่มตัวฟัง (Listener) ให้กับปุ่มและเมนูต่างๆ
    public void addListeners() {
        super.addListeners(); // เรียกใช้ addListeners() ของคลาสแม่
        submitButton.addActionListener(this); // เพิ่ม Listener ให้ปุ่ม Submit
        resetButton.addActionListener(this); // เพิ่ม Listener ให้ปุ่ม Reset
        newMI.addActionListener(this); // เมนู New
        openMI.addActionListener(this); // เมนู Open
        saveMI.addActionListener(this); // เมนู Save
        exitMI.addActionListener(this); // เมนู Exit
        smallMI.addActionListener(this); // เมนูเปลี่ยนขนาดฟอนต์ (Small)
        mediumMI.addActionListener(this); // เมนูเปลี่ยนขนาดฟอนต์ (Medium)
        largeMI.addActionListener(this); // เมนูเปลี่ยนขนาดฟอนต์ (Large)
        extralargeMI.addActionListener(this); // เมนูเปลี่ยนขนาดฟอนต์ (Extra Large)
        blackMI.addActionListener(this); // เมนูเปลี่ยนสีข้อความ (Black)
        redMI.addActionListener(this); // เมนูเปลี่ยนสีข้อความ (Red)
        greenMI.addActionListener(this); // เมนูเปลี่ยนสีข้อความ (Green)
        blueMI.addActionListener(this); // เมนูเปลี่ยนสีข้อความ (Blue)
        font1MI.addActionListener(this); // เมนูเปลี่ยนฟอนต์เป็น Serif
        font2MI.addActionListener(this); // เมนูเปลี่ยนฟอนต์เป็น SansSerif
        font3MI.addActionListener(this); // เมนูเปลี่ยนฟอนต์เป็น Monospaced
    }

    // เมธอดจัดการเหตุการณ์เมื่อผู้ใช้กดปุ่มหรือเมนู
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource(); // รับค่าอ็อบเจกต์ที่เกิดเหตุการณ์

        // กดเมนู "New" เพื่อล้างข้อมูลในฟอร์ม
        if (src == newMI) {
            deviceNameField.setText(""); // ล้างช่องกรอกชื่ออุปกรณ์
            brandField.setText(""); // ล้างช่องกรอกยี่ห้อ
            priceField.setText(""); // ล้างช่องกรอกราคา
            smartphoneButton.setSelected(false); // ยกเลิกการเลือกประเภทอุปกรณ์
            osComboBox.setSelectedIndex(0); // รีเซ็ตค่าระบบปฏิบัติการ
            featuresTextArea.setText(""); // ล้างช่องกรอกคุณสมบัติ
            vendorList.clearSelection(); // รีเซ็ตร้านค้าที่มีจำหน่าย
            RatingSlider.setValue(5); // รีเซ็ตคะแนน Rating เป็นค่าเริ่มต้น
        }
        // กดเมนู "Open" หรือ "Save" เพื่อเปิดหรือบันทึกไฟล์
        else if (src == openMI || src == saveMI) {
            fileChooser = new JFileChooser(); // สร้างตัวเลือกไฟล์
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt")); // กำหนดให้เลือกเฉพาะไฟล์ .txt
            
            // แสดง Dialog เลือกไฟล์ (Open หรือ Save)
            int returnValue = (src == openMI) ? fileChooser.showOpenDialog(this) : fileChooser.showSaveDialog(this);
            
            // ถ้าผู้ใช้กด "OK"
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().getName(); // รับชื่อไฟล์ที่เลือก
                JOptionPane.showMessageDialog(this, (src == openMI) ? "Opening: " + fileName : "Data is saved to " + fileName + " successfully");
                // แสดงข้อความแจ้งเตือนว่าเปิดหรือบันทึกไฟล์สำเร็จ
            }
        }
        // กดเมนู "Exit" เพื่อปิดโปรแกรม
        else if (src == exitMI) {
            System.exit(0); // ปิดโปรแกรม
        }
        // กดเมนูเปลี่ยนขนาดฟอนต์
        else if (src == smallMI || src == mediumMI || src == largeMI || src == extralargeMI) {
            int size = (src == smallMI) ? 10 : (src == mediumMI) ? 14 : (src == largeMI) ? 18 : 22; // กำหนดขนาดฟอนต์
            Font newFont = new Font(featuresTextArea.getFont().getFontName(), featuresTextArea.getFont().getStyle(), size); // สร้างฟอนต์ใหม่
            deviceNameField.setFont(newFont); // เปลี่ยนฟอนต์ของช่องกรอกชื่ออุปกรณ์
            brandField.setFont(newFont); // เปลี่ยนฟอนต์ของช่องกรอกยี่ห้อ
            priceField.setFont(newFont); // เปลี่ยนฟอนต์ของช่องกรอกราคา
            featuresTextArea.setFont(newFont); // เปลี่ยนฟอนต์ของช่องกรอกคุณสมบัติ
        }
        // กดเมนูเปลี่ยนสีข้อความ
        else if (src == blackMI || src == redMI || src == greenMI || src == blueMI) {
            Color color = (src == blackMI) ? Color.BLACK : (src == redMI) ? Color.RED : (src == greenMI) ? Color.GREEN : Color.BLUE; // กำหนดสี
            deviceNameField.setForeground(color); // เปลี่ยนสีข้อความของช่องกรอกชื่ออุปกรณ์
            brandField.setForeground(color); // เปลี่ยนสีข้อความของช่องกรอกยี่ห้อ
            priceField.setForeground(color); // เปลี่ยนสีข้อความของช่องกรอกราคา
            featuresTextArea.setForeground(color); // เปลี่ยนสีข้อความของช่องกรอกคุณสมบัติ
        }
        // กดเมนูเปลี่ยนรูปแบบฟอนต์
        else if (src == font1MI || src == font2MI || src == font3MI) {
            String fontName = (src == font1MI) ? "Serif" : (src == font2MI) ? "SansSerif" : "Monospaced"; // กำหนดชื่อฟอนต์
            Font newFont = new Font(fontName, featuresTextArea.getFont().getStyle(), featuresTextArea.getFont().getSize()); // สร้างฟอนต์ใหม่
            deviceNameField.setFont(newFont); // เปลี่ยนฟอนต์ของช่องกรอกชื่ออุปกรณ์
            brandField.setFont(newFont); // เปลี่ยนฟอนต์ของช่องกรอกยี่ห้อ
            priceField.setFont(newFont); // เปลี่ยนฟอนต์ของช่องกรอกราคา
            featuresTextArea.setFont(newFont); // เปลี่ยนฟอนต์ของช่องกรอกคุณสมบัติ
        }
    }

    // เมธอดสร้างและแสดง GUI
    public static void createAndShowGUI() {
        MobileDeviceV9 msw = new MobileDeviceV9("Mobile Device V9");
        msw.addMenus(); // เพิ่มเมนู
        msw.addListeners(); // เพิ่ม Listener
        msw.setFrameFeatures(); // กำหนดคุณสมบัติของหน้าต่าง
    }

    // เมธอด main สำหรับเรียกใช้โปรแกรม
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // ใช้ Thread แยกในการเรียก GUI
            public void run() {
                createAndShowGUI(); // สร้างและแสดง GUI
            }
        });
    }
}

