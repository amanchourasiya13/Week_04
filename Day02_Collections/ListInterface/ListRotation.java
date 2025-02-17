package Day02_Collections.ListInterface;
import java.util.ArrayList;
import java.util.List;

public class ListRotation {

    // Method to rotate elements in the list by a given number of positions
    public static <T> List<T> rotateList(List<T> inputList, int positions) {
        int size = inputList.size();

        // If the list is empty or the number of positions is 0 or multiple of list size, return the original list
        if (size == 0 || positions % size == 0) {
            return inputList;
        }

        // Ensure the positions are within the range of the list size
        positions = positions % size;

        // Create a new list to store the rotated elements
        List<T> rotatedList = new ArrayList<>();

        // Add elements from the given number of positions onward
        rotatedList.addAll(inputList.subList(positions, size));

        // Add elements from the beginning up to the given number of positions
        rotatedList.addAll(inputList.subList(0, positions));

        return rotatedList;
    }

    public static void main(String[] args) {

        // Example input list
        List<Integer> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        numberList.add(40);
        numberList.add(50);

        System.out.println("Original List: " + numberList);

        // Rotate the list by 2 positions
        List<Integer> rotatedList = rotateList(numberList, 2);

        System.out.println("Rotated List (by 2 positions): " + rotatedList);
    }
}
