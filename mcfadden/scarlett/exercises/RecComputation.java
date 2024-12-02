package mcfadden.scarlett.exercises;

public class RecComputation {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java RecCompputation <width><height>");
            System.exit(1);
        }
        float width = Float.parseFloat(args[0]);
        float height = Float.parseFloat(args[1]);
        float area = width * height;
        float circumference = 2 * (width + height);
        System.out.println("For width = " + width + " and height = " + height);
        System.out.println("Area = " + area);
        System.out.println("Circumference = " + circumference);

    }

}
