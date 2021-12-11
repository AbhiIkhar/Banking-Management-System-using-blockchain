package com.BankManagement;
import static com.BankManagement.Tester_BankManagement.blocks;
public class Account {
    private String name,address,ifscCode , branch,email,password;
    private long totalBalance;
    private int acno;

    public Account(String name, String ifscCode, String branch, int acno,long totalBalance, String email, String password) {
        this.name = name;
        this.ifscCode = ifscCode;
        this.branch=branch;
        this.totalBalance=totalBalance;
        this.acno=acno;
        this.email=email;
        this.password = password;

    }
    public Account(String email){
       for(Block user:blocks){
           if(user.getEmail().equals(email)){
               //initialise all the instance variables
               this.name = user.getEmail();
               this.ifscCode = user.getIfscCode();
               this.branch = user.getBranchName();
               this.totalBalance = user.getTotalBalance();
               this.acno = user.getAccountNumber();
               this.email = email;
               this.password = user.getPassword();
     }
       }

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public String getBranch() {
        return branch;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(long totalBalance){
        this.totalBalance=totalBalance;
    }

    public int getAcno() {
        return acno;
    }


public boolean withdrawMoney(long amount){
        if(getTotalBalance()-amount>=0){
            setTotalBalance(this.totalBalance-amount);
            return true;
        }
        else{
            return false;
        }

}

public boolean validateRecipient(String ifsc,int ac){
        //Check if user exists in system
    //System.out.println("Inside Validate");
   for(Block user:blocks){
       if(user.getIfscCode().equals(ifsc)){
           if(user.getAccountNumber()==ac){
            return true;
           }
       }


   }
   return false;
}

public boolean transferAmount(String ifscCode,long amountTransfer){
        for(Block user :blocks){
            if(user.getIfscCode().equals(ifscCode)){
                //Add amount transferred into recipient's account
                user.setTotalBalance(user.getTotalBalance()+amountTransfer);
                return true;
            }

        }
        return false;

}


}
