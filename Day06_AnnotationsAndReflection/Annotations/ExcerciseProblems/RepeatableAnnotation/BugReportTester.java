package Day06_AnnotationsAndReflection.Annotations.ExcerciseProblems.RepeatableAnnotation;

import java.lang.reflect.Method;

public class BugReportTester {

    public static void main(String[] args) {
        try {
            // Get the method with the bug report annotations
            Method method = BugTracking.class.getMethod("processUserData");

            // Retrieve all @BugReport annotations from the method
            BugReports bugReports = method.getAnnotation(BugReports.class);

            // Print out each bug description
            for (BugReport bugReport : bugReports.value()) {
                System.out.println("Bug description: " + bugReport.description());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

