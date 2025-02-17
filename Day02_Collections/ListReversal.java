package Day02_Collections.ListInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListReversal {

  // Method to reverse any List without using built-in reverse methods
public static List<Integer> reverseList(List<Integer> inputList) {
    List<Integer> reversedList = new ArrayList<>(); // You can use LinkedList as well

    // Start from the end of the input list and add elements to the new list
    for (int i = inputList.size() - 1; i >= 0; i--) {
        reversedList.add(inputList.get(i));
    }

    return reversedList;
}

    public static void main(String[] args) {

        // Example for ArrayList of Integer
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("Original ArrayList: " + arrayList);
        List<Integer> reversedArrayList = reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + reversedArrayList);

        // Example for LinkedList of Integer
        List<Integer> linkedList = new ArrayList<>();  // You can change it to LinkedList as well
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("\nOriginal LinkedList: " + linkedList);
        List<Integer> reversedLinkedList = reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}