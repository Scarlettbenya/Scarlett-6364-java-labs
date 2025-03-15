//สการ์เล็ต เบญญา แมคฟาด์เด้น
//รหัสนักศึกษา: 673040636-4
//last update: 12/03/2025

package mcfadden.scarlett.lab12;
import javax.swing.*;
import mcfadden.scarlett.lab7.MobileDevice;
import java.awt.event.*;
import java.io.*;

public class MobileDeviceV14 extends MobileDeviceV13 implements ActionListener {

    public MobileDeviceV14(String title) {
        super(title);
    }

    // เมธอดสำหรับเพิ่มเมนูเพิ่มเติม (ถ้าจำเป็น)
    @Override
    protected void addMenus() {
        super.addMenus();
    }
    
    // เมธอดสำหรับเพิ่มตัวดักจับเหตุการณ์ให้กับคอมโพเนนต์ต่าง ๆ
    @Override
    public void addListeners() {
        super.addListeners();
    }
    
    // เมธอดที่ใช้จัดการกับเหตุการณ์เมื่อผู้ใช้กดเมนูหรือปุ่มต่าง ๆ
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == openMI) { // ถ้าผู้ใช้กดเมนู "Open"
            handleMenuOpen();
        } else if (src == saveMI) { // ถ้าผู้ใช้กดเมนู "Save"
            handleMenuSave();
        } else {
            super.actionPerformed(e); // ส่งต่อให้คลาสแม่จัดการเหตุการณ์อื่น ๆ
        }
    }
    
    // เมธอดสำหรับบันทึกข้อมูลอุปกรณ์ลงไฟล์
    public void handleMenuSave() {
        JFileChooser fileChooser = new JFileChooser(); // สร้าง File Chooser ให้ผู้ใช้เลือกไฟล์สำหรับบันทึก
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) { // ตรวจสอบว่าผู้ใช้กด "บันทึก"
            File file = fileChooser.getSelectedFile(); // รับไฟล์ที่ผู้ใช้เลือก
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) { // เปิดไฟล์เพื่อเขียนข้อมูล
                for (MobileDevice device : mobileList) {
                    writer.println(device.toString()); // เขียนข้อมูลอุปกรณ์ลงในไฟล์
                }
                JOptionPane.showMessageDialog(this, "File saved successfully.", "Save", JOptionPane.INFORMATION_MESSAGE); // แสดงข้อความว่าบันทึกสำเร็จ
            } catch (IOException ex) { // ดักจับข้อผิดพลาดกรณีเกิดปัญหาในการบันทึกไฟล์
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // เมธอดสำหรับเปิดไฟล์และอ่านข้อมูลอุปกรณ์
    public void handleMenuOpen() {
        JFileChooser fileChooser = new JFileChooser(); // สร้าง File Chooser ให้ผู้ใช้เลือกไฟล์ที่ต้องการเปิด
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { // ตรวจสอบว่าผู้ใช้กด "เปิดไฟล์"
            File file = fileChooser.getSelectedFile(); // รับไฟล์ที่ผู้ใช้เลือก
    
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) { // เปิดไฟล์เพื่ออ่านข้อมูล
                StringBuilder content = new StringBuilder(); // ใช้ StringBuilder เพื่อเก็บข้อมูลที่อ่านมา
                String line;
                while ((line = reader.readLine()) != null) { // อ่านไฟล์ทีละบรรทัด
                    content.append(line).append("\n"); // เพิ่มข้อมูลแต่ละบรรทัดเข้าไปใน StringBuilder
                }
    
                // แสดงข้อความพร้อมข้อมูลที่อ่านจากไฟล์
                JOptionPane.showMessageDialog(this, "Read devices from the file " + file.getAbsolutePath() + " are as follows:\n" + content.toString());
            } 
            catch (ArrayIndexOutOfBoundsException ex) { // ดักจับข้อผิดพลาดถ้าไม่มีไฟล์ในพารามิเตอร์
                System.err.println("Provide filename in program argument");
            } 
            catch (IOException ex) { // ดักจับข้อผิดพลาดกรณีอ่านไฟล์ไม่ได้
                System.err.println("Error in Reading file");
                ex.printStackTrace(System.err);
            }
        }
    }
    
    // เมธอดสำหรับสร้างและแสดง GUI
    public static void createAndShowGUI() {
        MobileDeviceV14 msw14 = new MobileDeviceV14("Mobile Device V14");
        msw14.addListeners();
        msw14.setFrameFeatures();
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
