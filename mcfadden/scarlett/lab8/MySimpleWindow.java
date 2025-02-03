package mcfadden.scarlett.lab8;
import javax.swing.*;

public class MySimpleWindow extends JFrame{
    protected JButton resetButton, submitButton; // ปุ่มสำหรับ "Cancle" และ "OK"
    protected JPanel mainPanel, buttonPanel;  // แผงหลักและแผงสำหรับวางปุ่ม

    public MySimpleWindow (String title){
        super(title); // เรียกคอนสตรัคเตอร์ของ JFrame
    }

    protected void addComponents(){ // เมธอดสำหรับเพิ่มคอมโพเนนต์ต่างๆ ลงในหน้าต่าง
        resetButton = new JButton("Cancel"); // สร้างปุ่ม resetButton พร้อมกับข้อความ "Cancel"
        submitButton = new JButton("OK"); // สร้างปุ่ม submitButton พร้อมกับข้อความ "OK"
        mainPanel = new JPanel(); // สร้างแผงหลักสำหรับบรรจุคอมโพเนนต์
        buttonPanel = new JPanel(); // สร้างแผงสำหรับจัดวางปุ่มต่างๆ
        buttonPanel.add(resetButton); // เพิ่มปุ่ม resetButton
        buttonPanel.add(submitButton); // เพิ่มปุ่ม submitButton
        mainPanel.add(buttonPanel); // เพิ่มแผง buttonPanel ลงในแผง mainPanel
        add(mainPanel); // เพิ่มแผง mainPanel ลงในหน้าต่าง 
    }

    protected void setFrameFeatures(){
        this.setVisible(true); // กำหนดให้หน้าต่างแสดงผล
        this.setLocationRelativeTo(null); // กำหนดให้หน้าต่างอยู่ตรงกลางของหน้าจอ
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // เมื่อปิดหน้าต่าง โปรแกรมจะหยุดทำงาน
        this.pack(); // ปรับขนาดหน้าต่างให้พอดีกับคอมโพเนนต์ภายใน
    }

    public static void createAndShowGUI() { // เมธอดสำหรับสร้างและแสดง GUI
        MySimpleWindow msw = new MySimpleWindow("My Simple Window"); // สร้างอ็อบเจ็กต์ MySimpleWindow พร้อมชื่อเรื่อง "My Simple Window"
        msw.addComponents(); // เรียกเมธอดเพื่อเพิ่มคอมโพเนนต์ลงในหน้าต่าง
        msw.setFrameFeatures(); // ตั้งค่าคุณสมบัติของหน้าต่างให้พร้อมใช้งาน
    } 
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // เรียกเมธอดสำหรับสร้างและแสดงหน้าต่าง GUI
            }
        });
    }
}
