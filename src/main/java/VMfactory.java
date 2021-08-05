

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VMfactory {
    public void Hello(){
        System.out.println("                | If a product count is 0 |");
    }

    public static void main(String[] args) {
        VMachine VM= new VMachine();

        Product Coke = new Product("Coke",1.35,2);
        Product Gum = new Product("Gum",2.25,4);
        Product Chocolate = new Product("Chocolate",3.5,0);
        List<Product> dir = new ArrayList<Product>();
        dir.add(Coke);
        dir.add(Gum);
        dir.add(Chocolate);
        VM.setDirectory(dir);
        VM.setOn(false);


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|    | Display Line 1          | Display Line 2           |                        |");
        System.out.println("------------------------------------------------------------------------------------");
        VM.statusCheck();



        //System.out.println(VM.isOn());
        VM.powerButton();//      press the power button

        VM.statusCheck();


        Scanner s= new Scanner("product"); // Press select a product
        String str= s.next();
        if(VM.isOn()&& !VM.isSoldOut()&&str.equals("product")){
            //System.out.println(VM.getCurrProduct().getProductName());
            Product p=VM.getDirectory().get(VM.getIdx());
            VM.printProduct(p);

        }
        s = new Scanner("up"); // Press up button
        str= s.next();
        int idx=VM.getIdx();
        if(str.equals("up")){

            if(idx==0){
                idx=VM.getDirectory().size()-1;
            }else{
                idx--;
            }
        }else if(str.equals("down")){
            if(idx==VM.getDirectory().size()-1){
                idx=0;
            }else{
                idx++;
            }
        }
        VM.setIdx(idx);

        Product p=VM.getDirectory().get(idx);
        String message ="| ON | Welcome                 | "+p.getProductName()+"$"+p.getPrice();
        if(p.getQuantity()==0){
            message+="Sold Out";
            System.out.println(message+"    | If a product count is 0|");
        }else {
            System.out.println(message + "    | If up/down was pressed |");
        }
        s = new Scanner("down"); // Press up button
        str= s.next();

        if(str.equals("up")){

            if(idx==0){
                idx=VM.getDirectory().size()-1;
            }else{
                idx--;
            }
        }else if(str.equals("down")){
            if(idx==VM.getDirectory().size()-1){
                idx=0;
            }else{
                idx++;
            }
        }
        VM.setIdx(idx);

        p=VM.getDirectory().get(idx);
        message ="| ON | Welcome                 | "+p.getProductName()+"$"+p.getPrice();
        if(p.getQuantity()==0){
            message+="Sold Out";
            System.out.println(message+"                | If a product count is 0|");
        }else{
            System.out.println(message+"                | If up/down was pressed |");
        }

        VM.setPayment(false);

        if(VM.isPayment()){
            p=VM.getDirectory().get(VM.getIdx());
            VM.setTotalSale(VM.getTotalSale()+p.getPrice());
            p.setQuantity(p.getQuantity()-1);
            System.out.println("| ON |Press any key to continue| Payment Failed           |  If payment succeed     |");
        }else{

            System.out.println("| ON |Press any key to continue| Please take your product |  If payment failed     |");

        }

        System.out.println("------------------------------------------------------------------------------------");
    }





}
