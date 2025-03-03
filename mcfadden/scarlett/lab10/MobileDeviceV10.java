package mcfadden.scarlett.lab10;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.event.*;

// คลาส MobileDeviceV10 สืบทอดจาก MobileDeviceV9 และรองรับ ListSelectionListener และ ChangeListener
public class MobileDeviceV10 extends MobileDeviceV9 implements ListSelectionListener, ChangeListener {
    
    // Constructor รับค่าชื่อหน้าต่างและส่งไปยังคลาสแม่
    public MobileDeviceV10(String title) {
        super(title);
    }

    // เมธอดเพิ่มตัวฟัง (Listener) ให้กับองค์ประกอบ GUI ต่างๆ
    @Override
    public void addListeners() {
        super.addListeners(); // เรียกใช้ addListeners() ของคลาสแม่
        osComboBox.addActionListener(this); // เพิ่ม Listener ให้ ComboBox สำหรับเลือก OS
        vendorList.addListSelectionListener(this); // เพิ่ม Listener ให้ List สำหรับเลือกร้านค้า
        RatingSlider.addChangeListener(this); // เพิ่ม Listener ให้ Slider สำหรับให้คะแนน
    }

    // เมธอดจัดการเหตุการณ์เมื่อมีการกระทำ (ActionEvent) บนองค์ประกอบ GUI
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event); // ใช้งาน actionPerformed() จากคลาสแม่
        if (event.getSource() == osComboBox) { // ตรวจสอบว่าเหตุการณ์เกิดที่ osComboBox หรือไม่
            String chosenOS = (String) osComboBox.getSelectedItem(); // ดึงค่าที่เลือก
            JOptionPane.showMessageDialog(this, "You selected Operating System: " + chosenOS,
                    "OS Selection", JOptionPane.INFORMATION_MESSAGE); // แสดงข้อความแจ้งเตือน
        }
    }

    // เมธอดจัดการเหตุการณ์เมื่อมีการเปลี่ยนแปลงการเลือกใน List (ร้านค้าที่มีจำหน่าย)
    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) { // ตรวจสอบว่าการเลือกเสร็จสิ้นหรือไม่
            List<String> selectedVendors = vendorList.getSelectedValuesList(); // ดึงค่าร้านค้าที่ถูกเลือก
            if (selectedVendors.isEmpty()) { // ถ้าไม่มีร้านค้าใดถูกเลือก
                JOptionPane.showMessageDialog(this, "No vendor selected.",
                        "Vendor Selection", JOptionPane.WARNING_MESSAGE); // แสดงข้อความเตือน
            } else { // ถ้ามีร้านค้าที่ถูกเลือก
                String vendorNames = String.join(", ", selectedVendors); // รวมชื่อร้านค้าที่ถูกเลือก
                JOptionPane.showMessageDialog(this, "Device is available at: " + vendorNames,
                        "Vendor Selection", JOptionPane.INFORMATION_MESSAGE); // แสดงข้อความแจ้งเตือน
            }
        }
    }

    // เมธอดจัดการเหตุการณ์เมื่อมีการเปลี่ยนแปลงค่า Slider (คะแนน Rating)
    @Override
    public void stateChanged(ChangeEvent event) {
        if (!RatingSlider.getValueIsAdjusting()) { // ตรวจสอบว่าผู้ใช้ปล่อย Slider แล้วหรือไม่
            int currentRating = RatingSlider.getValue(); // รับค่าคะแนนปัจจุบัน
            JOptionPane.showMessageDialog(this, "New rating: " + currentRating,
                    "Rating Adjustment", JOptionPane.INFORMATION_MESSAGE); // แสดงข้อความแจ้งเตือน
        }
    }

    // เมธอดสร้างและแสดง GUI
    public static void createAndShowGUI() {
        MobileDeviceV10 msw = new MobileDeviceV10("Mobile Device V10");
        msw.setFrameFeatures(); // ตั้งค่าคุณสมบัติของหน้าต่าง
        msw.addListeners(); // เพิ่มตัวฟังเหตุการณ์ (Listeners)
    }

    // เมธอด main สำหรับเรียกใช้โปรแกรม
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // ใช้ Thread แยกสำหรับการสร้าง GUI
            public void run() {
                createAndShowGUI(); // สร้างและแสดง GUI
            }
        });
    }
}
