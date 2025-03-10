package mcfadden.scarlett.lab12;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import mcfadden.scarlett.lab7.*;

public class MobileDeviceV13 extends MobileDeviceV12 implements ActionListener {
    protected JButton addButton, displayButton;
    protected ArrayList<MobileDevice> mobileList;

    public MobileDeviceV13(String title) {
        super(title);
        mobileList = new ArrayList<>();
    }

    @Override
    public void addComponents() {
        super.addComponents();
        addButton = new JButton("Add");
        displayButton = new JButton("Display");
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);
    }
    
    @Override
    public void addListeners() {
        super.addListeners();
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == addButton) {
            handleAddButton();
        } else if (src == displayButton) {
            handleDisplayButton();
        } else {
            super.actionPerformed(e);
        }
    }

    public void handleAddButton() {
        String name = deviceNameField.getText().trim();
        String brand = brandField.getText().trim();
        String priceText = priceField.getText().trim();
        String type = smartphoneButton.isSelected()? "SmartPhone" : "Tablet";
        double price = Double.parseDouble(priceText);

        MobileDevice newDevice;
        if (smartphoneButton.isSelected()) {
            newDevice = new SmartPhone(name, brand, price);
        } else {
            newDevice = new Tablet(name, brand, price);
        }

        mobileList.add(newDevice);
        JOptionPane.showMessageDialog(this,
            type + " " + name + " is added",
            "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public void handleDisplayButton() {
        if (mobileList.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No devices to display",
                "Message", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (MobileDevice device : mobileList) {
            sb.append(device.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(),
            "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void createAndShowGUI() {
        MobileDeviceV13 mdv13 = new MobileDeviceV13("Mobile Device V13");
        mdv13.addListeners();
        mdv13.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MobileDeviceV13::createAndShowGUI);
    }
}

