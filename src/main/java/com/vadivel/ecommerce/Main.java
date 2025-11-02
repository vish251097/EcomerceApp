package com.vadivel.ecommerce;

import com.vadivel.ecommerce.model.Product;
import com.vadivel.ecommerce.model.Customer;
import com.vadivel.ecommerce.service.ECommerceService;
import com.vadivel.ecommerce.exception.ProductNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ECommerceService service = new ECommerceService();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        Customer customer = new Customer(name);

        while (true) {
            System.out.println("\n===== 🛒 E-Commerce Menu =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> service.displayProducts();
                case 2 -> {
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();
                    try {
                        Product p = service.findProductById(id);
                        customer.addToCart(p);
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> customer.viewCart();
                case 4 -> service.processCheckout(customer);
                case 5 -> {
                    System.out.println("👋 Exiting... Thank you for visiting!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}
