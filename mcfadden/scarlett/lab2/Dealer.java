package mcfadden.scarlett.lab2;
public class Dealer { //สร้างคลาสที่ชื่อว่า Dealer โดยกำหนดการเข้าถึงของคลาสนี้เป็นแบบ Public
    public static void main(String[] args) { //
        if (args.length != 3){
            System.err.println("Error: Invalid number of arguments. Please provide exactly three arguments.");
            return;
        }
            String nameofdealer = args[0];
            String numofclients = args[1];
            String gender = args[2];
            
            System.out.println("Dealer's Name: " + nameofdealer);
            System.out.println("Number of clients: " + numofclients);
            System.out.println("Gender: " + gender);
        

        
    }

    
}
