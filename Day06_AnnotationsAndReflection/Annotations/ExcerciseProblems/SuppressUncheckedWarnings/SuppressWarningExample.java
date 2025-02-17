package Day06_AnnotationsAndReflection.Annotations.ExcerciseProblems.SuppressUncheckedWarnings;

import java.util.ArrayList;

public class SuppressWarningExample {

    public static void main(String[] args) {
        // Create an ArrayList without generics (this will cause unchecked warnings)
        @SuppressWarnings("unchecked")
        ArrayList list = new ArrayList(); // Unchecked warning will be suppressed here

        // Adding elements to the list
        list.add("Hello");
        list.add(123);
        list.add(45.67);

        // Displaying elements
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
