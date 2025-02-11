package Day01_JavaGenerics.ProblemStatement.SmartWarehouseManagementSystem;

public class Furniture extends  WareHouseItem{
    String material;
    public Furniture(String name,double price,String material){
        super(name,price);
        this.material=material;
    }

    @Override
    public void displayInfo() {
        System.out.println("Furniture Item: "+name+" price: "+price+" material: "+material);
    }
}
