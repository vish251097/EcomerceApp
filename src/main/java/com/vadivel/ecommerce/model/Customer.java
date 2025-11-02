package com.vadivel.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Product> cart = new ArrayList<>();

    public Customer(String name) { this.name = name; }

    public void addToCart(Product product) {
        cart.add(product);
        System.out.println("🛒 Added " + product.getName() + " to cart!");
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("⚠️ Cart is empty!");
            return;
        }
        System.out.println("\n🛍️ Cart Items for " + name + ":");
        for (Product p : cart) {
            p.display();
        }
    }

    public double checkout() {
        double total = 0;
        for (Product p : cart) total += p.getPrice();
        cart.clear();
        return total;
    }
}
