import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private boolean on;

    private Inventory<Item> itemInventory;
    private Inventory<Item> soldInventory;
    private List<Item> itemList;
    private int idx;
    private double totalSales;

    public VendingMachine(){}
    public VendingMachine(boolean on, Inventory<Item> itemInventory, Inventory<Item> soldInventory, List<Item> itemList, int idx, double totalSales) {
        this.on = on;
        this.itemInventory = itemInventory;
        this.soldInventory = soldInventory;
        this.itemList = itemList;
        this.idx = idx;
        this.totalSales = totalSales;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public Inventory<Item> getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(Inventory<Item> itemInventory) {
        this.itemInventory = itemInventory;
    }

    public Inventory<Item> getSoldInventory() {
        return soldInventory;
    }

    public void setSoldInventory(Inventory<Item> soldInventory) {
        this.soldInventory = soldInventory;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

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
    public void downButton(){
        if(itemList!=null){
            if(idx==0){
                idx=itemList.size()-1;
            }else{
                idx--;
            }
        }
        itemDisplay();
    }
    public void upButton(){
        if(itemList!=null){
            if(idx==itemList.size()-1){
                idx=0;
            }else{
                idx++;
            }
        }
        itemDisplay();

    }

    public void loaded(Item item, int quantity){
        if(itemInventory.hasItem(item)){
            itemInventory.put(item,itemInventory.getQuantity(item)+quantity);
        }else{
            itemInventory.put(item,quantity);
            itemList.add(item);
        }
    }

    public void reset(){

        idx=0;
        VMStatusDisplay();

    }

    public void paymentProcess(Item item){
        if(itemInventory.hasItem(item)){
            paymentCallBack payment=new paymentCallBack();
            boolean result =payment.execute();
            if(result){
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
