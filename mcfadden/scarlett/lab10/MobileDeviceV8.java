package mcfadden.scarlett.lab10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mcfadden.scarlett.lab9.*;

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {
    ButtonGroup typeButtonGroup; // กลุ่มปุ่มสำหรับเลือกประเภทของอุปกรณ์ (Smartphone หรือ Tablet)

    // Constructor กำหนดชื่อหน้าต่าง
    public MobileDeviceV8(String title) {
        super(title);
    }

    // เมธอดเพิ่มตัวฟัง (Listener) ให้กับปุ่ม Reset และ Submit
    protected void addListeners() {
        resetButton.addActionListener(this);
        submitButton.addActionListener(this);
    }

    // เมธอดตรวจจับการกระทำของผู้ใช้ (Event Handling)
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource(); // ตรวจสอบว่าเหตุการณ์เกิดจากปุ่มใด
        if (src == submitButton) { 
            JOptionPane.showMessageDialog(this, getMessage(), "Device Information", JOptionPane.INFORMATION_MESSAGE); 
            // แสดงข้อมูลของอุปกรณ์เมื่อกด Submit
        }
        if (src == resetButton) { 
            resetAction(); // รีเซ็ตค่าทั้งหมดเมื่อกดปุ่ม Reset
        }
    }

    // เมธอดสร้างข้อความแสดงข้อมูลของอุปกรณ์
    public String getMessage() {
        return "Device Name: " + deviceNameField.getText() + "\r\n" + // ชื่ออุปกรณ์
               "Brand: " + brandField.getText() + "\r\n" + // ยี่ห้อ
               "Price: " + priceField.getText() + "\r\n" + // ราคา
               "Type: " + (smartphoneButton.isSelected() ? smartphoneButton.getText() : tabletButton.getText()) + "\r\n" + // ประเภทของอุปกรณ์
               "Operating System: " + (osComboBox.getSelectedIndex()) + "\r\n" + // ระบบปฏิบัติการ
               "Features: " + featuresTextArea.getText() + "\r\n" + // คุณสมบัติพิเศษ
               "Available at: " + vendorList.getSelectedValue() + "\r\n" + // ร้านค้าที่มีจำหน่าย
               "Rating: " + RatingSlider.getValue(); // คะแนนเรตติ้ง
    }

    // เมธอดรีเซ็ตค่าทั้งหมดในฟอร์ม
    public void resetAction() {
        resetTextFieldAction(mainPanel); // รีเซ็ตค่า TextField
        resetTextAreaAction(mainPanel); // รีเซ็ตค่า TextArea
        resetTypeAction(); // รีเซ็ตประเภทอุปกรณ์ให้เป็นค่าเริ่มต้น
        resetOperatingSystemAction(); // รีเซ็ตค่าระบบปฏิบัติการ
        resetDeviceAvalableAction(); // รีเซ็ตร้านค้าที่มีจำหน่าย
        resetSliderAction(); // รีเซ็ตค่าเรตติ้ง
    }

    // เมธอดรีเซ็ตค่า TextField ทั้งหมดที่อยู่ใน Container
    public void resetTextFieldAction(Container container) {
        for (Component child : container.getComponents()) { // วนลูปผ่านทุกองค์ประกอบใน Container
            if (child instanceof Container) {
                resetTextFieldAction((Container) child); // ถ้าเป็น Container ให้เรียกเมธอดนี้ซ้ำ
            }
            if (child instanceof JTextField) {
                ((JTextField) child).setText(""); // รีเซ็ตค่าเป็นค่าว่าง
            }
        }
    }

    // เมธอดรีเซ็ตค่า TextArea ทั้งหมดที่อยู่ใน Container
    public void resetTextAreaAction(Container container) {
        for (Component child : container.getComponents()) {
            if (child instanceof Container) {
                resetTextAreaAction((Container) child);
            }
            if (child instanceof JTextArea) {
                ((JTextArea) child).setText(""); // รีเซ็ตค่าเป็นค่าว่าง
            }
        }
    }

    // รีเซ็ตประเภทของอุปกรณ์ให้กลับมาเป็น "Smartphone"
    public void resetTypeAction() {
        smartphoneButton.setSelected(true);
    }

    // รีเซ็ตค่าของระบบปฏิบัติการให้กลับมาเป็นค่าตัวเลือกแรก
    public void resetOperatingSystemAction() {
        osComboBox.setSelectedIndex(0);
    }

    // รีเซ็ตค่าการเลือกร้านค้าที่มีจำหน่าย
    public void resetDeviceAvalableAction() {
        vendorList.clearSelection();
    }

    // รีเซ็ตค่า Slider ให้กลับไปที่ค่าเริ่มต้น (5)
    public void resetSliderAction() {
        RatingSlider.setValue(5);
    }

    // เมธอดเพิ่มองค์ประกอบใน GUI
    @Override
    public void addComponents() {
        super.addComponents(); // เรียกใช้เมธอดจากคลาสแม่
        typeButtonGroup = new ButtonGroup(); // สร้างกลุ่มปุ่มประเภทอุปกรณ์
        typeButtonGroup.add(smartphoneButton);
        typeButtonGroup.add(tabletButton);
    }

    // เมธอดสร้างและแสดง GUI
    public static void createAndShowGUI() {
        MobileDeviceV8 msw = new MobileDeviceV8("Mobile Device V8");
        msw.setFrameFeatures();
        msw.addListeners();
    }

    // เมธอด main สำหรับเรียกใช้โปรแกรม
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // ใช้ Thread แยกในการเรียก GUI
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

