package Day03_JavaStreams.ProblemStatement.BufferedStreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class BufferStreams {
    public static void BufferedExample(String input,String output){
        try(BufferedInputStream bis=new BufferedInputStream(new FileInputStream(input));
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(output))){
            byte[]buffer=new byte[4096];
            int bytesRead;
            while((bytesRead=bis.read(buffer))!=-1){
                bos.write(buffer,0,bytesRead);
            }
            System.out.println("File copied successfully using Bufferd Method.");

            bis.close();
            bos.close();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found-- "+e.getMessage());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void InputOutputStreamExample(String fileInputPath,String fileOutputPath){

        try (FileInputStream fis = new FileInputStream(fileInputPath);

             FileOutputStream fos = new FileOutputStream(fileOutputPath)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write((byteData));
            }
            System.out.println("File Copied Successfully Using UnBuffered Method.");
            fis.close();
            fos.close();
        } catch(FileNotFoundException e){
            System.out.println("File not found. --" +e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
        String input="src/main/java/Day03_JavaStreams/ProblemStatement/BufferedStreams/100MBInput.txt";
        String Output="src/main/java/Day03_JavaStreams/ProblemStatement/BufferedStreams/100MBOutput.txt";
        long start=System.nanoTime();
        BufferedExample(input,Output);
        long end=System.nanoTime();
        long timeBuffer=(end-start);
        System.out.println("Time taken by buffered: "+timeBuffer+" ns.");

        start=System.nanoTime();
        InputOutputStreamExample(input,Output);
        end=System.nanoTime();
        long timeUnBuffer=(end-start);
        System.out.println("Time taken by unBuffer: "+timeUnBuffer+" ns.");

        if(timeBuffer<timeUnBuffer){
            System.out.println("Buffer is faster.");
        }
        else if (timeBuffer>timeUnBuffer){
            System.out.println("UnBuffer is Faster.");
        }
        else System.out.println("Both are Equal.");
    }
}
