import java.util.HashMap;
import java.util.Map;

public class Inventory <T>{
    private Map<T,Integer> inventory= new HashMap<T,Integer>();

    public int getQuantity(T item){
        Integer value=inventory.get(item);
        return value==null?0:value;
    }
    public void add(T item){
        int count =inventory.get(item);
        inventory.put(item,count++);
    }

    public void deduct(T item){
        int count=inventory.get(item);
        inventory.put(item,count--);
    }
    public boolean hasItem(T item){
        return inventory.get(item)>0;
    }
    public void clear(){
        inventory.clear();
    }
    public void put(T item, int quantity){
        inventory.put(item,quantity);
    }
    public boolean soldOut(){
        for(T item: inventory.keySet()){
            if(hasItem(item)){
                return false;
            }
        }
        return true;
    }
}
