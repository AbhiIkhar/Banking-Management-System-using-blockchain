package com.BankManagement;

import com.proj.Bill;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester_BankManagement {
    static Scanner scr = new Scanner(System.in);

    public static ArrayList<Block> blocks = new ArrayList<Block>(100);

    public static void main(String[] args) {
        String name , ifscCode , branch,email,password;
        int acno;
        long depositAmount;

        System.out.println("Welcome");


        //First Test Block

        blocks.add(0,new Block("0","Test","0000","branch",1000000,"test@gmail.com","testpass123",100100100));
        System.out.println("Hash "+blocks.get(0).getHash());
        System.out.println("Calc hash "+blocks.get(0).calculateHash());

        while(true){
        System.out.println("(1) Login   (2)Create Account");
        int ch = scr.nextInt();


        switch (ch) {
            case 1: { //Login
                scr.nextLine();
                System.out.println("Enter User Email : ");
                String userEmail = scr.nextLine();
                System.out.println("Enter Password : ");
                String userPassword = scr.nextLine();

                LoginAccount loginAccount = new LoginAccount();
                if (loginAccount.verifyCredentials(userEmail, userPassword)) {
                    boolean a=true;
                    System.out.println("Logged in successful");

                    while(a==true){

                    Account accountLogin = new Account(userEmail);

                    System.out.println("Enter : 1. View  Balance 2. Withdraw Money 3. Transfer Amount 4. Display Account Details 5.Logout");
                    int ch2 = scr.nextInt();

                    switch (ch2) {
                        case 1: {
                            System.out.println("Your Balance is : " + accountLogin.getTotalBalance());

                            break;
                        }
                        case 2: {
                            System.out.println("Enter Amount : ");
                            long withdraw1 = scr.nextLong();
                            if (accountLogin.withdrawMoney(withdraw1)) {
                                System.out.println("Successfull");
                            } else {
                                System.out.println("Failed , insufficient funds");
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Enter bank Details of Recipient");
                            scr.nextLine();
                            System.out.println("IFSC CODE : ");
                            String ifsc1 = scr.nextLine();
                            System.out.println("ACCOUNT NUMBER ");
                            int ac1 = scr.nextInt();
                            if (accountLogin.validateRecipient(ifsc1, ac1)) {
                                System.out.println("Enter Amount : ");
                                long amountTransfer = scr.nextLong();
                                if (accountLogin.getTotalBalance() - amountTransfer >= 0) {

                                    if (accountLogin.transferAmount(ifsc1, amountTransfer)) {
                                        //Subtract amount that is transferred from user's account
                                        accountLogin.setTotalBalance(accountLogin.getTotalBalance() - amountTransfer);
                                        System.out.println("Successfully Transferred Money");
                                    } else {
                                        System.out.println("Something went Wrong");
                                    }


                                } else {
                                    System.out.println("You have insufficient funds in your account  ");
                                }

                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Name : " + accountLogin.getName());
                            System.out.println("Account Number : " + accountLogin.getAcno());
                            System.out.println("IFSC Code : " + accountLogin.getIfscCode());
                            System.out.println("Branch : " + accountLogin.getBranch());
                            System.out.println("Balance : " + accountLogin.getTotalBalance());
                            break;
                        }

                        case 5: { //logout
                            a=false;
                            accountLogin=null;
                            break;
                        }


                    }

                }

             } else {
                    System.out.println("Login failed");
                }

                break;

            }
            case 2: { //Account Creation
                scr.nextLine();
                System.out.println("Please enter user details");
                System.out.print("Name : ");
                name = scr.nextLine();
                System.out.print("IFSC Code : ");
                ifscCode = scr.nextLine();
                System.out.print("Branch : ");
                branch = scr.nextLine();
                System.out.print("Account no : ");
                acno = scr.nextInt();
                scr.nextLine();
                System.out.println("Enter Initial Deposit Amount");
                depositAmount = scr.nextLong();
                scr.nextLine();
                System.out.println("Email : ");
                email = scr.nextLine();
                System.out.println("Password : ");
                password = scr.nextLine();


                CreateAccount userAccount = new CreateAccount();
                if (userAccount.userReg(name, ifscCode, branch, acno,depositAmount, email, password)) {
                    System.out.println("User registered Successfully");
                    //Go to Dashboard
                    boolean b =true;
                    Account account = new Account(name, ifscCode, branch, acno, depositAmount, email, password);
                    while(b==true)
                    {
                    System.out.println("Enter : 1. View  Balance 2. Withdraw Money 3. Transfer Amount 4. Display Account Details 5.Logout");
                    int ch1 = scr.nextInt();
                    switch (ch1) {
                        case 1: {
                            System.out.println("Your Balance is : " + account.getTotalBalance());
                            break;
                        }
                        case 2: {
                            System.out.println("Enter Amount : ");
                            long withdraw = scr.nextLong();
                            if (account.withdrawMoney(withdraw)) {
                                System.out.println("Successfull");
                            } else {
                                System.out.println("Failed , insufficient funds");
                            }

                            break;
                        }

                        case 3: {
                            System.out.println("Enter bank Details of Recipient");
                            scr.nextLine();
                            System.out.println("IFSC CODE : ");
                            String ifsc = scr.nextLine();
                            System.out.println("ACCOUNT NUMBER ");
                            int ac = scr.nextInt();
                            System.out.println(ifsc);
                            System.out.println(ac);
                            if (account.validateRecipient(ifsc, ac)) {
                                System.out.println("Enter Amount : ");
                                long amountTransfer = scr.nextLong();
                                if (account.getTotalBalance() - amountTransfer >= 0) {

                                    if (account.transferAmount(ifsc, amountTransfer)) {
                                        //Subtract amount that is transferred from user's account
                                        account.setTotalBalance(account.getTotalBalance() - amountTransfer);
                                        System.out.println("Successfully Transferred Money");
                                    } else {
                                        System.out.println("Something went Wrong");
                                    }


                                } else {
                                    System.out.println("You have insufficient funds in your account  ");
                                }

                            }
                            else{
                                System.out.println("Failed");
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Name : " + account.getName());
                            System.out.println("Account Number : " + account.getAcno());
                            System.out.println("IFSC Code : " + account.getIfscCode());
                            System.out.println("Branch : " + account.getBranch());
                            System.out.println("Balance : " + account.getTotalBalance());

                            break;
                        }
                        case 5: {
                            //logout
                            b=false;
                            account=null;
                            break;

                        }


                    }
                }


                } else {

                    System.out.println("There was a problem in the system, please get back later");
                    userAccount =null;
                    //Garbage collection
                }
                break;

            }

            default: {
                System.out.println("Incorrect input");
            }

        }


        }

    }


}
