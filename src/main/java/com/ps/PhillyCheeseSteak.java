package com.ps;

public class PhillyCheeseSteak extends Sandwich{
    public PhillyCheeseSteak() {
        super("PhillyCheese Steak", 8.50, 8, "white", true);
        addTopping(new Topping("steak", "meat", "premium", 8));
        addTopping(new Topping("american cheese", "cheese", "premium", 8));
        addTopping(new Topping("peppers", "vegetable", "regular", 8));
        addTopping(new Topping("mayo", "sauce", "regular", 8));
    }
}
