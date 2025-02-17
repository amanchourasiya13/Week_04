package Day02_Collections.ListInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ListRotationTest{

    // Test for rotating the list by a valid number of positions
    @Test
    public void testRotateListBy2Positions() {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        numberList.add(40);
        numberList.add(50);

        List<Integer> expectedRotatedList = new ArrayList<>();
        expectedRotatedList.add(30);
        expectedRotatedList.add(40);
        expectedRotatedList.add(50);
        expectedRotatedList.add(10);
        expectedRotatedList.add(20);

        List<Integer> rotatedList = ListRotation.rotateList(numberList, 2);

        // Assert that the rotated list matches the expected rotated list
        assertEquals(expectedRotatedList, rotatedList);
    }

    // Test for rotating the list by 0 positions (should return the same list)
    @Test
    public void testRotateListBy0Positions() {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        numberList.add(40);
        numberList.add(50);

        List<Integer> rotatedList = ListRotation.rotateList(numberList, 0);

        // Assert that rotating by 0 positions results in the same list
        assertEquals(numberList, rotatedList);
    }

    // Test for rotating the list by the size of the list (should return the same list)
    @Test
    public void testRotateListByListSize() {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        numberList.add(40);
        numberList.add(50);

        List<Integer> rotatedList = ListRotation.rotateList(numberList, 5);

        // Assert that rotating by the list size results in the same list
        assertEquals(numberList, rotatedList);
    }

    // Test for rotating the list by a number greater than the list size
    @Test
    public void testRotateListByGreaterThanListSize() {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        numberList.add(40);
        numberList.add(50);

        List<Integer> expectedRotatedList = new ArrayList<>();
        expectedRotatedList.add(30);
        expectedRotatedList.add(40);
        expectedRotatedList.add(50);
        expectedRotatedList.add(10);
        expectedRotatedList.add(20);

        // Rotate by 7 positions, which is equivalent to rotating by 2 positions
        List<Integer> rotatedList = ListRotation.rotateList(numberList, 7);

        // Assert that the rotated list matches the expected rotated list
        assertEquals(expectedRotatedList, rotatedList);
    }
}
