package com.ps;

public class BagOfChip extends Product{
 private String flavor;

    public BagOfChip(String name, double basePrice, String flavor) {
        super(name, basePrice);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    @Override
    public double getPrice() {
        return getBasePrice();
    }
}
