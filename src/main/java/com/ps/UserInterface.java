package com.ps;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner commandScanner = new Scanner(System.in);
    static Scanner inputScanner = new Scanner(System.in);

    private static Order order = new Order();

    public static void display() {
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
        System.out.print("What's the name for the order?: ");
        String name = inputScanner.nextLine();

        int orderCommand;
        do {
            System.out.println("What would you like to do with your order?");
            System.out.println("1) Add a sandwich");
            System.out.println("2) Add a bag of chips");
            System.out.println("3) Add a drink");
            // System.out.println("4) See your order details");
            System.out.println("4) Checkout");
            System.out.println("0) Start over");
            System.out.print("Selection: ");
            //  orderCommand = inputScanner.nextInt();

            try {
                orderCommand = commandScanner.nextInt();
            } catch (InputMismatchException ime) {
                orderCommand = 0;
            }

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

//                case 4:
//                    displayOrder();
//                    break;

                case 4:
                    handleCheckout();
                    break;

                case 0:
                    System.out.println("Starting over...");

                default:
                    System.out.println("Command not found, please try again...");
            }
        } while (orderCommand != 0); //or 5
    }

    private static void handleAddSandwich() {
        //another nested menu for built your own sandwich
        Sandwich sandwich = null;

        do {
            try {
                System.out.println("Select a type of sandwich: ");
                System.out.println("1) Built your own sandwich ");
                System.out.println("2) BLT");
                System.out.println("3) Philly cheese steak");
                System.out.print("Selection: ");
                int sandwichChoice = inputScanner.nextInt();
                inputScanner.nextLine();

                // Sandwich sandwich = null;

                switch (sandwichChoice) {
                    case 1:
//               customizeSandwich(sandwich);
//                System.out.println("Custom sandwich added to order.");
//                break;
                        System.out.println("Enter sandwich size (4,8, or 12 inches): ");
                        int size = inputScanner.nextInt();
                        inputScanner.nextLine();

                        System.out.println("Enter bread type (white, wheat, rye, or wrap): ");
                        // inputScanner.nextLine();
                        String breadType = inputScanner.nextLine();

                        System.out.println("Do you want the sandwich toasted? (yes/no): ");
                        boolean isToasted = inputScanner.nextLine().equalsIgnoreCase("yes");

                        sandwich = new Sandwich("Custom sandwich", 5.50, size, breadType, isToasted);
                        System.out.println("Custom sandwich added to order.");
                        System.out.println("Would you like to customize it? (yes/no)");


                        if (inputScanner.nextLine().equalsIgnoreCase("yes")) {
                            customizeSandwich(sandwich);
                            inputScanner.nextLine();
                        }
                        break;

                    case 2:
                        sandwich = new BLT();
                        System.out.print("BLT selected. Would you like to customize it? (yes/no): ");

                        if (inputScanner.nextLine().equalsIgnoreCase("yes")) {
                            customizeSandwich(sandwich);
                            inputScanner.nextLine();
                        }
                        break;

                    case 3:
                        sandwich = new PhillyCheeseSteak();
                        System.out.print("Philly cheese steak selected. Would you like to customize it? (yes/no): ");

                        if (inputScanner.nextLine().equalsIgnoreCase("yes")) {
                            customizeSandwich(sandwich);
                            inputScanner.nextLine();
                        }
                        break;

                    default:
                        System.out.println("Selection not found, please try again.");
                        break;
                }
                if (sandwich != null) {
                    order.addProducts(sandwich);
                    System.out.println(sandwich.getName() + " added to order.");
                }
                break;
            } catch (InputMismatchException ime) {
                System.out.println("Selection not found, please try again.");
                inputScanner.nextLine();
            }
        } while (sandwich == null);
    }

    private static void customizeSandwich(Sandwich sandwich) {
        int customizeSandwichChoice;
        do {
            System.out.println("Select what you would like to customize from your " + sandwich.getName() + ":");
            System.out.println("1) Add topping");
            System.out.println("2) Remove topping");
            System.out.println("3) Handle toasted");
            System.out.println("0) Finish customization");
            System.out.print("Selection: ");
            customizeSandwichChoice = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (customizeSandwichChoice) {
                case 1:
                    System.out.print("Enter topping name: ");
                    String toppingName = inputScanner.next().trim();
                    inputScanner.nextLine();
                    // String toppingName = inputScanner.nextLine();
                    System.out.print("Enter topping type (meat, cheese, vegetable, sauce, sides): ");
                    String toppingType = inputScanner.nextLine();
                    System.out.print("Enter topping category (regular, premium): ");
                    String toppingCategory = inputScanner.nextLine();
                    int size = sandwich.getSize();

//                    System.out.println("Enter size of sandwich (4, 8, 12): ");
//                    int size = inputScanner.nextInt();
//                    inputScanner.nextLine();

                    double basePrice = 0.0;
                    double extraPrice = 0.0;

                    if (toppingCategory.equalsIgnoreCase("premium")) {
//                        if (toppingType.equalsIgnoreCase("meat")) {
//                            System.out.println(sandwich.getSize());
//                            switch (sandwich.getSize()) {
//                                case 4:
//                                    basePrice = 1.00;
//                                    extraPrice = 0.50;
//                                    break;
//
//                                case 8:
//                                    basePrice = 2.00;
//                                    extraPrice = 1.00;
//                                    break;
//
//                                case 12:
//                                    basePrice = 3.00;
//                                    extraPrice = 1.50;
//                                    break;
//
//                                default:
//                                    System.out.println("Selection not found, please try again.");
//                                    break;
//                            }
                        //  if (toppingCategory.equalsIgnoreCase("premium")) {
                        //  int size = sandwich.getSize(); // Get size directly from sandwich
                        switch (size) {
                            case 4:
                                basePrice = 1.00;
                                extraPrice = 0.50;
                                break;
                            case 8:
                                basePrice = 2.00;
                                extraPrice = 1.00;
                                break;
                            case 12:
                                basePrice = 3.00;
                                extraPrice = 1.50;
                                break;
                            default:
                                System.out.println("Size not recognized. Using default premium topping price.");
                                break;
                        }


                    } else if (toppingType.equalsIgnoreCase("cheese")) {

                        switch (sandwich.getSize()) {
                            case 4:
                                basePrice = 0.75;
                                extraPrice = 0.30;
                                break;

                            case 8:
                                basePrice = 1.50;
                                extraPrice = 0.60;
                                break;

                            case 12:
                                basePrice = 2.25;
                                extraPrice = 0.90;
                                break;

                            default:
                                System.out.println("Selection not found, please try again.");
                                break;
                        }
                    } else if (toppingCategory.equalsIgnoreCase("regular")) {
                        System.out.println("Regular toppings are no additional cost.");
                        basePrice = 0.0;
                    }
                    System.out.print("Would you like extra " + toppingName + " ? (yes/no):");
                    //  inputScanner.nextLine();
                    String isExtra = inputScanner.nextLine();
                    // inputScanner.nextLine();

                    if (isExtra.equalsIgnoreCase("yes")) {
                        basePrice += extraPrice;

                    }
//        } else if (toppingCategory.equalsIgnoreCase("regular")) {
//            System.out.println("Regular toppings are no additional cost.");
//            basePrice = 0.0;


                    //System.out.println("Debug: Adding topping with name = '" + toppingName + "'");
                    double finalToppingPrice = basePrice;
                    // Topping newTopping = new Topping(toppingName, toppingType, toppingCategory, sandwich.getSize());
                    Topping newTopping = new Topping(toppingName, toppingType, toppingCategory, sandwich.getSize(), finalToppingPrice);

                    sandwich.addTopping(newTopping);
                    System.out.println(toppingName + " has been added to sandwich.");
                    break;

                case 2:
                    System.out.println("Enter the name of the topping to remove: ");
                    String toppingToRemove = inputScanner.nextLine();
                    if (sandwich.removeTopping(toppingToRemove)) {
                        //  System.out.println(toppingToRemove + " has been removed from sandwich.");

                    } else {
                        System.out.println("Topping not found, please try again.");

                    }
                    break;

                case 3:
                   // boolean isToasted;
//                    System.out.println("Would you like your sandwich toasted? (yes/no): ");
//                    inputScanner.nextLine();
//                    String toastChoice = inputScanner.nextLine();
//                    isToasted = toastChoice.equalsIgnoreCase("yes");
                        boolean isToasted = sandwich.isToasted();

                    if (sandwich instanceof BLT || sandwich instanceof PhillyCheeseSteak) {
                      //  isToasted = true;
                        System.out.print("This sandwich is usually toasted. Would you like for it to be not toasted? (yes/no): ");
                     //   String overrideChoice = inputScanner.nextLine();
//                        if (overrideChoice.equalsIgnoreCase("yes")) {
//                            isToasted = false;
//                        }
                        if (inputScanner.nextLine().equalsIgnoreCase("yes")) {
                            isToasted = false;
                        }
                    } else {
                        System.out.println("Would you like your sandwich toasted? (yes/no): ");
                        isToasted = inputScanner.nextLine().equalsIgnoreCase("yes");

                    }
                    sandwich.setToasted(isToasted);
                    break;

                case 0:
                    System.out.println("Customization complete!");
                    break;

            }
        } while (customizeSandwichChoice != 0);
    }

    private static void handleAddBagOfChips() {
        int chipCommand;
        commandScanner.nextLine();
        do {
            System.out.println("Choose a flavor of chips: ");
            System.out.println("1) Classic");
            System.out.println("2) Flaming hot");
            System.out.println("3) Jalapeno");
            System.out.println("4) BBQ");
            System.out.println("0) Return to order menu");
            System.out.print("Selection: ");
            // inputScanner.nextLine();
            //  int chipChoice = inputScanner.nextInt();
            inputScanner.nextLine();

            try {
                chipCommand = commandScanner.nextInt();
            } catch (InputMismatchException ime) {
                chipCommand = 0;
            }

            if (chipCommand == 0) {
                System.out.println("Returning to order menu...");
                return;
            }

            String flavor = "";
            switch (chipCommand) {
                case 1:
                    flavor = ("classic");
                    break;

                case 2:
                    flavor = ("flaming hot");
                    break;

                case 3:
                    flavor = ("jalapeno");
                    break;

                case 4:
                    flavor = ("bbq");
                    break;


                default:
                    System.out.println("Selection not found, please try again.");
                    continue;

            }
            BagOfChip chips = new BagOfChip("Chips", 1.50, flavor);
            order.addProducts(chips);
            System.out.println(flavor + " chips has been added to the order.");

            System.out.println("Would you like to add another bag of chips? (yes/no)");
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.println("Selection: ");

            try {
                chipCommand = inputScanner.nextInt();
                inputScanner.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Returning to order menu.");
                inputScanner.nextLine();
                chipCommand = 2;
            }

//            String addAnother = inputScanner.nextLine().toLowerCase();
//
//            if (!addAnother.equalsIgnoreCase("yes")) {
//                break;
//            }
            // chipCommand = inputScanner.nextInt();
        } while (chipCommand == 1);

    }


    private static void handleAddDrink() {
        int drinkChoice;
        do {
            System.out.println("Choose a drink: ");
            System.out.println("1) Coke");
            System.out.println("2) Sprite");
            System.out.println("3) Lemonade");
            System.out.println("4) Dr Pepper");
            System.out.println("0) Return to order menu");
            System.out.print("Selection: ");
            // int drinkChoice = inputScanner.nextInt();

            try {
                drinkChoice = inputScanner.nextInt();
                inputScanner.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Selection not found, please try again.");
                inputScanner.nextLine();
                continue;
                // drinkChoice = 0;
            }

            if (drinkChoice == 0) {
                System.out.println("Returning to order menu...");
                return;
            }

            String flavor = "";
            switch (drinkChoice) {
                case 1:
                    flavor = ("coke");
                    break;

                case 2:
                    flavor = ("sprite");
                    break;

                case 3:
                    flavor = ("lemonade");
                    break;

                case 4:
                    flavor = ("dr pepper");
                    break;

                default:
                    System.out.println("Selection not found, please try again.");
                    //  return;
                    continue;
            }
            System.out.println("Choose a size: ");
            System.out.println("1) Small");
            System.out.println("2) Medium");
            System.out.println("3) Large");
            System.out.println("Selection: ");
            //int drinkSizeChoice = inputScanner.nextInt();

            // int drinkSizeChoice;

            int drinkSizeChoice;
            try {
                drinkSizeChoice = inputScanner.nextInt();
                inputScanner.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Selection not found, please try again.");
                inputScanner.nextLine();
                continue;
            }
            String size = "";
            double price;

            switch (drinkSizeChoice) {
                case 1:
                    size = ("small");
                    price = 2.00;
                    break;

                case 2:
                    size = ("medium");
                    price = 2.50;
                    break;

                case 3:
                    size = ("large");
                    price = 3.00;
                    break;

                default:
                    System.out.println("Selection not found, please try again.");
                    continue;
            }
            Drink drink = new Drink("Drink", price, flavor, size);
            order.addProducts(drink);
            System.out.println(size + " " + flavor + " added to order.");

            System.out.println("Would you like to add another drink? (yes/no)");
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.println("Selection: ");

            try {
                drinkChoice = inputScanner.nextInt();
                inputScanner.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Returning to order menu.");
                inputScanner.nextLine();
                drinkChoice = 2;
            }
        } while (true);
    }

//    private static void displayOrder() {
//        System.out.println("Order details: ");
//        double totalCost = 0.0;
//
//        for (Product product : order.getProducts()) {
//            System.out.println("Product: " + product.getName());
//            System.out.println("Price: $" + String.format("%.2f", product.getBasePrice()));
//
//            if (product instanceof Sandwich sandwich) {
//                System.out.println("Size: " + sandwich.getSize() + " inches");
//                System.out.println("Bread type: " + sandwich.getBreadType());
//                System.out.println("Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
//
//                List<Topping> toppings = sandwich.getToppings();
//                if (toppings != null && !toppings.isEmpty()) {
//                    System.out.println("Toppings: ");
//                    for (Topping topping : toppings) {
//                        System.out.println(" " + topping.getName() + " (" + topping.getCategory() + ") " + String.format("%.2f", topping.getPrice()));
//
//                    }
//                }
//
//
//            } else if (product instanceof Drink drink) {
//                System.out.println("Flavor: " + drink.getFlavor());
//                System.out.println("Size: " + drink.getSize());
//
//            } else if (product instanceof BagOfChip chips) {
//                System.out.println("Flavor: " + chips.getFlavor());
//            }
//            System.out.println();
//            totalCost += product.getPrice();
//        }
//        System.out.println("Total price for order: $" + String.format("%.2f", totalCost));
//    }

    private static void handleCheckout() {
        int checkout;

//        System.out.println("Are you sure you wanna finalize your order?: ");
//        System.out.println("1) Place order");
//        System.out.println("0) Start over");
//        System.out.print("Selection: ");

        do {
            System.out.println("What would you like to do with your order?: ");
            System.out.println("1) Display order");
            System.out.println("2) Checkout");
            System.out.println("3) Start over");
            System.out.println("0) Exit application");
            System.out.print("Selection: ");

            try {
                checkout = inputScanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Selection not found, please try again.");
                inputScanner.nextLine();
                return;
            }
//         switch (checkout) {
//             case 1:
//                 System.out.println("Finalizing your order...");
//                 //save order method from receiptmanager
//                 ReciptManager.saveOrderReceipt(order);
//                 System.out.println("Your order has been saved. Thank you, it will come out shortly!");
//                 order = new Order();
//                 break;
//
//             case 0:
//                 System.out.println("Starting over...");
//                 break;
//
//             default:
//                 System.out.println("Selection not found, please try again.");
//                 break;
//         }
            switch (checkout) {
                case 1:
                    displayOrder();
                    break;

                case 2:
                    System.out.println("Finalizing your order...");
                    ReceiptManager.saveOrderReceipt(order);
                    System.out.println("Your order has been saved. Thank you, it will come out shortly!");
                    order = new Order();
                    System.exit(0);
                    break;

                case 3:
                    System.out.println("Returning to order menu...");
                    break;

                case 0:
                    System.out.println("Goodbye, please come again!");
                    System.exit(0);

                default:
                    System.out.println("Selection not found, please try again.");
                    break;

            }

        } while (checkout != 2 && checkout != 0);

    }

    private static void displayOrder() {
        System.out.println("Order details: ");
        double totalCost = 0.0;

        for (Product product : order.getProducts()) {
            System.out.println("Product: " + product.getName());
            System.out.println("Price: $" + String.format("%.2f", product.getBasePrice()));

            if (product instanceof Sandwich sandwich) {
                System.out.println("Size: " + sandwich.getSize() + " inches");
                System.out.println("Bread type: " + sandwich.getBreadType());
                System.out.println("Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));

                List<Topping> toppings = sandwich.getToppings();
                if (toppings != null && !toppings.isEmpty()) {
                    System.out.println("Toppings: ");
                    for (Topping topping : toppings) {
                        System.out.println(" " + topping.getName() + " (" + topping.getCategory() + ") " + String.format("%.2f", topping.getPrice()));

                    }
                }


            } else if (product instanceof Drink drink) {
                System.out.println("Flavor: " + drink.getFlavor());
                System.out.println("Size: " + drink.getSize());

            } else if (product instanceof BagOfChip chips) {
                System.out.println("Flavor: " + chips.getFlavor());
            }
            System.out.println();
            totalCost += product.getPrice();
        }
        System.out.println("Total price for order: $" + String.format("%.2f", totalCost));
    }
}
