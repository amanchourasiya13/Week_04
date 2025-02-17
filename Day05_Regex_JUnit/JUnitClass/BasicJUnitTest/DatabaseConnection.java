package Day05_Regex_JUnit.JUnit.BasicJUnitTest;


public class DatabaseConnection {

    private boolean connected;

    // Method to connect to the database
    public void connect() {
        connected = true;
        System.out.println("Connected to the database.");
    }

    // Method to disconnect from the database
    public void disconnect() {
        connected = false;
        System.out.println("Disconnected from the database.");
    }

    // Getter method to check if connected
    public boolean isConnected() {
        return connected;
    }

    // Main method for manual testing
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();

        // Testing the connect and disconnect methods
        System.out.println("Starting manual tests...\n");

        // Connect to the database
        dbConnection.connect();  // Expected: Connected to the database.
        System.out.println("Is connected? " + dbConnection.isConnected() + "\n");

        // Disconnect from the database
        dbConnection.disconnect();  // Expected: Disconnected from the database.
        System.out.println("Is connected? " + dbConnection.isConnected() + "\n");
    }
}

