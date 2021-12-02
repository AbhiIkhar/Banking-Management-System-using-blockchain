package com.BankManagement;
public class BlockValidator{

    //This will keep checking of any of the block is hacked in the chain

    //we have to check if hash of i-1th block is equal to the hash
    //call this method when each new bloc is created
    public static boolean blockverifier(){


        for(int i=1;i<Tester_BankManagement.blocks.size();i++){
            if(Tester_BankManagement.blocks.get(i).getPreviousHash().equals(Tester_BankManagement.blocks.get(i-1).getHash())){
                continue;
            }
            else {
                return false;
            }


        }
        return true;


    }
}
