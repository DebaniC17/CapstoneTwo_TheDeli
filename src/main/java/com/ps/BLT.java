package com.ps;

public class BLT extends Sandwich {
    public BLT() {
        super("BLT", 7.00, 8, "white", true);
        addTopping(new Topping("bacon", "meat", "premium", 8));
        addTopping(new Topping("cheddar", "cheese", "premium", 8));
        addTopping(new Topping("lettuce", "vegetable", "regular", 8));
        addTopping(new Topping("tomato", "vegetable", "regular", 8));
        addTopping(new Topping("ranch", "sauce", "regular", 8));
    }
}
