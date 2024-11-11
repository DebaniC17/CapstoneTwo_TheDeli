package com.ps;

public class Topping {
    private String name;
    private String type;
    private String category;
    private int size;

    public Topping(String name, String type, String category, int size) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public double getPrice() {
        if (category.equalsIgnoreCase("premium")) {
            //if else statements throughout?? mmmmh switch statements?? both??
            // premium
            // regular = 0.0
            // extra
        }
    }
}
