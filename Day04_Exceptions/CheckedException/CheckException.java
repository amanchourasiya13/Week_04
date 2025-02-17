package Day04_Exceptions.CheckedException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class CheckException{
    public static void checKException(String filePath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch(FileNotFoundException e){
            System.out.println("File not found..- "+e.getMessage());
        } catch (IOException e) {
            System.out.println("An IOException occurred: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
       checKException("src/main/java/Day04_Exceptions/CheckedException/info.txt");
    }
}

