package Day03_JavaStreams.ProblemStatement.DataStreams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StudentDetailsTest {

    private String filePath;

    @BeforeEach
    public void setUp() {
        // Set up a temporary file path for the binary file
        filePath = "test_studentDetails.dat";
        // Delete the file if it already exists to start fresh
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testStoreStudentDetails() {
        // Call method to store student details
        StudentDetails.storeStudentDetails(filePath);

        // Assert that the file exists after storing the details
        File file = new File(filePath);
        assertTrue(file.exists(), "The student details file should be created.");
    }

//    @Test
//    public void testRetrieveStudentDetails() {
//        // First, store student details in the file
//        StudentDetails.storeStudentDetails(filePath);
//
//        // Call method to retrieve student details
//        List<Student> students = StudentDetails.retrieveStudentDetails(filePath);
//        // Assert that we successfully retrieved students
//        assertNotNull(students, "The list of students should not be null.");
//        assertFalse(students.isEmpty(), "The list of students should not be empty.");
//
//        // Optionally, verify the students' data
//        assertEquals(2, students.size(), "There should be 2 students in the list.");
//        assertEquals("Aman", students.get(0).getName(), "The first student's name should be Aman.");
//        assertEquals(101, students.get(0).getRollNumber(), "The first student's roll number should be 101.");
//    }
}
