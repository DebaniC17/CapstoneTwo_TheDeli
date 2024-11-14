package com.ps;

public class PhillyCheeseSteak extends Sandwich{
    public PhillyCheeseSteak() {
        super("PhillyCheese Steak", 8.50, 8, "white", true);
        addTopping(new Topping("steak", "meat", "premium", 8,2.00));
        addTopping(new Topping("american cheese", "cheese", "premium", 8,1.50));
        addTopping(new Topping("peppers", "vegetable", "regular", 8,0.0));
        addTopping(new Topping("mayo", "sauce", "regular", 8,0.0));
    }
}
