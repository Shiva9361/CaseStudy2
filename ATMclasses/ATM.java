package CaseStudy2.ATMclasses;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Atm is implemented as a class, extends the abstract class basic functions
 */
public class ATM extends BasicFunctions{
    private int numberOfTriesRemaining;
    private ArrayList<Customer> customers;
    //public constructor that can be accessed by main which is in a different package
    public ATM(Scanner sc,ArrayList<Customer> customers,int[] cashInATM){
        this.numberOfTriesRemaining=3;
        this.customers=customers;
        this.cashInATM = cashInATM;
        this.login(sc);

    }

    protected void login(Scanner sc){
        // Resetting the number of tries for each refresh of login
        this.numberOfTriesRemaining=3;

        System.out.println("Welcome to ATM!!");
        // Creating a customer object that is initialized to the correct object if both account number and pin is correct
        Customer customer = new Customer(null, null, 0,null);
        // Looping until vaild Account number is given 
        boolean isValidAccountNumber = false;
        while(!isValidAccountNumber){
            System.out.println("Enter your account number to proceed");
            String accountNumber = sc.nextLine();
            if (Customer.accountChecker(accountNumber, this.customers)){
                customer = Customer.customerObjectFinder(accountNumber, this.customers);
                if (customer.accountNumberGetter() == null){
                    System.out.println("Account number is wrong,Try again");
                }
                else{
                    isValidAccountNumber=true;
                }
            }
            else{
                System.out.println("Account number is wrong,Try again");
            }
        }
        
        boolean isLoggedIn=false;
        while(numberOfTriesRemaining>0){
            System.out.println("Enter your pin");
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
        // Once logged in, menu can be accessed
        if (isLoggedIn){
            this.menu(customer,sc);
        }
        // If the person failed to enter correct pims after 3 tries, giving an option to reset pin
        else if(numberOfTriesRemaining==0){
            boolean validChoice = false;
            while(!validChoice){
                System.out.println("Reset password?(Press 1 to reset,0 to quit)");
                String choice = sc.nextLine();
                if (choice.compareTo("1")==0){
                    customer.resetPin(sc,customer);
                    validChoice=true;
                }
                else if(choice.compareTo("0")==0) {
                    validChoice=true;
                } 
                else{
                    System.out.println("Invalid Choice!!");
                }
            }
            login(sc);

        }
        else{
            System.out.println("Login Failed, Try again later");
            login(sc);
        }
    }
}
 

