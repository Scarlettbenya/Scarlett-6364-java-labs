package mcfadden.scarlett.lab8;
import javax.swing.*;

public class MobileDeviceV3 extends MobileDeviceV2 {
    public MobileDeviceV3(String title) {
        super(title); // เรียกคอนสตรัคเตอร์
    }

    @Override // Override เมธอด addComponents
    protected void addComponents() {
        super.addComponents(); // เรียกใช้งานเมธอด addComponents 
        addMenus();
    }

    protected void addMenus() { // เมธอด addMenus ใช้สำหรับสร้างและเพิ่มเมนูต่างๆ ลงในหน้าต่าง GUI
        JMenuBar menuBar = new JMenuBar(); // สร้างแถบเมนูหลัก (JMenuBar)
        
        JMenu fileMenu = new JMenu("File"); // สร้างเมนู "File"
        JMenuItem newMI = new JMenuItem("New"); // สร้างเมนูไอเท็มสำหรับเมนู "File"
        JMenuItem openMI = new JMenuItem("Open");
        JMenuItem saveMI = new JMenuItem("save");
        JMenuItem exitMI = new JMenuItem("Exit");
        exitMI.addActionListener(e -> System.exit(0)); // กำหนด ActionListener ให้กับเมนูไอเท็ม "Exit" เมื่อคลิกแล้วให้ปิดโปรแกรม
        fileMenu.add(exitMI); // เพิ่มเมนูไอเท็มลงในเมนู "File"
        fileMenu.add(newMI);
        fileMenu.add(openMI);
        fileMenu.add(saveMI);

        JMenu configMenu = new JMenu("Config"); // สร้างเมนู "Config" สำหรับตั้งค่าการปรับแต่งหน้าต่าง
        JMenu sizeMenu = new JMenu("Size"); // สร้างเมนูไอเท็มสำหรับเลือกขนาด
        JMenuItem smallMI = new JMenuItem("Small");
        JMenuItem mediumMI = new JMenuItem("Medium");
        JMenuItem largeMI = new JMenuItem("Large");
        JMenuItem extralargeMI = new JMenuItem("Extra Large");
        sizeMenu.add(smallMI); // เพิ่มเมนูไอเท็มลงในเมนู "Size"
        sizeMenu.add(mediumMI);
        sizeMenu.add(largeMI);
        sizeMenu.add(extralargeMI);

        JMenu colorMenu = new JMenu("Color"); // สร้างเมนูย่อย "Color" สำหรับเลือกสี
        JMenuItem blackMI = new JMenuItem("Black");
        JMenuItem redMI = new JMenuItem("Red");
        JMenuItem greenMI = new JMenuItem("Green");
        JMenuItem blueMI = new JMenuItem("Blue");
        colorMenu.add(blackMI); // เพิ่มเมนูไอเท็มลงในเมนู "Color"
        colorMenu.add(redMI);
        colorMenu.add(greenMI);
        colorMenu.add(blueMI);

        JMenu fontMenu = new JMenu("Font"); // สร้างเมนูย่อย "Font" สำหรับเลือกแบบอักษร
        JMenuItem font1MI = new JMenuItem("Font 1"); // สร้างเมนูไอเท็มสำหรับเลือกแบบอักษร
        JMenuItem font2MI = new JMenuItem("Font 2");
        JMenuItem font3MI = new JMenuItem("Font 3");
        fontMenu.add(font1MI); // เพิ่มเมนูไอเท็มลงในเมนู "Font"
        fontMenu.add(font2MI);
        fontMenu.add(font3MI);

        configMenu.add(sizeMenu); // เพิ่มเมนูย่อย "Size", "Color" และ "Font" ลงในเมนู "Config"
        configMenu.add(colorMenu);
        configMenu.add(fontMenu);

        menuBar.add(fileMenu); // เพิ่มเมนู "File" และ "Config" ลงในแถบเมนูหลัก
        menuBar.add(configMenu);

        setJMenuBar(menuBar);  // กำหนดให้แถบเมนูที่สร้างขึ้นนี้เป็นแถบเมนูของหน้าต่าง (JFrame)
    }

    public static void createAndShowGUI() { // เมธอด createAndShowGUI สำหรับสร้างและแสดงหน้าต่าง MobileDeviceV1
        MobileDeviceV3 msw3 = new MobileDeviceV3("Mobile Device V3"); // สร้างอ็อบเจ็กต์ MobileDeviceV1 และกำหนดชื่อหน้าต่าง
        msw3.setFrameFeatures(); // เรียกเมธอด setFrameFeatures เพื่อยืนยันการตั้งค่าของหน้าต่าง
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // เรียกเมธอดสร้างและแสดงหน้าต่าง MobileDeviceV3
            }
        });
    }
}
