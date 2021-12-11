package com.BankManagement;

import java.util.Date;

public class Block {
    //Defining block and its elements

    private String previousHash,hash,custName,ifscCode,branchName,email,password;
    private int accountNumber;
    private long timestamp,totalBalance;
    

    public Block(String previousHash,String custName,String ifscCode,String branchName,long totalBalance,String email,String password,int accountNumber){
        this.previousHash=previousHash;
        this.custName=custName;
        this.ifscCode=ifscCode;
        this.branchName=branchName;
        this.totalBalance=totalBalance;
        this.email = email;
        this.password = password;
        this.accountNumber=accountNumber;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();

    }


    public String calculateHash(){
        //calculating the hashCode using SHA-256

        String data = custName+ifscCode+branchName+email+password+Integer.toString(accountNumber);
        String calculatedhash = SHA_256.applySha256(previousHash + Long.toString(timestamp) + data);
        return calculatedhash;


    }

    public String getHash(){
        return this.hash;
    }
    public String getPreviousHash(){
        return this.previousHash;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }

    public String getIfscCode(){
        return this.ifscCode;

    }

    public void setTotalBalance(long totalBalance){
       this.totalBalance=totalBalance;
    }
    public long getTotalBalance(){
        return this.totalBalance;
    }

    public String getBranchName(){
        return this.branchName;
    }



}



