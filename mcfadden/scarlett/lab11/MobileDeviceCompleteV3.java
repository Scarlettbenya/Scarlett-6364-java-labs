package mcfadden.scarlett.lab11;

import java.awt.event.*;
import javax.swing.*;

public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener {

    // Constructor สำหรับคลาส MobileDeviceCompleteV3
    public MobileDeviceCompleteV3(String title) {
        super(title);  // เรียกใช้งาน constructor ของคลาสพ่อ (MobileDeviceCompleteV2)
    }

    // เมธอดนี้ใช้เพิ่ม listeners ให้กับหน้าต่าง
    @Override
    public void addListeners() {
        super.addListeners();  // เรียกใช้ addListeners ของคลาสพ่อ
        this.addComponentListener(this);  // เพิ่ม ComponentListener ให้กับหน้าต่าง
    }

    // เมธอดนี้จะถูกเรียกเมื่อหน้าต่างถูกซ่อนไว้
    @Override
    public void componentHidden(ComponentEvent e) {
        JOptionPane.showMessageDialog(this, "Window is now invisible.", "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    // เมธอดนี้จะถูกเรียกเมื่อหน้าต่างถูกแสดง
    @Override
    public void componentShown(ComponentEvent e) {
        JOptionPane.showMessageDialog(this, "Window is now visible.", "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    // เมธอดนี้จะถูกเรียกเมื่อหน้าต่างถูกย้าย
    @Override
    public void componentMoved(ComponentEvent e) {
        int x = this.getX();  // รับค่าพิกัด X ของหน้าต่าง
        int y = this.getY();  // รับค่าพิกัด Y ของหน้าต่าง
        JOptionPane.showMessageDialog(this, "Window moved to: X=" + x + " Y=" + y, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    // เมธอดนี้จะถูกเรียกเมื่อขนาดของหน้าต่างถูกปรับเปลี่ยน
    @Override
    public void componentResized(ComponentEvent e) {
        int width = this.getWidth();  // รับความกว้างของหน้าต่าง
        int height = this.getHeight();  // รับความสูงของหน้าต่าง
        JOptionPane.showMessageDialog(this, "Window resized to: " + width + " x " + height, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    // เมธอดนี้ใช้สำหรับสร้างและแสดง GUI
    public static void createAndShowGUI() {
        MobileDeviceCompleteV3 window = new MobileDeviceCompleteV3("Mobile Device Complete V3");
        window.addComponents();  // เพิ่มคอมโพเนนต์ต่างๆ ให้กับหน้าต่าง
        window.addListeners();   // เพิ่ม listeners ให้กับหน้าต่าง
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

