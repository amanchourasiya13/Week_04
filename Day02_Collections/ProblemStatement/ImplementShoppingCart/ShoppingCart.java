
package Day02_Collections.ProblemStatement.ImplementShoppingCart;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class ShoppingCart {

    // HashMap to store the product prices (private)
    private static Map<String, Double> productPrices = new HashMap<>();

    // LinkedHashMap to maintain the order of items added to the cart (private)
    private static Map<String, Double> cart = new LinkedHashMap<>();

    // TreeMap to display items sorted by their prices (private)
    private static Map<String, Double> sortedByPrice = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return Double.compare(cart.get(a), cart.get(b)); // Sorting by price (ascending order)
        }
    });

    // Method to add products and their prices to the product list (HashMap)
    public static void addProduct(String productName, double price) {
        productPrices.put(productName, price);
    }

    // Method to add items to the cart
    public static void addToCart(String productName) {
        if (productPrices.containsKey(productName)) {
            cart.put(productName, productPrices.get(productName));
            sortedByPrice.put(productName, productPrices.get(productName));
        } else {
            System.out.println("Product not available: " + productName);
        }
    }

    // Method to display cart (items in the order they were added)
    public static void displayCart() {
        System.out.println("Items in the cart (order of addition):");
        cart.forEach((product, price) -> System.out.println(product + " - $" + price));
    }

    // Method to display items sorted by price (ascending order)
    public static void displaySortedCart() {
        System.out.println("Items sorted by price:");
        sortedByPrice.forEach((product, price) -> System.out.println(product + " - $" + price));
    }

    // Method to calculate total price of items in the cart
    public static void calculateTotal() {
        double total = 0.0;
        for (double price : cart.values()) {
            total += price;
        }
        System.out.println("Total Price: $" + total);
    }

    // Getter methods for testing purposes (private fields)
    public static Map<String, Double> getProductPrices() {
        return productPrices;
    }

    public static Map<String, Double> getCart() {
        return cart;
    }

    public static Map<String, Double> getSortedByPrice() {
        return sortedByPrice;
    }

    public static void main(String[] args) {
        // Adding products and their prices
        addProduct("Laptop", 1000.00);
        addProduct("Phone", 700.00);
        addProduct("Headphones", 150.00);
        addProduct("Mouse", 25.00);

        // Adding products to the cart
        addToCart("Laptop");
        addToCart("Phone");
        addToCart("Headphones");

        // Display the cart in the order products were added
        displayCart();

        // Display the cart sorted by price
        displaySortedCart();

        // Calculate and display the total price
        calculateTotal();
    }
}
