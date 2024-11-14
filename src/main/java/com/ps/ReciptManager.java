package com.ps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReciptManager {

    public void saveOrderReceipt(Order order) {
        File receiptDir = new File("receipts");

        //to make sure the folder exits
        if (!receiptDir.exists() && !receiptDir.mkdirs()) {
            System.err.println("Could not create 'receipts' directory.");
            return;
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "receipt " + timeStamp + ".csv";
        File receiptFile = new File(receiptDir, fileName);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(receiptFile))) {
            bufferedWriter.write("Order receipt");
            bufferedWriter.write("Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            double totalPrice = 0.0;

            for (Product product : order.getProducts()) {
                bufferedWriter.write("Product: " + product.getName());
                bufferedWriter.write("Price: $" + String.format("%.2f", product.getPrice()));

                if (product instanceof Sandwich sandwich) {
                    bufferedWriter.write("Size" + sandwich.getSize() + " inches");
                    bufferedWriter.write("Bread type: " + sandwich.getBreadType());
                    bufferedWriter.write("Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));


                    List<Topping> toppings = sandwich.getToppings();
                    if (toppings != null && !toppings.isEmpty()) {
                        bufferedWriter.write("Toppings:");
                        bufferedWriter.newLine();
                        for (Topping topping : toppings) {
                            bufferedWriter.write(String.format(" - %s (%s, %s) - $%.2f",
                                    topping.getName(),
                                    topping.getType(),
                                    topping.getCategory(),
                                    topping.getPrice()
                            ));
                            bufferedWriter.newLine();
                        }
                    }
                } else if (product instanceof Drink drink) {
                    bufferedWriter.write("Flavor: " + drink.getFlavor());
                    bufferedWriter.write("Size: " + drink.getSize());

                } else if (product instanceof BagOfChip chips) {
                    bufferedWriter.write("Flavor: " + chips.getFlavor());
                }
                totalPrice += product.getPrice();
            }
            bufferedWriter.write("Your total will be: $" + String.format("%.2f", totalPrice));
            System.out.println("Receipt saved" + receiptFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Failed to save receipt" + e.getMessage());

        }
            // with a try-with-resources statement, the resources are automatically closed, so no need to write bufferedWriter.close();
    }
}
