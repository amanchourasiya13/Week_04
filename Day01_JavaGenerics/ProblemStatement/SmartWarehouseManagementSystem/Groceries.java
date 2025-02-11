package Day01_JavaGenerics.ProblemStatement.SmartWarehouseManagementSystem;

public class Groceries extends  WareHouseItem{
    String expirationDate;
    public Groceries(String name,double price,String expirationDate){
        super(name,price);
        this.expirationDate=expirationDate;
    }

    @Override
    public void displayInfo() {
        System.out.println("Groceries Item: "+name+" price: "+price+" expiryDate: "+expirationDate);
    }
}
