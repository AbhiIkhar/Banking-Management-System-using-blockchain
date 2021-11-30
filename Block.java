package com.BankManagement;

public class Block {
    //Defining block and its elements

    private String previousHash,hash,custName,ifscCode,branchName;
    private int accountNumber;
    private long timestamp;

    public Block(String previousHash,String custName,String ifscCode,String branchName,int accountNumber){
        this.previousHash=previousHash;
        this.custName=custName;
        this.ifscCode=ifscCode;
        this.branchName=branchName;
        this.accountNumber=accountNumber;
        this.hash = calculateHash();

    }


    public String calculateHash(){
        //calculating the hashCode using SHA-256

        String data = custName+ifscCode+branchName+Integer.toString(accountNumber);
        String calculatedhash = SHA_256.applySha256(previousHash + Long.toString(timestamp) + data);
        return calculatedhash;


    }

    public String getHash(){
        return this.hash;
    }


}



