package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    private int size;
    private String breadType;
    private boolean isToasted;
    private List<Topping> toppings;

    public Sandwich(int size, String breadType, boolean isToasted) {
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
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }
    //get price override method
}
