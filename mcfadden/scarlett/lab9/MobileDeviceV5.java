package mcfadden.scarlett.lab9;
import javax.swing.*;
import java.awt.*;

public class MobileDeviceV5 extends MobileDeviceV4 {     
    // ประกาศตัวแปรสำหรับรายการของผู้ให้บริการและสไลเดอร์สำหรับการให้คะแนน
    protected JList<String> vendorList;     
    protected JSlider RatingSlider;      

    // Constructor สำหรับ MobileDeviceV5 รับ title เป็นพารามิเตอร์และเรียกใช้ constructor ของ MobileDeviceV4
    public MobileDeviceV5(String title){         
        super(title);     
    }      

    @Override     
    public void addComponents(){         
        // เรียกใช้เมธอด addComponents() จาก MobileDeviceV4         
        super.addComponents();          

        // กำหนดรายการของผู้ให้บริการ
        String[] vendors = {"AIS", "True", "DTAC", "Shopee"};         
        vendorList = new JList<>(vendors);         
        // ตั้งค่าให้เลือกได้หลายรายการ
        vendorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);         
        vendorList.setSelectedIndex(0); // เลือกรายการแรกเป็นค่าเริ่มต้น                 

        // เพิ่ม ScrollPane เพื่อรองรับการเลื่อนของรายการผู้ให้บริการ
        JScrollPane vendorScrollPane = new JScrollPane(vendorList);         

        // สร้าง JSlider สำหรับการให้คะแนน อนุญาตให้ให้คะแนนตั้งแต่ 0 ถึง 10 โดยค่าเริ่มต้นคือ 5
        RatingSlider = new JSlider(0, 10, 5);         
        RatingSlider.setMajorTickSpacing(1); // ตั้งค่าระยะห่างของเครื่องหมายหลัก         
        RatingSlider.setPaintTicks(true);    // แสดงเครื่องหมายติ๊ก         
        RatingSlider.setPaintLabels(true);   // แสดงตัวเลขบนเครื่องหมายติ๊ก                  

        // สร้าง JPanel สำหรับรายการผู้ให้บริการ
        JPanel vendorPanel = new JPanel(new GridLayout(1, 1));         
        JLabel vendorLabel = new JLabel("The device is available at:"); // ป้ายข้อความสำหรับรายการผู้ให้บริการ          

        // สร้าง JPanel สำหรับสไลเดอร์ให้คะแนน
        JPanel ratingPanel = new JPanel(new BorderLayout());         
        JLabel ratingLabel = new JLabel("Rate the device (0-10):");    // ป้ายข้อความสำหรับการให้คะแนน          

        // เพิ่มป้ายข้อความและสไลเดอร์ให้คะแนนลงใน Panel
        ratingPanel.add(ratingLabel, BorderLayout.NORTH);         
        ratingPanel.add(RatingSlider, BorderLayout.CENTER);          

        // ตั้งค่าขนาดของ ScrollPane และเพิ่มลงใน Panel ของผู้ให้บริการ
        vendorScrollPane.setPreferredSize(new Dimension(300, 80));         
        vendorPanel.add(vendorLabel);         
        vendorPanel.add(vendorScrollPane);                  

        // รวม Panel ของผู้ให้บริการและสไลเดอร์ให้คะแนนเข้าด้วยกัน
        JPanel VendorandRatingPanel = new JPanel();         
        VendorandRatingPanel.setLayout(new BoxLayout(VendorandRatingPanel, BoxLayout.Y_AXIS));         
        VendorandRatingPanel.add(vendorPanel);         
        VendorandRatingPanel.add(ratingPanel);          

        // จัดวางองค์ประกอบทั้งหมดลงใน Content Pane
        Container contentPane = getContentPane();         
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));          

        // เพิ่ม Panel หลักและ Panel อื่นๆ ลงใน Content Pane
        contentPane.add(mainPanel);         
        contentPane.add(VendorandRatingPanel);         
        contentPane.add(buttonPanel);     
    }      

    // เมธอดสำหรับสร้าง GUI และแสดงหน้าต่าง
    public static void createAndShowGUI() {         
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");         
        mdv5.setFrameFeatures();     
    }     

    // เมธอด main สำหรับรันโปรแกรม
    public static void main(String[] args) {         
        SwingUtilities.invokeLater(new Runnable() {             
            public void run(){                 
                createAndShowGUI();             
            }         
        });     
    } 
}
