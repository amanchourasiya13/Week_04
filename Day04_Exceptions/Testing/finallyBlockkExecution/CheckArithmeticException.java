package Day04_Exceptions.finallyBlockkExecution;

import java.util.Scanner;
public class CheckArithmeticException {
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
        }catch(ArithmeticException e){
            System.out.println("Arithmetic Exception Caught: "+e.getMessage());
        }finally{
            System.out.println("Operation Completed");
        }
    }
    public static void main(String[] args) {
      uncheckException();
    }
}