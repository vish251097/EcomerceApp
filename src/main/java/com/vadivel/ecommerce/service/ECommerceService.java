package com.vadivel.ecommerce.service;

import com.vadivel.ecommerce.model.Product;
import com.vadivel.ecommerce.model.Customer;
import com.vadivel.ecommerce.exception.ProductNotFoundException;
import java.util.*;

public class ECommerceService {
    private Map<Integer, Product> inventory = new HashMap<>();

    public ECommerceService() {
        inventory.put(1, new Product(1, "Laptop", 1200.00));
        inventory.put(2, new Product(2, "Smartphone", 800.00));
        inventory.put(3, new Product(3, "Headphones", 150.00));
        inventory.put(4, new Product(4, "Keyboard", 75.00));
        inventory.put(5, new Product(5, "Mouse", 50.00));
    }

    public void displayProducts() {
        System.out.println("\n🛍️ Available Products:");
        for (Product p : inventory.values()) p.display();
    }

    public Product findProductById(int id) throws ProductNotFoundException {
        Product product = inventory.get(id);
        if (product == null) throw new ProductNotFoundException("❌ Product not found with ID: " + id);
        return product;
    }

    public void processCheckout(Customer customer) {
        double total = customer.checkout();
        System.out.println("💰 Total amount paid: $" + total);
        System.out.println("✅ Checkout completed! Thank you for shopping!");
    }
}
