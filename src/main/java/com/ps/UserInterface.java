package com.ps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    static Scanner commandScanner = new Scanner(System.in);
    static Scanner inputScanner = new Scanner(System.in);

    private static Order order = new Order();

    public static void display () {
        int mainCommand;
        do {
            System.out.println("Welcome to DELIcious sandwiches!");
            System.out.println("Please select an option: ");
            System.out.println("1) To place an order");
            System.out.println("0) Exit application");
            System.out.print("Command: ");
           // mainCommand = commandScanner.nextInt();

            try {
                mainCommand = commandScanner.nextInt();
            } catch (InputMismatchException ime) {
                mainCommand = 0;
            }

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
        String name = inputScanner.nextLine();

        System.out.println("What would you like to do with your order?");
        System.out.println("1) Add a sandwich");
        System.out.println("2) Add a bag of chips");
        System.out.println("3) Add a drink");
        System.out.println("4) See your order details");
        System.out.println("5) Checkout");
        System.out.println("0) Start over");
        System.out.print("Selection: ");
        int orderCommand = inputScanner.nextInt();

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

    private static void handleAddSandwich() {
        //another nested menu for built your own sandwich
        System.out.println("Select a type of sandwich: ");
        System.out.println("1) Built your own sandwich ");
        System.out.println("2) BLT");
        System.out.println("3) Philly cheese steak");
        System.out.print("Selection: ");
        int sandwichChoice = inputScanner.nextInt();



    }
    private static void handleAddBagOfChips() {
        int chipCommand = 0;
        do {
            System.out.println("Choose a flavor of chips: ");
            System.out.println("1) Classic");
            System.out.println("2) Flaming hot");
            System.out.println("3) Jalapeno");
            System.out.println("4) BBQ");
            System.out.println("0) Return to order menu");
            System.out.print("Selection: ");
            int chipChoice = inputScanner.nextInt();

            try {
                chipCommand = commandScanner.nextInt();
            } catch (InputMismatchException ime) {
                chipCommand = 0;
            }

            if (chipChoice == 0) {
                System.out.println("Returning to order menu...");
                return;
            }

            String flavor = "";
            switch (chipChoice) {
                case 1:
                    flavor.equalsIgnoreCase("classic");
                    break;

                case 2:
                    flavor.equalsIgnoreCase("flaming hot");
                    break;

                case 3:
                    flavor.equalsIgnoreCase("jalapeno");
                    break;

                case 4:
                    flavor.equalsIgnoreCase("bbq");
                    break;

                default:
                    System.out.println("Selection not found, please try again.");
                    continue;

            }
            BagOfChip chips = new BagOfChip("Chips", 1.50, flavor);
            order.add(chips);
            System.out.println(flavor + " chips added to order.");

            System.out.println("Would you like to add another bag of chips?");
            System.out.println("1) for yes");
            System.out.println("2) for no");
            chipCommand = inputScanner.nextInt();
        } while ( chipCommand == 1);
    }
    private static void handleAddDrink() {
    }
    private static void displayOrder() {
    }
    private static void handleCheckout() {
    }
}
