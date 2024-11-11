package com.ps;

public class Drink extends Product{
    private String flavor;
    private String size;

    public Drink(String name, double basePrice, String flavor, String size) {
        super(name, basePrice);
        this.flavor = flavor;
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    @Override
    public double getPrice() {
        double price;

        if (size.equalsIgnoreCase("small")) {
            price = 1.50;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 2.00;
        } else if (size.equalsIgnoreCase("large")) {
            price = 2.50;
        } else {
            price = 0.0;
            System.out.println("Unknown size: ");
        }
        return price;

    }

}
