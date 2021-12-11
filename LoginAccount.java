package com.BankManagement;

import static com.BankManagement.Tester_BankManagement.blocks;

public class LoginAccount {


    public boolean verifyCredentials(String userEmail,String userPassword){

       for(Block users:blocks){
           //check for email in block
           if(users.getEmail().equals(userEmail)){
               //check for password for that email
              if(users.getPassword().equals(userPassword)){
                  return true;
              }
           }

       }
        return false;
    }




}
