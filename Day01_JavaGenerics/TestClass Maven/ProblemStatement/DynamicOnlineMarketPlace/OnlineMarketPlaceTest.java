package Day01_JavaGenerics.ProblemStatement.DynamicOnlineMarketPlace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OnlineMarketPlaceTest {

    private Product<BookCategory> book;
    private Product<ClothingCategory> clothing;
    private Product<GadgetCategory> gadget;

    @BeforeEach
    public void setUp() {
        book = new Product<>("Java Programming Book", 50.0, new BookCategory());
        clothing = new Product<>("Winter Jacket", 120.0, new ClothingCategory());
        gadget = new Product<>("Smartphone", 500.0, new GadgetCategory());
    }

    @Test
    public void testProductDiscounts() {
        // Apply discounts to the products
        OnlineMarketPlace.applyDiscount(book, 10);  // 10% discount on book
        OnlineMarketPlace.applyDiscount(clothing, 15); // 15% discount on clothing
        OnlineMarketPlace.applyDiscount(gadget, 5); // 5% discount on gadget

        // Check if the discounts were applied correctly
        assertEquals(45.0, book.getPrice(), 0.01); // 50 - (10% of 50)
        assertEquals(102.0, clothing.getPrice(), 0.01); // 120 - (15% of 120)
        assertEquals(475.0, gadget.getPrice(), 0.01); // 500 - (5% of 500)
    }

    @Test
    public void testProductCategory() {
        // Verify the categories of the products
        assertEquals("Books", book.getCategory().getCategoryName());
        assertEquals("Clothing", clothing.getCategory().getCategoryName());
        assertEquals("Gadgets", gadget.getCategory().getCategoryName());
    }
}
