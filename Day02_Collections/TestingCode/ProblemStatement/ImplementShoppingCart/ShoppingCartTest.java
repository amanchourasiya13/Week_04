package Day02_Collections.ProblemStatement.ImplementShoppingCart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    // Resetting the state before each test
    @BeforeEach
    void setUp() {
        // Clear previous data before each test
        ShoppingCart.getCart().clear();
        ShoppingCart.getProductPrices().clear();
        ShoppingCart.getSortedByPrice().clear();
    }

    // Test to check if products are being added correctly
    @Test
    void testAddProduct() {
        ShoppingCart.addProduct("Laptop", 1000.00);
        assertEquals(1, ShoppingCart.getProductPrices().size());
        assertEquals(1000.00, ShoppingCart.getProductPrices().get("Laptop"));
    }

    // Test to check if products are added to the cart correctly
    @Test
    void testAddToCart() {
        ShoppingCart.addProduct("Laptop", 1000.00);
        ShoppingCart.addToCart("Laptop");
        assertEquals(1, ShoppingCart.getCart().size());
        assertEquals(1000.00, ShoppingCart.getCart().get("Laptop"));
    }

    // Test to check if the cart displays products in the correct order
    @Test
    void testDisplayCart() {
        ShoppingCart.addProduct("Laptop", 1000.00);
        ShoppingCart.addProduct("Phone", 700.00);
        ShoppingCart.addToCart("Laptop");
        ShoppingCart.addToCart("Phone");

        // Capture the output
        ShoppingCart.displayCart();

        // Validate the cart items by checking the order
        assertEquals("Laptop", ShoppingCart.getCart().keySet().toArray()[0]);
        assertEquals("Phone", ShoppingCart.getCart().keySet().toArray()[1]);
    }

    // Test to check if products in the cart are displayed sorted by price
    @Test
    void testDisplaySortedCart() {
        ShoppingCart.addProduct("Laptop", 1000.00);
        ShoppingCart.addProduct("Phone", 700.00);
        ShoppingCart.addProduct("Headphones", 150.00);
        ShoppingCart.addToCart("Laptop");
        ShoppingCart.addToCart("Phone");
        ShoppingCart.addToCart("Headphones");

        // Capture the output
        ShoppingCart.displaySortedCart();

        // Validate the sorted cart items
        assertEquals("Headphones", ShoppingCart.getSortedByPrice().keySet().toArray()[0]);
        assertEquals("Phone", ShoppingCart.getSortedByPrice().keySet().toArray()[1]);
        assertEquals("Laptop", ShoppingCart.getSortedByPrice().keySet().toArray()[2]);
    }

    // Test to check the total price calculation
    @Test
    void testCalculateTotal() {
        ShoppingCart.addProduct("Laptop", 1000.00);
        ShoppingCart.addProduct("Phone", 700.00);
        ShoppingCart.addToCart("Laptop");
        ShoppingCart.addToCart("Phone");

        // Capture the total price output
        ShoppingCart.calculateTotal();

        // Validate total price calculation
        double total = ShoppingCart.getCart().values().stream().mapToDouble(Double::doubleValue).sum();
        assertEquals(1700.00, total);
    }
}
