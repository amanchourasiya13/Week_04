package Day04_Exceptions.CustomException;

import java.util.Scanner;
class CustomException extends  Exception{
    public CustomException(String message){
        super(message);
    }
}
public class CheckAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            validateAge(age);
            System.out.println("Access Granted..");
        } catch (CustomException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
            return ;
        }
    }

    public static void validateAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age must be 18 or older");
        }
    }
}