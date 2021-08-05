import sun.misc.VM;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class VMachine {
    private boolean on;
    private List<Product> directory;
    private Map<String, Integer> soldList;
    private Product currProduct;
    private  int idx;



    private double totalSale;
    private boolean payment;

    public List<Product> getDirectory() {
        return directory;
    }
    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
    public void setDirectory(List<Product> directory) {
        this.directory = directory;
    }
    public void setDirectory(Product product) {
        this.directory.add(product);
    }

    public Map<String, Integer> getSoldList() {
        return soldList;
    }

    public void setSoldList(Map<String, Integer> soldList) {
        this.soldList = soldList;
    }

    public Product getCurrProduct() {
        if(currProduct==null&&!directory.isEmpty()){
            currProduct=directory.get(0);
        }
        return currProduct;
    }

    public void setCurrProduct(Product currProduct) {
        this.currProduct = currProduct;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }



    public void setOn(boolean on) {
        this.on = on;
    }
    public void powerButton() {
        on = !on;
    }

    public boolean isOn() {
        return on;
    }
    public boolean isSoldOut(){
        if(!isOn()) return false;

        if(directory.isEmpty()) return false;
        for(Product p:directory){
            if(p.getQuantity()!=0) return false;
        }
        return true;
    }

    public void statusCheck(){
        if(isOn()){
            if(isSoldOut()){
                System.out.println("| ON | Welcome                 | Sold Out                 | If has no inventory    |");

            }else{
                System.out.println("| ON | Welcome                 | Select a product         | If has inventory       |");

            }
        }else{
            System.out.println("| OFF| empty                   | empty                    |                        |");
        }
    }

    public void printProduct(Product p){
        String message ="| ON | Welcome                 | "+p.getProductName()+"$"+p.getPrice();
        if(p.getQuantity()==0){
            message+="Sold Out";
            System.out.println(message+"                | If a product count is 0|");

        }else{
            System.out.println(message+"                | If up/down was pressed |");
        }

    }



}
