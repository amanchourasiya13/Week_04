package Day03_JavaStreams.ProblemStatement.ReadingFromConsole;

import java.io.*;

public class ReadingConsole {
    public static void ReadingDataInput(String path){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer=null;
       try{
           System.out.println("Enter Your Name: ");
           String name=br.readLine();

           System.out.println("Enter Your Age: ");
           String age=br.readLine();

           System.out.println("Enter Your Fav Language: ");
           String fav=br.readLine();

           writer=new FileWriter(path,true);
           // Write the data to file
           writer.write("Name: " + name + "\n");
           writer.write("Age: " + age + "\n");
           writer.write("Favorite Programming Language: " + fav + "\n");
           writer.write("-------------------------------\n");

           System.out.println("Information saved successfully to file.");

           br.close();
           writer.close();
       } catch(FileNotFoundException a){
           System.out.println("File not found to save data. -- "+a.getMessage());
       }
       catch (IOException e){
           e.printStackTrace();
       }
       }
    public static void main(String[] args) {
        ReadingDataInput("src/main/java/Day03_JavaStreams/ProblemStatement/ReadingFromConsole/Data.txt");
    }
}
