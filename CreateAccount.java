package com.BankManagement;

import static com.BankManagement.Tester_BankManagement.blocks;

public class CreateAccount  {



   // String name, String ifscCode, String branch, int acno, String email, String password
    public boolean userReg(String name, String ifscCode, String branch, int acno, long depositAmount, String email, String password){
        int i = blocks.size();
        String prevHash = blocks.get(i-1).getHash();
        //first check the blockchain if there is some tampering of data then proceed
        if(BlockValidator.blockverifier()) {

            blocks.add(i, new Block(prevHash, name, ifscCode, branch,depositAmount,email,password, acno));
            System.out.println("Account Created , Your Hash is :" + blocks.get(i).getHash());
            System.out.println("Previous Hash :"+blocks.get(i).getPreviousHash());
            System.out.println("Caluclated hash :"+blocks.get(i).calculateHash());
            return true;
        }
        else{
           return false;
        }



    }

}
