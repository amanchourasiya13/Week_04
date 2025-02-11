package Day01_JavaGenerics.ProblemStatement.SmartWarehouseManagementSystem;
import java.util.List;
public class WareHouse {
    public static void displayItems(List<? extends  WareHouseItem>items){
        for(WareHouseItem item:items){
            item.displayInfo();
        }
    }
    public static void main(String[] args) {
Electronics e1=new Electronics("Fridge",40000,"samsung");
Groceries g1=new Groceries("High value Cup",1000,"24Jan2026");
Furniture f1=new Furniture("Chair",1000,"Wood");

Electronics e2=new Electronics("Laptop",50000,"HP");
Groceries g2=new Groceries("Apple",100,"24Jan2026");
Furniture f2=new Furniture("Table",121,"Wood");
//creating a storage for Electronics
        Storage<Electronics>electronic=new Storage<>();
         electronic.addItem(e1);
         electronic.addItem(e2);
//creating a storage for Groceries.
        Storage<Groceries>grocery=new Storage<>();
        grocery.addItem(g1);
        grocery.addItem(g2);
// creating a storage for Furniture.
      Storage<Furniture>furni=new Storage<>();
      furni.addItem(f1);
      furni.addItem(f2);


  //we can display like electronic.displayAllItems(); but we will use wildcard method.
      //Display all items using WildCard Method
        System.out.println("Displaying all items from electronics storage:");
        displayItems(electronic.getItems());

        System.out.println("\nDisplaying all items from groceries storage:");
        displayItems(grocery.getItems());

        System.out.println("\nDisplaying all items from furniture storage:");
        displayItems(furni.getItems());

    }
}
