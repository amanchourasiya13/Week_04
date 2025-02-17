package Day02_Collections.MapInterface;

import Day02_Collections.MapInterface.GroupEmployees.GroupEmployees;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class GroupEmployeesTest {

    @Test
    public void testGroupByDepartment() {
        // Arrange: Set up sample employees
        List<Employee> employees = List.of(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR),
                new Employee("David", Department.SALES)
        );

        // Act: Group employees by department
        Map<Department, List<Employee>> groupedByDepartment = GroupEmployees.groupByDepartment(employees);

        // Assert: Verify the grouping is correct
        assertEquals(2, groupedByDepartment.get(Department.HR).size());
        assertTrue(groupedByDepartment.get(Department.HR).contains(new Employee("Alice", Department.HR)));
        assertTrue(groupedByDepartment.get(Department.HR).contains(new Employee("Carol", Department.HR)));

        assertEquals(1, groupedByDepartment.get(Department.IT).size());
        assertTrue(groupedByDepartment.get(Department.IT).contains(new Employee("Bob", Department.IT)));

        assertEquals(1, groupedByDepartment.get(Department.SALES).size());
        assertTrue(groupedByDepartment.get(Department.SALES).contains(new Employee("David", Department.SALES)));
    }
}
