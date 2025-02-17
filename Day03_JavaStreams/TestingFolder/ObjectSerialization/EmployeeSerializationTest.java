
package Day03_JavaStreams.ProblemStatement.ObjectSerialization;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeSerializationTest {

    @Test
    public void testSerializationAndDeserialization() {
        // Step 1: Create some employee objects
        Employee e1 = new Employee(101, "Alice", "HR", 50000);
        Employee e2 = new Employee(102, "Bob", "IT", 70000);
        Employee e3 = new Employee(103, "Charlie", "Finance", 60000);

        // Add employees to a list
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        // Step 2: Serialize the list of employees to a file
        String filename = "src/test/resources/employees.ser";
        EmployeeSerialization.serializeEmployees(employees, filename);

        // Step 3: Deserialize the list of employees from the file
        List<Employee> deserializedEmployees = EmployeeSerialization.deserializeEmployees(filename);

        // Step 4: Assertions to verify that the deserialized employees match the original ones
        assertNotNull(deserializedEmployees);
        assertEquals(3, deserializedEmployees.size());

        // Check that the deserialized employees match the original employees
        Employee deserializedE1 = deserializedEmployees.get(0);
        Employee deserializedE2 = deserializedEmployees.get(1);
        Employee deserializedE3 = deserializedEmployees.get(2);

        assertEquals(e1.getId(), deserializedE1.getId());
        assertEquals(e1.getName(), deserializedE1.getName());
        assertEquals(e1.getDepartment(), deserializedE1.getDepartment());
        assertEquals(e1.getSalary(), deserializedE1.getSalary());

        assertEquals(e2.getId(), deserializedE2.getId());
        assertEquals(e2.getName(), deserializedE2.getName());
        assertEquals(e2.getDepartment(), deserializedE2.getDepartment());
        assertEquals(e2.getSalary(), deserializedE2.getSalary());

        assertEquals(e3.getId(), deserializedE3.getId());
        assertEquals(e3.getName(), deserializedE3.getName());
        assertEquals(e3.getDepartment(), deserializedE3.getDepartment());
        assertEquals(e3.getSalary(), deserializedE3.getSalary());
    }

    @Test
    public void testFileNotFoundOnDeserialization() {
        // Test deserialization from a non-existent file
        String invalidFilePath = "src/test/resources/non_existent_file.ser";
        List<Employee> deserializedEmployees = EmployeeSerialization.deserializeEmployees(invalidFilePath);

        // Assert that no employees are returned if the file doesn't exist
        assertNull(deserializedEmployees);
    }

    @Test
    public void testEmptySerialization() {
        // Test serialization and deserialization with an empty list of employees
        List<Employee> emptyList = new ArrayList<>();
        String filename = "src/test/resources/empty_employees.ser";

        // Serialize the empty list
        EmployeeSerialization.serializeEmployees(emptyList, filename);

        // Deserialize the empty list
        List<Employee> deserializedEmployees = EmployeeSerialization.deserializeEmployees(filename);

        // Assert that the deserialized list is empty
        assertNotNull(deserializedEmployees);
        assertTrue(deserializedEmployees.isEmpty());
    }
}
