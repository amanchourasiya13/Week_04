package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

import java.util.List;
import java.util.ArrayList;

public class ListManager {

    // Method to add an element to the list
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Method to remove an element from the list
    public boolean removeElement(List<Integer> list, int element) {
        return list.remove(Integer.valueOf(element));
    }

    // Method to get the size of the list
    public int getSize(List<Integer> list) {
        return list.size();
    }

    // Main method for testing the ListManager
    public static void main(String[] args) {
        // Creating an instance of ListManager
        ListManager listManager = new ListManager();

        // Creating a list to test
        List<Integer> list = new ArrayList<>();

        // Test adding elements
        System.out.println("Adding elements:");
        listManager.addElement(list, 5);
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        System.out.println("List after adding elements: " + list);
        System.out.println("List size: " + listManager.getSize(list));

        // Test removing elements
        System.out.println("\nRemoving elements:");
        listManager.removeElement(list, 10);  // Should remove 10
        System.out.println("List after removing element 10: " + list);
        System.out.println("List size: " + listManager.getSize(list));

        // Test removing an element that doesn't exist
        boolean result = listManager.removeElement(list, 50);  // Should return false
        System.out.println("Attempted to remove 50: " + result);
        System.out.println("List after attempting to remove non-existent element: " + list);
        System.out.println("List size: " + listManager.getSize(list));

        // Test getting size
        System.out.println("\nGetting list size:");
        System.out.println("List size: " + listManager.getSize(list));  // Should print current size
    }
}


