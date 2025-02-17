package Day03_JavaStreams.ProblemStatement.ByteArrayStream;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ImageByteArrayConversion {
    public static void main(String[] args) {
        String inputImagePath = "src/main/java/Day03_JavaStreams/ProblemStatement/ByteArrayStream/ImageText.jpeg";  // Path to the original image
        String outputImagePath = "output_image.jpg"; // Path to the new image

        // Convert image to byte array and then write it back to a new image file
        convertImageToByteArray(inputImagePath, outputImagePath);
    }

    public static void convertImageToByteArray(String inputImagePath, String outputImagePath) {
        try {
            // Step 1: Read the image file into a byte array
            FileInputStream fileInputStream = new FileInputStream(inputImagePath);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            // Read the bytes from the image file and write to the byte array output stream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            // Convert the byteArrayOutputStream to a byte array
            byte[] imageByteArray = byteArrayOutputStream.toByteArray();

            // Step 2: Write the byte array back to a new image file
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageByteArray);
            FileOutputStream fileOutputStream = new FileOutputStream(outputImagePath);

            // Write the bytes to the new image file
            while ((bytesRead = byteArrayInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            // Close streams
            fileInputStream.close();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            fileOutputStream.close();

            System.out.println("Image successfully written to " + outputImagePath);

            // Step 3: Verify that the new image is identical to the original image
            boolean isIdentical = compareFiles(inputImagePath, outputImagePath);
            if (isIdentical) {
                System.out.println("The new image is identical to the original.");
            } else {
                System.out.println("The new image is NOT identical to the original.");
            }

        } catch (IOException e) {
            System.out.println("Error during file handling: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to compare two files byte-by-byte
    public static boolean compareFiles(String file1, String file2) {
        try (FileInputStream file1InputStream = new FileInputStream(file1);
             FileInputStream file2InputStream = new FileInputStream(file2)) {
            int byte1, byte2;
            while ((byte1 = file1InputStream.read()) != -1 &&
                   (byte2 = file2InputStream.read()) != -1) {
                if (byte1 != byte2) {
                    return false; // Files are not identical
                }
            }
            // Check if one file has extra content
            return file1InputStream.read() == -1 && file2InputStream.read() == -1;
        }catch(FileNotFoundException e){
            System.out.println("File Not Found:- "+e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error during file comparison: " + e.getMessage());
            return false;
        }
        return false;
    }
}