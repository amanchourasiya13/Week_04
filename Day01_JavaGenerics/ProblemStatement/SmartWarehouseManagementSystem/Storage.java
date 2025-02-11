package Day01_JavaGenerics.ProblemStatement.SmartWarehouseManagementSystem;

import java.util.ArrayList;
import java.util.List;

class Storage<T extends WareHouseItem> {
   private List<T> items;
   public Storage(){
       this.items=new ArrayList<>();
   }
   //add item
    public void addItem(T item){
       items.add(item);
    }

    //get item
//    public T getItem(int index){
//       return items.get(index);
//    }

    //display all items
    public void displayAllItems(){
        for(T item :items){
            item.displayInfo();
        }
    }
    public List<T> getItems() {
        return items;
       }
}
