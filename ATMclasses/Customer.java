package CaseStudy2.ATMclasses;
import java.util.ArrayList;
/*
 * Customer is implemented as a class, This class can be used to initialize customers
 * This class also has all methods/details related to an account holder of the bank needed by the ATM
 */
public class Customer {
    private String accountNumber;
    private String pin;
    private int accountBalance;
    /*
     * Static methods of class 
     */
    static boolean accountChecker(String accountNumber,ArrayList<Customer> customers){
        if(accountNumber.length()!=5){
            return false;
        }
        for (Customer customer:customers){
            if (customer.accountNumber.compareTo(accountNumber)==0){
                return true;
            }
        }
        return false;
    }

    static Customer customerObjectFinder(String accountNumber,ArrayList<Customer> customers){
        for (Customer customer:customers){
            if (customer.accountNumber.compareTo(accountNumber)==0){
                return customer;
            }
        }
        return new Customer(null, null, 0);
    }
    /*
     * Non-Static methods
     */

    public Customer(String accountNumber,String pin,int accountBalance){
        this.accountNumber=accountNumber;
        this.pin=pin;
        this.accountBalance=accountBalance;
    }
    
    boolean pinChecker(String pin){
        if (pin.compareTo(this.pin)==0){
            return true;
        }
        return false;
    }
    // As Account balance is private, getters and setters are used
    int accountBalanceGetter(){
        return this.accountBalance;
    }
    void accountBalanceIncrementer(int cash){
        this.accountBalance+=cash;
    }
    void accountBalanceDecrementer(int cash){
        this.accountBalance-=cash;
    }
    String accountNumberGetter(){
        return this.accountNumber;
    }
    // Method to check if the required amount can be withdrawn from the customer's account
    boolean transactionPossibile(int cash){
        if (cash>this.accountBalance){
            return false;
        }
        return true;
    }
}
