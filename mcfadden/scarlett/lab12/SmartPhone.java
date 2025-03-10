package mcfadden.scarlett.lab12;

import mcfadden.scarlett.lab7.*;

class SmartPhone extends MobileDevice {
    private static final String TYPE = "SmartPhone";
    private String name;
    private String brand;
    
    public SmartPhone(String name, String brand, double price) {
        super(brand, price);
        this.name = name;
        this.brand = brand;
    }
    
    public SmartPhone(String name, String brand, double price, String color) {
        super(color, price);
        this.name = name;
        this.brand = brand;
        this.color = color;
    }
    
    @Override
    public String toString() {
        return TYPE + ": " + name + " (" + brand + ") " + price + " Baht";
    }

    @Override
    public boolean isWatch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isWatch'");
    }
}
