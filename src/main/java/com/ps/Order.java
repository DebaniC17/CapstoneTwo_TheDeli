package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private List<Topping> toppings;

    public Order() {
        this.products = new ArrayList<>();
        this.toppings = new ArrayList<>();
    }
    public void addProducts(Product product) {
        products.add(product);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    public List<Product> getProducts() {
        return this.products;
    }
    public List<Topping> getToppings() {
        return this.toppings;
    }
    public void saveToFile() {

    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        for (Topping topping: toppings) {
            totalPrice += topping.getPrice();
        }
       return totalPrice;
    }

    public void add(BagOfChip chips) {
    addProducts(chips);
    }
}
