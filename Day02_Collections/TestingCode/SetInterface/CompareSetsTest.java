package Day02_Collections.SetInterface;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CompareSetsTest {
@Test
    public void testAreSetsEqual(){
    Set<Integer>set1=new HashSet<>();
    set1.add(1);
    set1.add(2);
    set1.add(3);

    Set<Integer>set2=new HashSet<>();
    set2.add(3);
    set2.add(2);
    set2.add(1);

    boolean result=CompareSets.areSetsEqual(set1,set2);
    assertTrue(result,"The test should be equal.");
}

    public void testArwSetsNotEqual(){
        Set<Integer>set1=new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer>set2=new HashSet<>();
        set2.add(5);
        set2.add(4);
        set2.add(6);

        boolean result=CompareSets.areSetsEqual(set1,set2);
        assertFalse(result,"The sets should not be equal.");
    }

}