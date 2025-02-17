package Day02_Collections.SetInterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SubSetCheckTest {
    @Test
public void checkSubSet(){
    Set<Integer> set1 = new HashSet<>();
    set1.add(2);
    set1.add(3);

    Set<Integer> set2 = new HashSet<>();
    set2.add(1);
    set2.add(2);
    set2.add(3);
    set2.add(4);

    boolean result=set1.containsAll(set2);
    boolean actual=SubSetCheck.isSubset(set1,set2);

        Assertions.assertEquals(result,actual,"The set 2 contains element of set 1");
}
}