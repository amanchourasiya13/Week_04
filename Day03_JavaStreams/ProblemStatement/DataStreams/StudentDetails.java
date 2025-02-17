package Day03_JavaStreams.ProblemStatement.DataStreams;

//import Day03_JavaStreams.ProblemStatement.DataStreams.Student;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class StudentDetails {

    public static void main(String[] args) {
        String filePath = "studentDetails.dat";  // Path for the binary file
        // Store student details in the binary file
        storeStudentDetails(filePath);

        // Retrieve and display the student details from the binary file
        retrieveStudentDetails(filePath);
    }

    // Method to store student details in a binary file
    public static void storeStudentDetails(String filePath) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            // Creating a Student object
            Day03_JavaStreams.ProblemStatement.DataStreams.Student student1 = new Day03_JavaStreams.ProblemStatement.DataStreams.Student(101, "Aman", 8.88);
            Day03_JavaStreams.ProblemStatement.DataStreams.Student student2 = new Day03_JavaStreams.ProblemStatement.DataStreams.Student(102, "Rohan", 7.88);

            // Writing student details to the binary file
            dos.writeInt(student1.rollNumber);
            dos.writeUTF(student1.name);  // writeUTF is used for Strings
            dos.writeDouble(student1.gpa);

            dos.writeInt(student2.rollNumber);
            dos.writeUTF(student2.name);
            dos.writeDouble(student2.gpa);

            System.out.println("Student details have been written to the file.");
        } catch (IOException e) {
            System.out.println("Error while storing student details: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to retrieve and display student details from the binary file
    public static void retrieveStudentDetails(String filePath) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            // Reading and displaying student details from the binary file
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();  // readUTF is used to read String
                double gpa = dis.readDouble();

                Day03_JavaStreams.ProblemStatement.DataStreams.Student student = new Student(rollNumber, name, gpa);
                System.out.println(student);
            }
        } catch (IOException e) {
            System.out.println("Error while retrieving student details: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
