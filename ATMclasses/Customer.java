package ATMclasses;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Customer is implemented as a class, This class can be used to initialize customers
 * This class also has all methods/details related to an account holder of the bank needed by the ATM
 */
public class Customer {
    private String accountNumber;
    private String pin;
    private int accountBalance;
    private String customerName;
    private String address;
    private String phoneNumber;
    private String securitykey;
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
    // Method to find the customer object from account number and return it
    static Customer customerObjectFinder(String accountNumber,ArrayList<Customer> customers){
        for (Customer customer:customers){
            if (customer.accountNumber.compareTo(accountNumber)==0){
                return customer;
            }
        }
        return new Customer(null, null, 0,null,null,null,null);
    }
    /*
     * Non-Static methods
     */

    public Customer(String accountNumber,String pin,int accountBalance,String securitykey,String customerName,String address,String phoneNumber){
        this.accountNumber=accountNumber;
        this.pin=pin;
        this.accountBalance=accountBalance;
        this.securitykey=securitykey;
    }
    
    boolean pinChecker(String pin){
        if (pin.compareTo(this.pin)==0){
            return true;
        }
        return false;
    }
    /*
     * Getters and setter for all private variables that need to accessed from somewhere else
     */
    void customerNameSetter(String customerName){
        this.customerName=customerName;
    }
    void addressSetter(String address){
        this.address=address;
    }
    void phoneNumberSetter(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    String customerNameGetter(){
        return this.customerName;
    }
    String addressGetter(){
        return this.address;
    }
    String phoneNumberGetter(){
        return this.phoneNumber;
    }
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
    String securitykeyGetter(){
        return this.securitykey;
    }
    // Method to check if the required amount can be withdrawn from the customer's account
    boolean transactionPossibile(int cash){
        if (cash>this.accountBalance){
            return false;
        }
        return true;
    }
    /*
     * This method is used to reset forgotton pin
     * In order to make sure that a third party dosen't get access to the account,
     * A Unique security key is alloted to the customer which can be accessed from the bank website
     * If unavailabe, The key will be sent to the registered phone number on request
     */
    void resetPin(Scanner sc,Customer customer){
        System.out.println("Enter your security bypass key found in your account page(website)\nIf unsure get in touch with the bank to get your security bypass key");
        boolean validChoice = false;
        while(!validChoice){
            System.out.println("Do you have the key?(Press 1 for yes,0 to quit)");
            String choice = sc.nextLine();
            if (choice.compareTo("1")==0){
                System.out.println("Enter Security key: ");
                String securitykey = sc.nextLine();
                if (securitykey.compareTo(this.securitykey)==0){
                    System.out.println("Enter new pin: ");
                    String pin = sc.nextLine();
                    this.pin=pin;
                    System.out.println("Pin Updated, Please try to remember your pin!");
                }
                else{
                    System.out.println("Wrong key,Try again later");
                }
                validChoice=true;
            }
            else if(choice.compareTo("0")==0) {
                System.out.println("Exiting ..");
                validChoice=true;
            } 
            else{
                System.out.println("Invalid Choice!!");
            }
        }
    }
}
