package mcfadden.scarlett.lab9;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ReadImage extends JPanel {
   // ตัวแปรสำหรับเก็บภาพต้นฉบับ
   private BufferedImage originalImage; 

   // ตัวแปรสำหรับเก็บภาพที่ถูกปรับขนาด
   private Image scaledImage; 

   // ตัวแปรสำหรับเก็บความกว้างของภาพที่ปรับขนาดแล้ว
   private int width; 

   // ตัวแปรสำหรับเก็บความสูงของภาพที่ปรับขนาดแล้ว
   private int height; 

   // Constructor สำหรับโหลดภาพในขนาดต้นฉบับ
   public ReadImage(String filepath) {
       loadImage(filepath, 1.0f); // ใช้ค่า scale เริ่มต้นเป็น 1.0 (ขนาดต้นฉบับ)
   }

   // Constructor สำหรับโหลดภาพพร้อมกำหนดขนาดด้วย scaling factor
   public ReadImage(String filepath, float scalingFactor) {
       // ตรวจสอบว่าค่า scaling factor ต้องมากกว่า 0
       if (scalingFactor <= 0) {
           throw new IllegalArgumentException("Scaling factor must be greater than 0.");
       }
       loadImage(filepath, scalingFactor);
   }

   // เมธอดสำหรับโหลดภาพและปรับขนาด
   private void loadImage(String filepath, float scale) {
       try {
           // อ่านไฟล์ภาพจาก filepath
           originalImage = ImageIO.read(new File(filepath)); 
           if (originalImage != null) {
               // คำนวณขนาดใหม่ตาม scaling factor
               width = (int) (originalImage.getWidth() * scale);
               height = (int) (originalImage.getHeight() * scale);

               // ปรับขนาดภาพโดยใช้การปรับขนาดแบบ Smooth
               scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
           } else {
               System.err.println("Error: Unable to load image from " + filepath); // แจ้งเตือนหากโหลดภาพไม่ได้
           }
       } catch (IOException e) {
           // แสดงข้อความแจ้งข้อผิดพลาดหากมีปัญหาในการอ่านไฟล์
           System.err.println("IOException occurred while reading the image: " + e.getMessage());
       }
   }

   @Override
   protected void paintComponent(Graphics g) {
       super.paintComponent(g);

       // ตรวจสอบว่าภาพถูกโหลดสำเร็จหรือไม่
       if (scaledImage != null) {
           // วาดภาพที่ปรับขนาดแล้วบนหน้าจอ
           g.drawImage(scaledImage, 0, 0, this); 
       } else {
           // หากภาพโหลดไม่ได้ แสดงข้อความ "Image not loaded"
           g.setColor(Color.RED);
           g.drawString("Image not loaded", 10, 20);
       }
   }

   // เมธอดสำหรับคืนค่าความกว้างของภาพที่ปรับขนาด
   public int getImageWidth() {
       return width;
   }

   // เมธอดสำหรับคืนค่าความสูงของภาพที่ปรับขนาด
   public int getImageHeight() {
       return height;
   }
}
