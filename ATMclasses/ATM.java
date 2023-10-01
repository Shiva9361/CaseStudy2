package CaseStudy2.ATMclasses;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Atm is implemented as a class, extends the abstract class basic functions 
 */
public class ATM extends BasicFunctions{
    private int numberOfTriesRemaining;
    private ArrayList<Customer> customers;
    //the public constructor that can be accessed by main 
    public ATM(Scanner sc,ArrayList<Customer> customers,int[] cashInATM){
        this.numberOfTriesRemaining=3;
        this.customers=customers;
        this.cashInATM = cashInATM;
        this.login(sc);

    }

    protected void login(Scanner sc){
        // Resetting the number of tries
        this.numberOfTriesRemaining=3;

        System.out.println("Welcome to ATM!!");

        Customer customer = new Customer(null, null, 0);
        
        boolean isValidAccountNumber = false;
        while(!isValidAccountNumber){
            System.out.println("Enter your account number to proceed");
            String accountNumber = sc.nextLine();
            if (Customer.accountChecker(accountNumber, this.customers)){
                customer = Customer.customerObjectFinder(accountNumber, this.customers);
                if (customer.accountNumber == null){
                    System.out.println("Account number is wrong,Try again");
                }
                else{
                    isValidAccountNumber=true;
                }
            }
            else{
                System.out.println("Account number is wrong,Check the number of digits again");
            }
        }
        
        boolean isLoggedIn=false;
        while(numberOfTriesRemaining>0){
            System.out.println("Enter your 5 digit pin");
            String pin  = sc.nextLine();
            if (customer.pinChecker(pin)){
                System.out.println("Successfully Logged in!!");
                isLoggedIn=true;
                break;
            }
            else{
                numberOfTriesRemaining--;
                System.out.println("Wrong pin, "+numberOfTriesRemaining+" attempts remaining");
            }
        }
        if (isLoggedIn){
            this.menu(customer,sc);
        }
        else{
            System.out.println("Login Failed, Try again later");
            login(sc);
        }
    }
}
 

