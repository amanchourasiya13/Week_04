package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {

    private ListManager listManager;
    private List<Integer> list;

    // Set up a new List and ListManager before each test
    @BeforeEach
    public void setUp() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }

    // Test for adding an element to the list
    @Test
    public void testAddElement() {
        listManager.addElement(list, 5);
        assertEquals(1, list.size(), "List should contain 1 element after adding.");
        assertTrue(list.contains(5), "List should contain the added element.");
    }

    // Test for removing an element from the list
    @Test
    public void testRemoveElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        listManager.addElement(list, 30);

        assertTrue(listManager.removeElement(list, 20), "List should successfully remove the element.");
        assertEquals(2, list.size(), "List should contain 2 elements after removal.");
        assertFalse(list.contains(20), "List should not contain the removed element.");

        assertFalse(listManager.removeElement(list, 40), "List should return false for non-existing element.");
    }

    // Test for getting the size of the list
    @Test
    public void testGetSize() {
        assertEquals(0, listManager.getSize(list), "List should be empty initially.");

        listManager.addElement(list, 1);
        assertEquals(1, listManager.getSize(list), "List size should be 1 after adding one element.");

        listManager.addElement(list, 2);
        assertEquals(2, listManager.getSize(list), "List size should be 2 after adding another element.");

        listManager.removeElement(list, 1);
        assertEquals(1, listManager.getSize(list), "List size should be 1 after removing one element.");
    }
}
