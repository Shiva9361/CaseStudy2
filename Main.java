import java.util.ArrayList;
import java.util.Scanner;
import ATMclasses.*;
/*
 * The main class is defined in seperate package from the all the other classes to make effective use of protected keyword
 */
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        /*
         * Simulating a database as an ArrayList as we don't have access to one
         */
        customers.add(new Customer("23456", "45689", 18697,"aa"));
        customers.add(new Customer("13456", "75689", 28697,"bb"));
        customers.add(new Customer("21456", "40689", 1286970,"cc"));
        customers.add(new Customer("23156", "45189", 1836907,"dd"));
        // Use Ctrl-c to exit!!! As ATMs don't have an inbuilt quit option
        System.out.println("Use CTRL+C to close the ATM\nATM does not have option to quit\nRequired because of nature of ATMs\n");
        new ATM(sc,customers,new int[] {1,2,3,4,1,7,3,1});// An instance of ATM is created to use the atm

    }
}