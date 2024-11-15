package com.ps;

public class Topping {
    private String name;
    private String type;
    private String category;
    private int size;
    private double price;

    public Topping(String name, String type, String category, int size, double price) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return this.price;
    }
}



