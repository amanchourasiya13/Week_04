package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    // Initialize the DatabaseConnection object before each test
    @BeforeEach
    public void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();  // Connect to the database before each test
    }

    // Clean up the database connection after each test
    @AfterEach
    public void tearDown() {
        dbConnection.disconnect();  // Disconnect after each test
    }

    // Test to verify that the database connection is established
    @Test
    public void testConnection() {
        // Verify that the database is connected
        assertTrue(dbConnection.isConnected(), "Database should be connected.");
    }

    // Test to verify that the database connection is closed after tearDown
    @Test
    public void testDisconnection() {
        // After tearDown is called, the connection should be closed
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Database should be disconnected.");
    }
}
