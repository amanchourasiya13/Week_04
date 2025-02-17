package Day03_JavaStreams.ProblemStatement.FileHandling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileINPUT_OUTPUT_Stream {
    public static void InputOutputStreamExample(String fileInputPath,String fileOutputPath){

        try (FileInputStream fis = new FileInputStream(fileInputPath);

             FileOutputStream fos = new FileOutputStream(fileOutputPath)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write((byteData));
            }
            System.out.println("File Copied Successfully.");
        } catch(FileNotFoundException e){
            System.out.println("File not found. --" +e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
        String fileInputPath = "src/test/java/Day03_JavaStreams/ProblemStatement/FileHandling/InputFile.txt"; //input file path
        String fileOutputPath="src/test/java/Day03_JavaStreams/ProblemStatement/FileHandling/OutputFile.txt";// output file path.
        InputOutputStreamExample(fileInputPath,fileOutputPath);//call method.
    }
}