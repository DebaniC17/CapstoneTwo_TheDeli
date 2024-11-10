package com.ps;

import java.util.Scanner;

public class UserInterface {
    static Scanner commandScanner = new Scanner(System.in);

    public static void main(String[] args) {
        int mainCommand;
        do {
            System.out.println("Welcome to DELIcious sandwiches!");
            System.out.println("Please select an option: ");
            System.out.println("1) To place an order");
            System.out.println("0) Exit application");
            System.out.print("Command: ");
            mainCommand = commandScanner.nextInt();

            switch (mainCommand) {
                case 1:
                    placeOrder();
                    break;

                case 0:
                    System.out.println("Exiting...");

                default:
                    System.out.println("Command not found, please try again...");

            }

        } while (mainCommand != 0);

    }

    private static void placeOrder() {
        System.out.println("What's the name for the order?");
        String name = commandScanner.nextLine();

        System.out.println("What would you like to do with your order?");
        System.out.println("1) Add a sandwich");
        System.out.println("2) Add a bag of chips");
        System.out.println("3) Add a drink");
        System.out.println("4) See your order details");
        System.out.println("5) Checkout");
        System.out.println("0) Start over");
        System.out.print("Selection: ");
        int orderCommand = commandScanner.nextInt();

        switch (orderCommand) {
            case 1:
                handleAddSandwich();
                break;

            case 2:
                handleAddBagOfChips();
                break;

            case 3:
                handleAddDrink();
                break;

            case 4:
                displayOrder();
                break;
                
            case 5:
                handleCheckout();
                break;
                
            case 0:
                System.out.println("Starting over...");
                
            default:
                System.out.println("Command not found, please try again...");

        } while (orderCommand != 0 );
    }

    private static void handleCheckout() {
    }

    private static void displayOrder() {
    }

    private static void handleAddDrink() {
    }

    private static void handleAddBagOfChips() {
    }

    private static void handleAddSandwich() {
    }


}
