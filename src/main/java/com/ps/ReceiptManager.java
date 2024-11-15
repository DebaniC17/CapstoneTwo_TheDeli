package com.ps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReceiptManager {

    public static void saveOrderReceipt(Order order) {
        //making of the folder
        File receiptDir = new File("receipts");

        //to make sure the folder exits
        if (!receiptDir.exists() && !receiptDir.mkdirs()) {
            System.err.println("Could not create 'receipts' directory.");
            return;
        }

        //making of the file/order
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "receipt " + timeStamp + ".csv";
        File receiptFile = new File(receiptDir, fileName);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(receiptFile))) {
            bufferedWriter.write("Order receipt");
            bufferedWriter.newLine();
            bufferedWriter.write("Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            bufferedWriter.newLine();
            bufferedWriter.write("=======================================");
            bufferedWriter.newLine();
            double totalPrice = 0.0;

            for (Product product : order.getProducts()) {
                bufferedWriter.write("Product: " + product.getName());
                bufferedWriter.newLine();
                bufferedWriter.write("Price: $" + String.format("%.2f", product.getPrice()));
                bufferedWriter.newLine();

                if (product instanceof Sandwich sandwich) {
                    bufferedWriter.write("Size: " + sandwich.getSize() + " inches");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Bread type: " + sandwich.getBreadType());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
                    bufferedWriter.newLine();

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
                    if (sandwich.getExtraCost() > 0) {
                        bufferedWriter.write("Extra customization cost: $" + String.format("%.2f", sandwich.getExtraCost()));
                        bufferedWriter.newLine();
                    }

                } else if (product instanceof Drink drink) {
                    bufferedWriter.write("Flavor: " + drink.getFlavor());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Size: " + drink.getSize());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Price: $" + String.format("%.2f", drink.getPrice()));
                    bufferedWriter.newLine();

                } else if (product instanceof BagOfChip chips) {
                    bufferedWriter.write("Flavor: " + chips.getFlavor());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Price: $" + String.format("%.2f", chips.getPrice()));
                    bufferedWriter.newLine();
                }

                bufferedWriter.write("---------------------------------------");
                bufferedWriter.newLine();
                totalPrice += product.getPrice();
            }
            bufferedWriter.write("=======================================");
            bufferedWriter.newLine();
            bufferedWriter.write("Your total will be: $" + String.format("%.2f", totalPrice));
            bufferedWriter.newLine();
            bufferedWriter.write("=======================================");
            System.out.println("Receipt saved" + receiptFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Failed to save receipt" + e.getMessage());

        }
        // with a try-with-resources statement, the resources are automatically closed, so no need to write bufferedWriter.close();
    }
}
