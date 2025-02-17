package Day04_Exceptions.UncheckedException;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Arithmetic_InputMismatchedException {
    public static void uncheckException(){
        Scanner sc=new Scanner(System.in);
        int a=0,b=0;
        try{
            System.out.print("Enter first value: ");
            a=sc.nextInt();
            System.out.print("Enter second value: ");
            b=sc.nextInt();
            int result=a/b;
            System.out.println("Result: "+result);
        }catch(InputMismatchException e){
            System.out.println("Input Mismatch Exception Caught. Please enter only numeric values."+e.getMessage());
        }catch(ArithmeticException e){
            System.out.println("Arithmetic Exception Caught: "+e.getMessage());
        }
    }
    public static void main(String[] args) {
      uncheckException();
    }
}
