package Day04_Exceptions.throwVsthrowsException;

public class ExceptionPropagation {

    public static double calculateInterest(double amount,double rate,int years)throws  IllegalArgumentException{
        if(amount<0 || rate<0 ){
            throw  new IllegalArgumentException("Invalid Input: Amount and rate must be positive");
        }
        return(amount*rate*years)/100;
    }
    public static void main(String[] args) {
        try{
             double amount=1000.00;
             double rate=5;
             int years=3;
             double calculate=calculateInterest(amount,rate,years);
            System.out.println("Calculate Interest: "+calculate);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}

