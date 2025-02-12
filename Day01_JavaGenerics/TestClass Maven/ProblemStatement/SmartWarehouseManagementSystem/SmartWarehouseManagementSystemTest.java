
package Day01_JavaGenerics.ProblemStatement.SmartWarehouseManagementSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SmartWarehouseManagementSystemTest {

    private Electronics e1, e2;
    private Groceries g1, g2;
    private Furniture f1, f2;

    private Storage<Electronics> electronicsStorage;
    private Storage<Groceries> groceriesStorage;
    private Storage<Furniture> furnitureStorage;

    @BeforeEach
    public void setUp() {
        // Initialize items
        e1 = new Electronics("Fridge", 40000, "Samsung");
        e2 = new Electronics("Laptop", 50000, "HP");
        g1 = new Groceries("High-value Cup", 1000, "24Jan2026");
        g2 = new Groceries("Apple", 100, "24Jan2026");
        f1 = new Furniture("Chair", 1000, "Wood");
        f2 = new Furniture("Table", 121, "Wood");

        // Initialize storages
        electronicsStorage = new Storage<>();
        groceriesStorage = new Storage<>();
        furnitureStorage = new Storage<>();

        // Add items to respective storages
        electronicsStorage.addItem(e1);
        electronicsStorage.addItem(e2);

        groceriesStorage.addItem(g1);
        groceriesStorage.addItem(g2);

        furnitureStorage.addItem(f1);
        furnitureStorage.addItem(f2);
    }

    @Test
    public void testDisplayItemsForElectronics() {
        // Capture output using System.setOut and check the printed output
        List<Electronics> items = electronicsStorage.getItems();
        assertNotNull(items);
        assertEquals(2, items.size());
    }

    @Test
    public void testDisplayItemsForGroceries() {
        List<Groceries> items = groceriesStorage.getItems();
        assertNotNull(items);
        assertEquals(2, items.size());
    }

    @Test
    public void testDisplayItemsForFurniture() {
        List<Furniture> items = furnitureStorage.getItems();
        assertNotNull(items);
        assertEquals(2, items.size());
    }

    @Test
    public void testDisplayAllItemsFromWareHouse() {
        // Display items using the wildcard method
        WareHouse.displayItems(electronicsStorage.getItems());
        WareHouse.displayItems(groceriesStorage.getItems());
        WareHouse.displayItems(furnitureStorage.getItems());
    }

    @Test
    public void testStorageAddItems() {
        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Orange", 200, "25Jan2026"));
        assertEquals(1, groceryStorage.getItems().size());
        assertTrue(groceryStorage.getItems().get(0) instanceof Groceries);
    }
}