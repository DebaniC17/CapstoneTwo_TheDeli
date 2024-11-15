package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    private int size;
    private String breadType;
    private boolean isToasted;
    private List<Topping> toppings;
    private double extraCost = 0.0;

    public Sandwich(String name, double basePrice, int size, String breadType, boolean isToasted) {
        super(name, basePrice);
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
    public List<Topping> getToppings() {
        return toppings;
    }
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public boolean removeTopping(String toppingName) {
        for (int i =0; i < toppings.size(); i++) {
            Topping topping = toppings.get(i);
            if (topping.getName().equalsIgnoreCase(toppingName)) {
                toppings.remove(i);
                System.out.println(toppingName + " has been removed from sandwich.");
                return true;
            }
        }
        System.out.println("Topping " + toppingName + " not found.");
        return false;
    }
    public void addExtraCost(double cost) {
        this.extraCost =+ cost;
    }
    public double getExtraCost() {
        return extraCost;
    }


    //get price override method
    @Override
    public double getPrice() {
        double basePrice =0.0;
        if (size == 4) {
            basePrice = 5.50;
        } else if (size == 8) {
            basePrice = 7.00;
        } else if (size == 12) {
            basePrice = 8.50;
        } else {
            System.out.println("Command not found, please try again...");
        }
        for (Topping topping : toppings) {
            basePrice += topping.getPrice();
        }
        basePrice += extraCost;

        return basePrice;
    }
}
