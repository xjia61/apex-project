import javax.xml.crypto.Data;
import java.util.Random;

public class paymentCallBack implements CallBack{
    private long account;
    private Data data;
    private double money;



    @Override
    public boolean execute(){
        int num = (int)Math.random()*10;
        if(num%2==0){
            System.out.println("Payment Success");
            return true;
        }else{
            System.out.println("Payment failure");
            return false;
        }

    }

}
