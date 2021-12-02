package com.BankManagement;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester_BankManagement {
    public static ArrayList<Block> blocks = new ArrayList<Block>(100);

    public static void main(String[] args) {
        String name , ifscCode , branch;
        int acno;



        Scanner scr = new Scanner(System.in);
        System.out.println("Welcome");


        //First Test Block

        blocks.add(0,new Block("0","Test","0000","branch",100100100));
        //modify this later  ; for test purpose we are creating 5 accounts
        for(int i=1;i<3;i++){

            System.out.println("Please enter user details");
            System.out.print("Name : ");
            name=scr.nextLine();
            System.out.print("IFSC Code : ");
            ifscCode=scr.nextLine();
            System.out.print("Branch : ");
            branch=scr.nextLine();
            System.out.print("Account no : ");
            acno=scr.nextInt();
            String prevHash = blocks.get(i-1).getHash();
            if(BlockValidator.blockverifier()) {
                blocks.add(i, new Block(prevHash, name, ifscCode, branch, acno));
                System.out.println("Account Created , Your Hash is :" + blocks.get(i).getHash());
            }
            else{
                System.out.println("There is some problem in block chain ");
            }
            //For clearing input buffer
            scr.nextLine();
            System.out.println();

        }


    }
}
