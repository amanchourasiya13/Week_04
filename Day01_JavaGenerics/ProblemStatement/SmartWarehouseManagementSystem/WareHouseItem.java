package Day01_JavaGenerics.ProblemStatement.SmartWarehouseManagementSystem;

public  abstract class WareHouseItem  {
String name;
double price;
public WareHouseItem(String name,double price){
    this.name=name;
    this.price=price;
}
public abstract  void displayInfo();
}
