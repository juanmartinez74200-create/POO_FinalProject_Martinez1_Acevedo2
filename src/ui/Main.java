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

    private static void deleteVideoGame(){
        int id = Integer.parseInt(Console.readLine("Ingrese el id del videojuego que desea eliminar"));
        store.deleteVideoGame(id);
    }

    private static void registerEmployee(){
        int id = Integer. parseInt(Console.readLine("Ingrese el id del empleado: "));
        String name= Console.readLine("Ingres el numero del empleado: ");
        store.registerEmployee(id,name);
    }

    private static void searchEmployee(){
        int id = Integer. parseInt(Console.readLine("ingrese el id del empleado que desea buscar"));
        Employee employee = store.searchEmployee(id);  //guardar para poder mostrar el resultado 

        if (employee != null) {
            Console.writeLine("id: "+ employee.getId());
            Console.writeLine("name: "+ employee.getName());
        } else {
            Console.writeLine("Empleado no encontrado");
        }
    }

    private static void modifyEmployee(){
        int id = Integer. parseInt(Console.readLine("ingrese el id del empleado que desea modificar"));
        String name = Console.readLine("Ingrese el nuevo nombre");
        store.modifyEmployee(id, name);
    }

    private static void deleteEmployee(){
        int id= Integer.parseInt(Console.readLine("Ingrese el id de el empleado que desea eliminar"));
        store.deleteEmployee(id);
    }

    private static void registerSale(){
        int SaleId = Integer.parseInt(Console.readLine("Ingrese el id de la venta: "));
        int amount = Integer.parseInt(Console.readLine("Ingrese la cantidad: "));

        int employeeId = Integer.parseInt(Console.readLine("Ingrese el id de el empleado: "));
        Employee employee = store.searchEmployee(employeeId);

        int customerId = Integer.parseInt(Console.readLine("Ingrese el id de el cliente"));
       Customer customer = store.searchCustomer(customerId);

        int videoGameId = 

        store.registerSale(SaleId, amount, employee, customer, videoGame);
    }

    private static void searchSale(){
        int id= Integer.parseInt(Console.readLine("ingrese el id de la venta que desea buscar"));
        Sale sale = store.searchSale(id);

        if (sale != null) {
            Console.writeLine("Id de la venta: "+ sale.getSaleId());
            Console.writeLine("Cantidad: "+ sale.getAmount());
            Console.writeLine("Empleado: "+ sale.getEmployee());
            Console.writeLine("Cliente: "+ sale.getCustomer());
            Console.writeLine("Videojuego: "+ sale.getVideoGame());
            Console.writeLine("Total: "+sale.totalPurchase());
        }else{
            Console.writeLine("venta no encontrado");
        }
    }

    private static void registerCustomer(){
        int id = Integer. parseInt(Console.readLine("Ingrese el id del cliente: "));
        String name= Console.readLine("Ingres el numero del cliente: ");
        String phoneNumber= Console.readLine("ingrese el numero de telefono de el cliente");
        String email= Console.readLine("Ingrese el email de el cliente");
        store.registerCustomer(id,name,phoneNumber,email);
    }

    private static void searchCustomer(){
        
        int id = Integer. parseInt(Console.readLine("ingrese el id del cliente que desea buscar"));
        Customer customer = store.searchCustomer(id); 

        if (customer!= null) {
            Console.writeLine("id: "+ customer.getId());
            Console.writeLine("nombre: "+ customer.getName());
            Console.writeLine("numero de telefono: "+ customer.getPhoneNumber());
            Console.writeLine("email: "+ customer.getEmail());
        } else {
            Console.writeLine("cliente no encontrado");
        }
    }

     private static void modifyCustomer(){
        int id = Integer. parseInt(Console.readLine("ingrese el id del cliente que desea modificar"));
        String name = Console.readLine("Ingrese el nuevo nombre");
        String phoneNumber = Console.readLine("ingrese el nuevo numero de telefono");
        String email = Console.readLine("ingrese el numero email");
        
        store.modifyCustomer(id, name, phoneNumber,email);
    }

    private static void deleteCustomer(){
        int id= Integer.parseInt(Console.readLine("Ingrese el id de el cliente que desea eliminar"));
        store.deleteCustomer(id);
    }

    private static void registerReceipt(){
        int id = Integer. parseInt(Console.readLine("Ingrese el id del recibo: "));
        int saleId = Integer. parseInt(Console.readLine("Ingrese el id de la venta: "));
        Sale sale = store.searchSale(saleId);
        store.registerReceipt(id,sale);
    }

    private static void searchReceipt(){
        int id = Integer. parseInt(Console.readLine("ingrese el id del empleado que desea buscar"));
        Receipt receipt = store.searchReceipt(id);  //guardar para poder mostrar el resultado 

        if (receipt != null) {
            Console.writeLine("id del recibo: "+ receipt.getReceiptId());
            Console.writeLine("id de la venta: "+ receipt.getSale().getSaleId());
            Console.writeLine("total de la venta: "+ receipt.getSale().totalPurchase());
        } else {
            Console.writeLine("Recibo no encontrado");
        }
    }

     private static void registerGender(){
        int id = Integer. parseInt(Console.readLine("Ingrese el id del genero: "));
        String name= Console.readLine("Ingrese el nombre del genero: ");
        int surchargePercentage = Integer. parseInt(Console.readLine("ingrese el porcentaje adicional: "))
        store.registerGender(id, name, surchargePercentage);
    }

    private static void searchGender(){
        int id = Integer. parseInt(Console.readLine("ingrese el id del genero que desea buscar"));
         Gender gender = store.searchGender(id);  //guardar para poder mostrar el resultado 

        if (gender != null) {
            Console.writeLine("id: "+ gender.getGenderId());
            Console.writeLine("Nombre del genero: "+ gender.getName());
            Console.writeLine("porcentaje adicional: "+ gender.getSurchargePercentage());
        } else {
            Console.writeLine("Genero no encontrado");
        }
    }

    private static void registerPlatform(){
        int id= Integer.parseInt(Console.readLine("registe el id de la plataforma"));
        String name= Console.readLine("ingrese el nombre de la pltaforma");
        float price= Integer.parseInt(Console.readLine("ingrese el precio de la plataforma"));
        store.registerPlatform(id, name, price);
    }
    
     private static void searchPlatform(){
        int id = Integer. parseInt(Console.readLine("ingrese el id de la plataforma que desea buscar"));
        Platform platform = store.searchPlatform(id);  //guardar para poder mostrar el resultado 

        if (platform != null) {
            Console.writeLine("id: "+ platform.getplatformId());
            Console.writeLine("nombre: "+ platform.getName());
            Console.writeLine("precio: "+ platform.getSurchargePercentage());
        } else {
            Console.writeLine("Plataforma no encontrada");
        }
    }

    private static void modifyPlatform(){
        int id = Integer. parseInt(Console.readLine("ingrese el id de la plataforma que desea modificar"));
        String name = Console.readLine("Ingrese el nuevo nombre");
        float surchargePercentage=Integer. parseInt(Console.readLine("Ingrese el nuevo porcentaje"));
        store.modifyPlatform(id, name, surchargePercentage);
    }

    private static void deletePlatform(){
        int id= Integer.parseInt(Console.readLine("Ingrese el id de la plataforma que desea eliminar"));
        store.deletePlatform(id);
    }
}


    

    

