package mcfadden.scarlett.lab12;
import javax.swing.*;

import mcfadden.scarlett.lab7.MobileDevice;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class MobileDeviceV15 extends MobileDeviceV14 implements ActionListener {

    protected JMenu formatMenu;
    protected JCheckBoxMenuItem textFormat, binaryFormat;
    protected ButtonGroup formatGroup;

    public MobileDeviceV15(String title) {
        super(title);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        addMenus();
    }
    
    @Override
    public void addMenus() {
        super.addMenus();
        formatMenu = new JMenu("Format");
        textFormat = new JCheckBoxMenuItem("Text", true);
        binaryFormat = new JCheckBoxMenuItem("Binary", false);
        
        formatGroup = new ButtonGroup();
        formatGroup.add(textFormat);
        formatGroup.add(binaryFormat);
        
        configMenu.add(formatMenu);
        formatMenu.add(textFormat);
        formatMenu.add(binaryFormat);
    }
    
    @Override
    public void addListeners() {
        super.addListeners();
        textFormat.addActionListener(this);
        binaryFormat.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == openMI) {
            handleMenuOpen();
        } else if (src == saveMI) {
            handleMenuSave();
        } else {
            super.actionPerformed(e);
        }
    }
    
    @Override
    public void handleMenuSave() {
        if (textFormat.isSelected()) {
            super.handleMenuSave();
            return;
        }

        JFileChooser fc = new JFileChooser();
        int option = fc.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(mobileList);
                JOptionPane.showMessageDialog(this,
                        "Binary file saved successfully at " + file.getAbsolutePath(),
                        "Save", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error saving binary file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @Override
    public void handleMenuOpen() {
        if (textFormat.isSelected()) {
            super.handleMenuOpen();
            return;
        }

        JFileChooser fc = new JFileChooser();
        int option = fc.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            JOptionPane.showMessageDialog(this,
                    "Opening binary file from " + file.getAbsolutePath(),
                    "Open", JOptionPane.INFORMATION_MESSAGE);
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                if (obj instanceof ArrayList) {
                    @SuppressWarnings("unchecked")
                    ArrayList<MobileDevice> list = (ArrayList<MobileDevice>) obj;
                    mobileList = list;
                    handleDisplayButton();
                }
            } catch (IOException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error opening binary file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    

    
    public static void createAndShowGUI() {
        MobileDeviceV14 msw15 = new MobileDeviceV14("Mobile Device V14");
        msw15.addListeners();
        msw15.setFrameFeatures();
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

