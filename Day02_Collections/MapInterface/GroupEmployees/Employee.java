package Day02_Collections.MapInterface.GroupEmployees;

import java.util.Objects;

public  class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }

    // Overriding equals() to compare Employee objects based on name and department
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && department == employee.department;
    }

    // Overriding hashCode() to ensure the hash code is consistent with equals()
    @Override
    public int hashCode() {
        return Objects.hash(name, department);
    }
}