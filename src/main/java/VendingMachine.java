import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private boolean on;

    private Inventory<Item> itemInventory=new Inventory<Item>();
    private Inventory<Item> soldInventory=new Inventory<>();
    private List<Item> itemList=new ArrayList<>();
    private int idx;
    private boolean payment;
    private double totalSales;


    public void powerButton() {
        on = !on;
    }

    public boolean isOn() {
        return on;
    }



    public void twoLineDisplay(String message1,String message2){
        System.out.println("***********************************************");
        System.out.println(message1);
        System.out.println("***********************************************");
        System.out.println(message2);
    }
    public void VMStatusDisplay(){
        if(isOn()){
            if(itemInventory.soldOut()){
                twoLineDisplay("Welcome!","Sold Out");
            }else{
                twoLineDisplay("Welcome!","Select a product");
            }
        }

    }

    public void itemDisplay(){
        String message;
        if(itemList!=null){
            if(idx>=itemList.size()){
                idx=0;
            }
            Item currentItem=itemList.get(idx);
            message= "Item: "+currentItem.getName()+" Price: "+currentItem.getPrice();
            if(!itemInventory.hasItem(currentItem)){
                message+="Sold Out";
            }
            twoLineDisplay("Welcome",message);
        }
        twoLineDisplay("Welcome","Sold Out");
    }
    public void downButton(int idx){
        if(itemList!=null){
            if(idx==0){
                idx=itemList.size()-1;
            }else{
                idx--;
            }
        }
    }
    public void upButton(int idx){
        if(itemList!=null){
            if(idx==itemList.size()-1){
                idx=0;
            }else{
                idx++;
            }
        }
    }

    public void reset(){

        idx=0;
        payment=false;
        VMStatusDisplay();


    }

    public void transaction(Item item, boolean payment){
        if(itemInventory.hasItem(item)){
            if(payment){
                itemInventory.deduct(item);
                totalSales+=item.getPrice();
                soldInventory.add(item);
                twoLineDisplay("Press any key to continue","Please take your product");

            }else{
                twoLineDisplay("Press any key to continue","Payment Failed");
            }
        }
    }




}
