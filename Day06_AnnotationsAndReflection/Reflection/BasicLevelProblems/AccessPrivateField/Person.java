package Day06_AnnotationsAndReflection.Reflection.BasicLevelProblems.AccessPrivateField;

import java.lang.reflect.Field;

public class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the Person class
            Person person = new Person(25);

            // Access the private field 'age' using reflection
            Field ageField = Person.class.getDeclaredField("age");

            // Make the private field accessible
            ageField.setAccessible(true);

            // Retrieve the value of the private field 'age'
            int ageValue = (int) ageField.get(person);
            System.out.println("Current age: " + ageValue);

            // Modify the value of the private field 'age'
            ageField.set(person, 30);
            System.out.println("Modified age: " + (int) ageField.get(person));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
