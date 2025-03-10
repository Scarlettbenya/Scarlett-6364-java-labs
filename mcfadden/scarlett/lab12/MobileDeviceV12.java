package mcfadden.scarlett.lab12;

import java.awt.event.*;
import javax.swing.*;
import mcfadden.scarlett.lab10.*;

public class MobileDeviceV12 extends MobileDeviceV11 {

    public MobileDeviceV12(String title) {
        super(title);
    }

    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        
        deviceNameField.setName("Device Name");
        brandField.setName("Brand");
        priceField.setName("Price");
        Object srcObject = e.getSource();
        if (srcObject == deviceNameField) {
            handleNormalTextField(deviceNameField, brandField);
        } else if (srcObject == brandField) {
            handleNormalTextField(brandField, priceField);
        } else if (srcObject == priceField) {
            handlePosNumTextField(priceField, osComboBox);
        }
    }

    public void handleNormalTextField(JTextField tf, JComponent nextComponent) {
        deviceNameField.setName(" Device Name");
        brandField.setName(" Brand");
        priceField.setName(" Price");
        if (tf.getText() == null || tf.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Please enter some data in" + tf.getName(), "Message", JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, tf.getName() + " is change to " + tf.getText(), "Message", JOptionPane.INFORMATION_MESSAGE);
            nextComponent.setEnabled(true);
        }
    }

    private static void handlePosNumTextField(JTextField tf, JComboBox<String> nextComponent) {
        try {
            int priceFieldInt = Integer.parseInt(tf.getText());
            if (priceFieldInt <= 0){
            JOptionPane.showMessageDialog(null, "Price must be a positive number in " + tf.getName() + ".", "Message", JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);}
            else  {
            JOptionPane.showMessageDialog(null, tf.getName() + "is change to " + tf.getText(), "Message", JOptionPane.INFORMATION_MESSAGE);
            nextComponent.setEnabled(true);}
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number in " + tf.getName() + ".", "Message", JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
        }
    }

    @Override
        public void addListeners() {
            super.addListeners();
            deviceNameField.addActionListener(this);
            brandField.addActionListener(this);
            priceField.addActionListener(this);
    
        }

    public static void createAndShowGUI() {
        MobileDeviceV12 mdv12 = new MobileDeviceV12("Mobile Device V12");
        mdv12.addListeners();
        mdv12.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
}