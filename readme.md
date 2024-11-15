# DELIcious Sandwich Shop

## Overview
The **DELIcious Sandwich Shop** is an application for the company to use to keep track of orders. The shop allows customers to create their own orders, customizing their own sandwiches or the pre-made signature sandwiches. The application handles the entire ordering process, from adding items to the order to saving the receipt for future reference.

## Features
- **Receipt generator** : Saves an order receipt to a folder based on current date and time. 


## Project Layout

- **Main**: Main entry point of the application
- **UserInterface**: Handles the CLI user interactions and menus
- **Product**: Abstract class for general products
- **Sandwich**: Defines the base Sandwich class
- **BLT**: BLT signature sandwich class
- **PhillyCheeseSteak**: Philly Cheese Steak signature sandwich class
- **BagOfChip**: Defines the chips product
- **Drink**: Defines the drink product
- **Topping**: Manages toppings and their prices
- **Order**: Manages the current order and list of products
- **ReceiptManager**: Handles saving the order receipt to a file
- **Pricing**: Interface for defining pricing methods

## Menus
### **Main menu** 
The user can choose to:
- Start an order
- Exit application

### **Order menu**
The user can choose to:
- Add a sandwich
- Add a bag of chips
- Add a drink
- Checkout
- Start over

### **Sandwich selection menu**
The user can choose to add:
- Their own customizable sandwich
- A BLT sandwich
- A philly cheese steak sandwich

- Then choose to either customize it or not

### **Customization menu**
The use can customize the sandwich by:
- Adding more toppings
- Removing toppings
- Change toasted options

### **Checkout menu**
The user has the option to:
- Display order
- Checkout
- Start over
- Exit application

# Screenshots

## Main menu

## Order menu


## Sandwich selection menu


## Customization menu


## Checkout menu


## Receipt 


## Resources

Here are some links for creating my buffered writer:
- [create a folder and how to have separate files move into it](https://stackoverflow.com/questions/16269563/how-to-save-a-file-to-a-directory)

Here are some links for if statements inside of switch cases:
- [simple example](https://stackoverflow.com/questions/60049457/refactor-switch-statement-using-an-object-vs-primitive-data-type)

## Interesting piece of code


  )