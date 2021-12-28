//import com.proj.Bill;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class TesterBankMangement {
    static Scanner scr = new Scanner(System.in);

    public static ArrayList<Block> blocks = new ArrayList<Block>(100);

    public static void main(String[] args) {
        String name , ifscCode , branch,email,password;
        int acno;
        long depositAmount;
     //First Test Block
       blocks.add(0,new Block("0","Test","0000","branch",10,"test@gmail.com","testpass123",100100100));


   new LoginFrame().setVisible(true);
 
   
        
  

    }


}
