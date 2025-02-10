package mcfadden.scarlett.lab9;
import java.awt.*;
import javax.swing.*;
import mcfadden.scarlett.lab8.*;

public class MobileDeviceV4 extends MobileDeviceV3 {
    // Constructor สำหรับ MobileDeviceV4 รับ title เป็นพารามิเตอร์และเรียกใช้ constructor ของ MobileDeviceV3
    public MobileDeviceV4(String title) {
        super(title);
    }

    @Override
    protected void addComponents() {
        // เรียกใช้เมธอด addComponents() จาก MobileDeviceV3
        super.addComponents();
        addMenus(); // เรียกใช้เมธอดสำหรับเพิ่มเมนู
    }

    @Override
    protected void addMenus() {
        // เรียกใช้เมธอด addMenus() จาก MobileDeviceV3
        super.addMenus();
        
        // สร้าง JMenuBar สำหรับเก็บเมนูทั้งหมด
        JMenuBar menuBar = new JMenuBar();

        // สร้างเมนู "File" และเพิ่ม JMenuItem
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMI = new JMenuItem("New");
        JMenuItem openMI = new JMenuItem("Open");
        JMenuItem saveMI = new JMenuItem("save");
        JMenuItem exitMI = new JMenuItem("Exit");

        // กำหนดไอคอนสำหรับ JMenuItem ในเมนู "File"
        newMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("mcfadden/scarlett/lab9/images/new_icon.png")));
        openMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("mcfadden/scarlett/lab9/images/open_icon.png")));
        saveMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("mcfadden/scarlett/lab9/images/save_icon.png")));
        exitMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("mcfadden/scarlett/lab9/images/exit_icon.png")));

        // เพิ่ม ActionListener ให้ exitMI เพื่อปิดโปรแกรมเมื่อคลิก
        exitMI.addActionListener(e -> System.exit(0));

        // เพิ่ม JMenuItem ลงในเมนู "File"
        fileMenu.add(newMI);
        fileMenu.add(openMI);
        fileMenu.add(saveMI);
        fileMenu.add(exitMI);

        // สร้างเมนู "Config" สำหรับปรับแต่งการตั้งค่าต่าง ๆ
        JMenu configMenu = new JMenu("Config");

        // สร้างเมนูย่อย "Size" สำหรับกำหนดขนาด
        JMenu sizeMenu = new JMenu("Size");
        JMenuItem smallMI = new JMenuItem("Small");
        JMenuItem mediumMI = new JMenuItem("Medium");
        JMenuItem largeMI = new JMenuItem("Large");
        JMenuItem extralargeMI = new JMenuItem("Extra Large");

        // กำหนดขนาดตัวอักษรสำหรับเมนู "Size"
        smallMI.setFont(new Font("Arial", Font.PLAIN, 10));
        mediumMI.setFont(new Font("Arial", Font.PLAIN, 14));
        largeMI.setFont(new Font("Arial", Font.PLAIN, 18));
        extralargeMI.setFont(new Font("Arial", Font.PLAIN, 22));

        // เพิ่ม JMenuItem ลงในเมนูย่อย "Size"
        sizeMenu.add(smallMI);
        sizeMenu.add(mediumMI);
        sizeMenu.add(largeMI);
        sizeMenu.add(extralargeMI);

        // สร้างเมนูย่อย "Color" สำหรับกำหนดสี
        JMenu colorMenu = new JMenu("Color");
        JMenuItem blackMI = new JMenuItem("Black");
        JMenuItem redMI = new JMenuItem("Red");
        JMenuItem greenMI = new JMenuItem("Green");
        JMenuItem blueMI = new JMenuItem("Blue");

        // กำหนดสีตัวอักษรสำหรับ JMenuItem ในเมนู "Color"
        blackMI.setForeground(Color.BLACK);
        redMI.setForeground(Color.RED);
        greenMI.setForeground(Color.GREEN);
        blueMI.setForeground(Color.BLUE);

        // เพิ่ม JMenuItem ลงในเมนูย่อย "Color"
        colorMenu.add(blackMI);
        colorMenu.add(redMI);
        colorMenu.add(greenMI);
        colorMenu.add(blueMI);

        // สร้างเมนูย่อย "Font" สำหรับกำหนดแบบอักษร
        JMenu fontMenu = new JMenu("Font");
        JMenuItem font1MI = new JMenuItem("Font 1");
        JMenuItem font2MI = new JMenuItem("Font 2");
        JMenuItem font3MI = new JMenuItem("Font 3");

        // กำหนดฟอนต์สำหรับ JMenuItem ในเมนู "Font"
        font1MI.setFont(new Font("Serif", Font.PLAIN, 14));
        font2MI.setFont(new Font("SansSerif", Font.PLAIN, 14));
        font3MI.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // เพิ่ม JMenuItem ลงในเมนูย่อย "Font"
        fontMenu.add(font1MI);
        fontMenu.add(font2MI);
        fontMenu.add(font3MI);

        // เพิ่มเมนูย่อย "Size", "Color" และ "Font" ลงในเมนู "Config"
        configMenu.add(sizeMenu);
        configMenu.add(colorMenu);
        configMenu.add(fontMenu);

        // เพิ่มเมนู "File" และ "Config" ลงใน JMenuBar
        menuBar.add(fileMenu);
        menuBar.add(configMenu);

        // ตั้ง JMenuBar ให้กับ JFrame
        setJMenuBar(menuBar);
    }

    // เมธอดสำหรับสร้าง GUI และแสดงหน้าต่าง
    public static void createAndShowGUI() {
        MobileDeviceV4 msw4 = new MobileDeviceV4("MobileDeviceV4");
        msw4.setFrameFeatures(); // เรียกใช้เมธอดสำหรับตั้งค่าคุณสมบัติของหน้าต่าง
    }

    // เมธอด main สำหรับรันโปรแกรม
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // เรียกใช้เมธอดสำหรับสร้าง GUI
            }
        });
    }
}

