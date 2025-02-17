package Day06_AnnotationsAndReflection.Annotations.AdvanceLevelProblems.RoleBasedAccessControlWith_RoleAllowed;

import java.lang.reflect.Method;

public class RoleBasedAccessControl {

    // Simulate a user with a role
    private String currentUserRole;

    public RoleBasedAccessControl(String role) {
        this.currentUserRole = role;
    }

    public void checkAccess(Method method) {
        // Check if the method has the @RoleAllowed annotation
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            String requiredRole = roleAllowed.value();

            if (!requiredRole.equals(currentUserRole)) {
                System.out.println("Access Denied! Only " + requiredRole + " can access this.");
                return;
            }
        }

        try {
            // Proceed with method invocation if access is allowed
            method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Test method that only allows ADMIN access
    @RoleAllowed("ADMIN")
    public void adminMethod() {
        System.out.println("Access granted to the ADMIN method.");
    }

    // A method without role restriction for comparison
    public void publicMethod() {
        System.out.println("Access granted to the public method.");
    }

    public static void main(String[] args) {
        // Simulate two users: one with ADMIN and one with USER role
        RoleBasedAccessControl adminUser = new RoleBasedAccessControl("ADMIN");
        RoleBasedAccessControl regularUser = new RoleBasedAccessControl("USER");

        // Create Method references
        try {
            Method adminMethod = RoleBasedAccessControl.class.getMethod("adminMethod");
            Method publicMethod = RoleBasedAccessControl.class.getMethod("publicMethod");

            // Test with an admin user
            System.out.println("Admin trying to access the admin method:");
            adminUser.checkAccess(adminMethod);  // Should succeed

            // Test with a regular user
            System.out.println("\nRegular user trying to access the admin method:");
            regularUser.checkAccess(adminMethod);  // Should be denied

            // Test with the public method
            System.out.println("\nAdmin trying to access the public method:");
            adminUser.checkAccess(publicMethod);  // Should succeed

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

