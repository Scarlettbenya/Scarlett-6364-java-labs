package mcfadden.scarlett.lab10;

import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class MobileDeviceV11 extends MobileDeviceV10 {
    // Constructor สำหรับคลาส MobileDeviceV11
    public MobileDeviceV11(String title) {
        super(title);
    }

    // เมธอดนี้ใช้สำหรับเพิ่ม Mnemonics และ Accelerators ให้กับเมนู
    public void addKeys() {
        // เพิ่ม Mnemonic และ Accelerator สำหรับ New
        newMI.setMnemonic(KeyEvent.VK_N);
        newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        // เพิ่ม Mnemonic และ Accelerator สำหรับ Open
        openMI.setMnemonic(KeyEvent.VK_O);
        openMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        // เพิ่ม Mnemonic และ Accelerator สำหรับ Save
        saveMI.setMnemonic(KeyEvent.VK_S);
        saveMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        // เพิ่ม Mnemonic และ Accelerator สำหรับ Exit
        exitMI.setMnemonic(KeyEvent.VK_X);
        exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

    // เมธอดนี้ใช้เพิ่ม listeners ให้กับปุ่มต่างๆ
    @Override
    public void addListeners() {
        super.addListeners();
        // เพิ่ม ActionListener ให้กับปุ่ม smartphoneButton
        smartphoneButton.addActionListener(this);
        // เพิ่ม ActionListener ให้กับปุ่ม tabletButton
        tabletButton.addActionListener(this);
    }

    // เมธอดนี้ใช้สำหรับจัดการการคลิกปุ่ม
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        // ถ้าผู้ใช้คลิกที่ปุ่ม smartphoneButton
        if (e.getSource() == smartphoneButton) {
            JOptionPane.showMessageDialog(this, "Smartphone is selected" , "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        // ถ้าผู้ใช้คลิกที่ปุ่ม tabletButton
        else if (e.getSource() == tabletButton) {
            JOptionPane.showMessageDialog(this, "Tablet is selected" , "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // เมธอดนี้ใช้สำหรับสร้างและแสดง GUI
    public static void createAndShowGUI() {
        MobileDeviceV11 msw = new MobileDeviceV11("Mobile Device V11");
        msw.setFrameFeatures();  // ตั้งค่าคุณสมบัติของเฟรม
        msw.addListeners();  // เพิ่ม listeners
        msw.addKeys();  // เพิ่ม keys สำหรับเมนู
    }

    // เมธอด main ที่จะเรียกใช้การแสดง GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();  // เรียกใช้เมธอดสร้างและแสดง GUI
            }
        });
    }
}
