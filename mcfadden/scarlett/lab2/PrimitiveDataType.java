package mcfadden.scarlett.lab2;

public class PrimitiveDataType {
    public static void main(String[] args) {
        String studentNumber = "673040636-4";
        String firstName = "Scarlett";

        byte myByte = (byte) firstName.length();
        short myShort = (short) (myByte * 21);
        int myInt = Integer.parseInt(studentNumber.substring(3, 9));
        long myLong = Long.parseLong(studentNumber.replace("-", ""));
        float myFloat = (float) (myByte / 100.0f);
        double myDouble = Double.parseDouble("0." + studentNumber.replace("-", "").substring(studentNumber.length() - 5));
        char myChar = firstName.charAt(0);
        boolean myBoolean = (Character.getNumericValue(studentNumber.charAt(studentNumber.length() - 1)) % 2 != 0);
    
        System.out.println("Student ID: " + studentNumber);
        System.out.println("First Name: " + firstName);
        System.out.println("Byte Value: " + myByte);
        System.out.println("Short Value: " + myShort);
        System.out.println("Int Value: " + myInt);
        System.out.println("Long Value: " + myLong);
        System.out.println("Float Value: " + myFloat);
        System.out.println("Double Value: " + myDouble);
        System.out.println("Char Value: " + myChar);
        System.out.println("Boolean Value: " + myBoolean);
        }
    }
    