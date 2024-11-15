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

## **Bag of chips menu**
The user can choose to add
- Multiple bags of chips based on flavor

## **Drink menu**
The user can choose to add
- Multiple drinks based on flavor and size

### **Checkout menu**
The user has the option to:
- Display order
- Checkout
- Start over
- Exit application

# Screenshots

## Main menu
![main menu](images%2FMain%20menu.png)

## Order menu
![order menu](images%2FOrder%20menu.png)

## Sandwich selection menu
![sandwich selection menu](images%2FSandwich%20selection%20menu.png)

## Customization menu
![customization menu](images%2FCustomization%20menu%20.png)

## Chips menu
![chips menu](images%2FChip%20menu.png)

## Drink menu
![drink menu](images%2FDrink%20menu.png)

## Checkout menu
![checkout menu](images%2FCheck%20out%20menu%20and%20display%20order%20pt%201.png)
![Display order pt 2](images%2FDisplay%20order%20pt%202.png)

## Receipt 
![receipt](images%2FReceipt.png)

## Resources

Here are some links for creating my buffered writer:
- [create a folder and how to have separate files move into it](https://stackoverflow.com/questions/16269563/how-to-save-a-file-to-a-directory)
- [difference between try and try-with-resources](https://medium.com/thefreshwrites/how-to-use-try-with-resource-in-java-9c0b4ae48d21#:~:text=This%20is%20because%20an%20IOException,as%20JVM%20automatically%20closes%20them.)
- [more info on try-with-resources](https://docs.oracle.com/javase/8/docs/technotes/guides/language/try-with-resources.html)
- [info on the mkdirs() method](https://www.geeksforgeeks.org/file-mkdirs-method-in-java-with-examples/)

Here are some links for if statements inside of switch cases:
- [simple example](https://stackoverflow.com/questions/60049457/refactor-switch-statement-using-an-object-vs-primitive-data-type)

## Interesting piece of code
![Interesting code making folder](images%2FInteresting%20code%20making%20folder.png)
This code creates a File object for the "receipts" directory. If the directory doesn’t exist (!receiptDir.exists()), it tries to create it using receiptDir.mkdirs(). If the directory creation fails, it outputs an error message.
Then since my bufferedWriter is created inside the parentheses of the try statement. When the try block completes (even if an exception occurs), BufferedWriter is automatically closed.

  