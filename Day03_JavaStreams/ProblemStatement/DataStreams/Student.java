package Day03_JavaStreams.ProblemStatement.DataStreams;

public  class Student {
    int rollNumber;
    String name;
    double gpa;

    // Constructor
    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa;
    }
}