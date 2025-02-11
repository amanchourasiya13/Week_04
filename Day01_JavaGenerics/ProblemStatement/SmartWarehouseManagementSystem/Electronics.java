package Day01_JavaGenerics.ProblemStatement.SmartWarehouseManagementSystem;

public class Electronics extends WareHouseItem {
    String brand;
    public Electronics(String name,double price,String brand){
super(name,price);
this.brand=brand;
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics Item: "+name+" price: "+price+" brand: "+brand);
    }
}
