package Day04_Exceptions.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Auto_ClosingResources {
    public static void checKException(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String firstLine=reader.readLine();
            if(firstLine!=null){
                System.out.println("First line of the file: "+firstLine);
            }else{
                System.out.println("The file is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: \n "+e.getMessage());
        }
    }
        public static void main (String[] args ){
            checKException("src/main/java/Day04_Exceptions/try_with_resources/info.txt");
        }
    }