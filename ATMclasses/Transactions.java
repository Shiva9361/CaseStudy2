package ATMclasses;

import java.util.Scanner;

/*
 * Transactions is a interface which has to be implemented by the atm, 
 * There are majourly two diffenent types of transactions
 * Deposit and withdraw
 */
interface Transactions {
    /*
     * Methods to deposit and withdraw cash, Implemneted in BasicFunctions
     */
    public void deposit(Scanner sc,Customer customer);
    public void withdraw(Scanner sc,Customer customer); 
    /*
     * Method to convert denominations given by customer cash 
     */
    default int cashDenominationConverter(Scanner sc,int[] cashInATM){
        System.out.println("Enter number of 1 Rupee coins: ");
        int one = sc.nextInt();
        
        System.out.println("Enter number of 2 Rupee coins: ");
        int two = sc.nextInt();
        
        System.out.println("Enter number of 5 Rupee coins: ");
        int five = sc.nextInt();
        
        System.out.println("Enter number of 10 Rupee notes: ");
        int ten = sc.nextInt();
        
        System.out.println("Enter number of 50 Rupee notes: ");
        int fifty = sc.nextInt();
        
        System.out.println("Enter number of 100 Rupee notes: ");
        int hundred = sc.nextInt();
        
        System.out.println("Enter number of 500 Rupee notes: ");
        int fivehundred = sc.nextInt();
        
        System.out.println("Enter number of 2000 Rupee notes: ");
        int twoThousand = sc.nextInt();sc.nextLine();
        /*
         * As this money is deposited in the atm, The atm can use it when someone else withdraws
         */
        cashInATM[0]+=twoThousand;
        cashInATM[1]+=fivehundred;
        cashInATM[2]+=hundred;
        cashInATM[3]+=fifty;
        cashInATM[4]+=ten;
        cashInATM[5]+=five;
        cashInATM[6]+=two;
        cashInATM[7]+=one;
    
        return 1*one+two*2+five*5+ten*10+fifty*50+hundred*100+fivehundred*500+twoThousand*2000;
    }
    
    default void cashDenominationConverter(int cash,int[] cashInATM,Customer customer){
        /*
         * Assuming that the atm has a way to dispence coins too
         */
        int givencash = cash;// Using this as a temproary variable to remember the money to be dispensed
        int one=0,two=0,five=0,ten=0,fifty=0,hundred=0,fivehundred=0,twoThousand=0;
        while(cash>=2000 && cashInATM[0]-twoThousand>0){
            cash-=2000;
            twoThousand+=1;
        }
        while(cash>=500 && cashInATM[1]-fivehundred>0){
            cash-=500;
            fivehundred+=1;
        }
        while(cash>=100 && cashInATM[2]-hundred>0){
            cash-=100;
            hundred+=1;
        }
        while(cash>=50 && cashInATM[3]-fifty>0){
            cash-=50;
            fifty+=1;
        }
        while(cash>=10 && cashInATM[4]-ten>0){
            cash-=10;
            ten+=1;
        }
        while(cash>=5 && cashInATM[5]-five>0){
            cash-=5;
            five+=1;
        }
        while(cash>=2 && cashInATM[6]-two>0){
            cash-=2;
            two+=1;
        }
        while(cash>=1&& cashInATM[7]-one>=0){
            cash-=1;
            one+=1;
        }
        /*
         * If after all the loops, cash is positive, it means the ATM dosen't have the required denominations
         */
        if (cash>0){
            System.out.println("ATM does't have enough notes");
        }
        /*
         * Removing the notes from memory as it has been dispensed to the person who withdrew money
         */
        else{
            cashInATM[0]-=twoThousand;
            cashInATM[1]-=fivehundred;
            cashInATM[2]-=hundred;
            cashInATM[3]-=fifty;
            cashInATM[4]-=ten;
            cashInATM[5]-=five;
            cashInATM[6]-=two;
            cashInATM[7]-=one;
            customer.accountBalanceDecrementer(givencash);
            /*
             * Printing the money dispensed out as there is no real hardware as of now
             */
            System.out.println("number of 1 Rupee coins: "+one);
            System.out.println("number of 2 Rupee coins: "+two);
            System.out.println("number of 5 Rupee coins: "+five);
            System.out.println("number of 10 Rupee notes: "+ten);
            System.out.println("number of 50 Rupee notes: "+fifty);
            System.out.println("number of 100 Rupee notes: "+hundred);
            System.out.println("number of 500 Rupee notes: "+fivehundred);
            System.out.println("number of 2000 Rupee notes: "+twoThousand);
            // Finally printing the balance
            System.out.println("Account Balance : "+customer.accountBalanceGetter());
        }
    }
}
