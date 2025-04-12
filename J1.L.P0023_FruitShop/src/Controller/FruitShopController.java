package Controller;

import Model.Fruit;
import Model.Order;
import Model.OrderItem;
import View.FruitListView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 84945
 */
public class FruitShopController {

    private static List<Fruit> fruits = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public FruitShopController() {
    }

    Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String mChon[] = {"Create Fruit",
            "View Orders",
            "Shopping (for buyer)",
            "Exit"};
        FruitListView fruitListView = new FruitListView("\nFruit Management", mChon);
        fruitListView.run();
    }

    public void addFruit() throws ParseException, IOException {
        int id = 0;
        boolean validId = false;
        while (!validId) {
            System.out.print("Enter ID: ");
            try {
                id = sc.nextInt();
                validId = true;
            } catch (Exception e) {
                System.err.println("Invalid input. ID must be an integer.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("Enter Price: ");
            try {
                price = sc.nextDouble();
                validPrice = true;
            } catch (Exception e) {
                System.err.println("Invalid input. Price must be double.");
                sc.nextLine();
            }
        }
        int quantity = 0;
        boolean validQuantity = false;
        while (!validQuantity) {
            System.out.print("Enter Quantity: ");
            try {
                quantity = sc.nextInt();
                validQuantity = true;
            } catch (Exception e) {
                System.err.println("Invalid input. Quantity must be an integer.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Enter Origin: ");
        String origin = sc.nextLine();
        Fruit fruit = new Fruit(id, name, price, quantity, origin);
        //fruitList.add(fruit);
        fruits.add(fruit);
        System.out.println("Add Item success!");
    }

    public void displayProducts() {
        System.out.println("Item | Fruit Name | Origin | Price");
        for (Fruit fruit : fruits) {
            System.out.println(fruit.getId() + " | " + fruit.getName() + " | " + fruit.getOrigin()
                    + " | " + fruit.getPrice());
        }
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.err.println("No orders available.");
        } else {
            System.out.println("Orders:");
            for (Order order : orders) {
                System.out.println("Customer: " + order.getCustomer());
                System.out.println("Product | Quantity | Price | Amount");
                List<OrderItem> items = order.getItems();
                for (OrderItem item : items) {
                    System.out.println(item.getFruit().getName() + " | " + item.getQuantity()
                            + " | " + item.getFruit().getPrice() + "$ | " + item.getAmount() + "$");
                }
                System.out.println("Total: " + order.getTotalAmount() + "$");
                System.out.println();
            }
        }
    }

    public void shopping(Scanner sc) {
        System.out.println("List of Fruits:");
        displayProducts();
        Order order = new Order();
        String choice;
        do {
            System.out.print("Enter Fruit Id to add to cart: ");
            int fruitId = sc.nextInt();
            sc.nextLine();
            Fruit selectedProduct = null;
            for (Fruit fruit : fruits) {
                if (fruit.getId() == fruitId) {
                    selectedProduct = fruit;
                    break;
                }
            }
            if (selectedProduct != null) {
                System.out.println("You selected: " + selectedProduct.getName());

                System.out.print("Please input quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine();
                if (quantity > selectedProduct.getQuantity()) {
                    System.err.println("Not enough quantity.");
                    break;
                } else {
                    OrderItem item = new OrderItem(selectedProduct, quantity);
                    order.addItem(item);
                }

                System.out.print("Do you want to order now (Y/N)? ");
                choice = sc.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    System.out.println("Product | Quantity | Price | Amount");
                    List<OrderItem> items = order.getItems();
                    for (OrderItem orderItem : items) {
                        System.out.println(orderItem.getFruit().getName() + " | " + orderItem.getQuantity()
                                + " | " + orderItem.getFruit().getPrice() + "$ | " + orderItem.getAmount() + "$");
                    }
                    System.out.println("Total: " + order.getTotalAmount() + "$");
                    System.out.print("Input your name: ");
                    String customer = sc.nextLine();
                    order.setCustomer(customer);
                    orders.add(order);
                    System.out.println("Order successfully!");
                    return;
                }
            } else {
                System.err.println("Invalid Fruit Id. Please try again.");
                choice = "N";
            }
        } while (choice.equalsIgnoreCase("N"));
    }
}
