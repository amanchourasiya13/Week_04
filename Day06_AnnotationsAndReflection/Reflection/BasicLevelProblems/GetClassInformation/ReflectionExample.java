package Day06_AnnotationsAndReflection.Reflection.BasicLevelProblems.GetClassInformation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionExample {

    public static void main(String[] args) {
        // Step 1: Accept class name as input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a class name (fully qualified, e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            // Step 2: Load the class using Reflection
            Class<?> clazz = Class.forName(className);

            // Display class name
            System.out.println("\nClass: " + clazz.getName());

            // Step 3: Get and display all methods of the class
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("  " + method);
            }

            // Step 4: Get and display all fields of the class
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("  " + field);
            }

            // Step 5: Get and display all constructors of the class
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
