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

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        //if (category.equalsIgnoreCase("premium")) {
        //if else statements throughout?? mmmmh switch statements?? both??
        // premium
        // regular = 0.0
        // extra
        if (type.equalsIgnoreCase("meat")) {
            if (size == 4) {
                return 1.00;
            } else if (size == 8) {
                return 2.00;
            } else if (size == 12) {
                return 3.00;
            }
        } else if (type.equalsIgnoreCase("cheese")) {
            if (size == 4) {
                return 0.75;
            } else if (size == 8) {
                return 1.50;
            } else if (size == 12) {
                return 2.25;
            }
        } else if (category.equalsIgnoreCase("extra meat")) {
            if (size == 4) {
                return 0.50;
            } else if (size == 8) {
                return 1.00;
            } else if (size == 12) {
                return 1.50;
            }

        } else if (category.equalsIgnoreCase("extra cheese")) {
            if (size == 4) {
                return 0.30;
            } else if (size == 8) {
                return 0.60;
            } else if (size == 12) {
                return 0.90;
            }
        }
        //regular toppings
        return 0.0;

    }
}

