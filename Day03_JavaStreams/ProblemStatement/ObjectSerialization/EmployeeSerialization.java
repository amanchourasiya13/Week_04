package Day03_JavaStreams.ProblemStatement.ObjectSerialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization{

    // Method to serialize a list of employees to a file
    public static void serializeEmployees(List<Employee> employees, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);  // Write the list of employees to the file
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to deserialize the list of employees from a file
    public static List<Employee> deserializeEmployees(String filename) {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            employees = (List<Employee>) ois.readObject();  // Read the list of employees from the file
            System.out.println("Employees deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void main(String[] args) {
        // Create some employee objects
        Employee e1 = new Employee(101, "Alice", "HR", 50000);
        Employee e2 = new Employee(102, "Bob", "IT", 70000);
        Employee e3 = new Employee(103, "Charlie", "Finance", 60000);

        // Add employees to a list
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        // Serialize the list of employees
        String filename = "employees.ser";
        serializeEmployees(employees, filename);

        // Deserialize the list of employees
        List<Employee> deserializedEmployees = deserializeEmployees(filename);

        // Display the deserialized employees
        if (deserializedEmployees != null) {
            System.out.println("\nDeserialized Employee List:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        }
    }
}