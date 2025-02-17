package Day06_AnnotationsAndReflection.Reflection.BasicLevelProblems.DynamicallyCreateObjects;

import java.lang.reflect.Constructor;

public class Student {
    private String name;
    private int age;

    // Constructor to initialize the Student object
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display student details
    public void display() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        try {
            // Use the fully qualified class name including the package path
            Class<?> studentClass = Class.forName("Day06_AnnotationsAndReflection.Reflection.BasicLevelProblems.DynamicallyCreateObjects.Student");

            // Get the constructor of the class (Student(String, int))
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

            // Dynamically create an instance of Student
            Object studentObject = constructor.newInstance("John Doe", 20);

            // Cast the object to Student type and call the display method
            Student student = (Student) studentObject;
            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
