package mcfadden.scarlett.lab12;

import mcfadden.scarlett.lab7.*;

class Tablet extends MobileDevice {
    private static final String TYPE = "Tablet";
    private String name;
    private String brand;
    
    public Tablet(String name, String brand, double price) {
        super(brand, price);
        this.name = name;
        this.brand = brand;
    }
    
    public Tablet(String name, String brand, double price, String color) {
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
