package ui;

import domain.*;
import utils.Console;
import data.StoreStorage;

public class Main {
    private static final String FILE_NAME = "store.csv";
    private static  Store store = new Store(0, "The GamingZone");

    public static void main (String [] args){
        int option;
        do {
            showMenu();
            option=Integer.parseInt(Console.readLine("select option"));
            
            switch (option) {
                case 1 -> store.registerVideoGame(null);
                case 2 -> store.searchVideoGame(option);
                case 3 -> store.modifyVideoGame();
                case 4 -> deleteVideoGame();
                case 5 -> registerEmployee();
                case 6 -> searchEmployee();
                case 7 -> modifyEmployee();
                case 8 -> deleteEmployee();
                case 9 -> registerSale();
                case 10 -> searchSale();
                case 11 -> registerCustomer();
                case 12 -> searchCustomer();
                case 13 -> modifyCustomer ();
                case 14 -> deleteCustomer();
                case 15 -> registerReceipt();
                case 16 -> searchReceipt();
                case 17 -> registerGender();
                case 18 -> searchGender();
                case 19 -> registerPlatform();
                case 20 -> searchPlatform();
                case 21 -> modifyPlatform();
                case 22 -> deletePlatform();
                case 23 -> Console.writeLine("Exiting system...");              
                default -> Console.writeLine("invalid option. Try again ");
        
            }
        } while (option != 23);
    }
}
