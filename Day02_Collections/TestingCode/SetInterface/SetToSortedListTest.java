package Day02_Collections.SetInterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetToSortedListTest {
    @Test
public void check(){
    Set<Integer> set = new HashSet<>();
    set.add(5);
    set.add(3);
    set.add(9);
    set.add(1);

    List<Integer>acutal= SetToSortedList.convertSetToSortedList(set);
    Assertions.assertEquals(List.of(1,3,5,9),acutal,"The list should be in Ascending Order. ");

}
}