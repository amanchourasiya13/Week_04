package Day03_JavaStreams.ProblemStatement.ByteArrayStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class ImageByteArrayConversionTest {

    private static final String INPUT_IMAGE_PATH ="src/main/java/Day03_JavaStreams/ProblemStatement/ByteArrayStream/ImageText.jpeg";
    private static final String OUTPUT_IMAGE_PATH ="output_image.jpg";

    // Setup: This method runs before each test case
    @BeforeEach
    public void setUp() throws IOException {
        // Create a dummy input image for testing (we can use any small image for testing purposes)
        File inputFile = new File(INPUT_IMAGE_PATH);
        if (!inputFile.exists()) {
            inputFile.createNewFile();
        }
    }

    // Cleanup: This method runs after each test case
    @AfterEach
    public void tearDown() {
        // Delete the output image after the test
        File outputFile = new File(OUTPUT_IMAGE_PATH);
        if (outputFile.exists()) {
            outputFile.delete();
        }
    }

    // Test the image conversion and comparison
    @Test
    public void testImageByteArrayConversion() {
        // Convert the image to byte array and then write it back to a new image file
        ImageByteArrayConversion.convertImageToByteArray(INPUT_IMAGE_PATH, OUTPUT_IMAGE_PATH);

        // Check if the new image file is created
        File outputFile = new File(OUTPUT_IMAGE_PATH);
        assertTrue(outputFile.exists(), "The output image should exist.");

        // Verify that the original and new images are identical
        boolean isIdentical = ImageByteArrayConversion.compareFiles(INPUT_IMAGE_PATH, OUTPUT_IMAGE_PATH);
        assertTrue(isIdentical, "The new image should be identical to the original.");
    }

    // Edge case: Test with a non-existing input image file
    @Test
    public void testNonExistingInputImage() {
        String invalidInputPath = "src/test/resources/nonExistingImage.jpeg";
        ImageByteArrayConversion.convertImageToByteArray(invalidInputPath, OUTPUT_IMAGE_PATH);

        // The file shouldn't be created as the input image doesn't exist
        File outputFile = new File(OUTPUT_IMAGE_PATH);
        assertFalse(outputFile.exists(), "The output image should not be created for non-existing input.");
    }
}
