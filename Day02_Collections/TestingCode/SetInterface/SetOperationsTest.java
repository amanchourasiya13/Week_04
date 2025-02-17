package Day02_Collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SetOperationsTest {

        // Example sets
    @Test
    public void testUnion(){
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Compute union
        Set<Integer> expectUnionSet = new HashSet<>();
        expectUnionSet.add(1);
        expectUnionSet.add(2);
        expectUnionSet.add(3);
        expectUnionSet.add(4);
        expectUnionSet.add(5);

        // Compute intersection
        Set<Integer> actual = SetOperations.union(set1,set2);
        Assertions.assertEquals(expectUnionSet,actual,"Union of two sets should contain correct elements.");
    }
    @Test
    public void testIntersection(){
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer>expectIntrsectionTest=new HashSet<>();
        expectIntrsectionTest.add(3);

        Set<Integer>actual=SetOperations.intersection(set1,set2);
        Assertions.assertEquals(expectIntrsectionTest,actual,"Intersection of two sets contain only same elements.");
    }
}
