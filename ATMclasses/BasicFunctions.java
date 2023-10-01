package CaseStudy2.ATMclasses;

import java.util.Scanner;
/*
 * An Abstract class used to modularize code, This class is extended by the ATM class
 * This class implemenents the Transactions Interface
 */

abstract class BasicFunctions implements Transactions {
    //Login method that is to be defined in ATM class
    protected int[] cashInATM;
    abstract protected void login(Scanner sc);
   
    public void Deposit(Scanner sc,Customer customer){
        int cash = denominationsToCash(sc,this.cashInATM);
        System.out.println("Deposited amount : "+cash);
        customer.accountBalanceIncrementer(cash);
        System.out.println("New Account Balance : "+customer.accountBalanceGetter());
    }
    public void Withdraw(Scanner sc,Customer customer){
        System.out.println("Enter amout to withdraw: ");
        int cash = sc.nextInt();sc.nextLine();
        if (!customer.transactionPossibile(cash)){
            System.out.println("Account balance not sufficient!!");
        }
        else{
            cashtoDenomination(cash, this.cashInATM, customer);
        }
    }
    protected void menu(Customer customer,Scanner sc){
        boolean quit = false; 
        while(!quit){
            System.out.println("Menu");
            System.out.println("Press 1 to check balance\nPress 2 to deposit cash\nPress 3 to withdraw cash\nPress 0 to quit");
            int choice = sc.nextInt();sc.nextLine();
            if (choice==0){
                quit=true;
            }
            else if(choice==1){
                System.out.println("Account Balance : "+customer.accountBalanceGetter());
            }
            else if(choice==2){
                Deposit(sc, customer);
            }
            else if(choice==3){
                Withdraw(sc, customer);
            }
        }
    }
    
}
