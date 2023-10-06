package ATMclasses;

import java.util.Scanner;
/*
 * An Abstract class used to modularize code, This class is extended by the ATM class
 * This class implemenents the Transactions Interface and adds methods that is used by the ATM
 */

abstract class BasicFunctions implements Transactions {
    //Login method that is to be defined in ATM class
    protected int[] cashInATM;
    abstract protected void login(Scanner sc);
    //Implementation of the inherited deposit and withdraw methods
    public void deposit(Scanner sc,Customer customer){
        int cash = cashDenominationConverter(sc,this.cashInATM);
        System.out.println("Deposited amount : "+cash);
        customer.accountBalanceIncrementer(cash);
        System.out.println("New Account Balance : "+customer.accountBalanceGetter());
    }
    public void withdraw(Scanner sc,Customer customer){
        System.out.println("Enter amout to withdraw: ");
        int cash = sc.nextInt();sc.nextLine();
        if (!customer.transactionPossibile(cash)){
            System.out.println("Account balance not sufficient!!");
        }
        else{
            cashDenominationConverter(cash, cashInATM, customer);
        }
    }
    public void update(Scanner sc,Customer customer){
        System.out.println("Press 1 to update name\nPress 2 to update address\nPress 3 to update phone number");
        int choice = sc.nextInt();sc.nextLine();
        if (choice==1){
            System.out.println("Enter correct name: ");
            String name = sc.nextLine();
            customer.customerNameSetter(name);
            System.out.println("Updated Name: "+customer.customerNameGetter());
        }
        else if (choice==3){
            System.out.println("Enter correct phone number: ");
            String phoneNumber = sc.nextLine();
            customer.phoneNumberSetter(phoneNumber);
            System.out.println("Updated phone number: "+customer.phoneNumberGetter());
        }
        else if (choice==2){
            System.out.println("Enter correct address: ");
            String address = sc.nextLine();
            customer.addressSetter(address);
            System.out.println("Updated address: "+customer.addressGetter());
        }
        else{
            System.out.println("Invalid choice...");
        }
    }
    /*
     * The menu method can be used to access all features of the ATM
     */
    protected void menu(Customer customer,Scanner sc){
        boolean quit = false; 
        while(!quit){
            System.out.println("Menu");
            System.out.println("Press 1 to check balance\nPress 2 to deposit cash\nPress 3 to withdraw cash\nPress 4 to update basic details\nPress 0 to quit");
            int choice = sc.nextInt();sc.nextLine();
            if (choice==0){
                quit=true;
            }
            else if(choice==1){
                System.out.println("Account Balance : "+customer.accountBalanceGetter());
            }
            else if(choice==2){
                deposit(sc, customer);
            }
            else if(choice==3){
                withdraw(sc, customer);
            }
            else if (choice==4){
                update(sc, customer);
            }
        }login(sc);
    }
    
}
