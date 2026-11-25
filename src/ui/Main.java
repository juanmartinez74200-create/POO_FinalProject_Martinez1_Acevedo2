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
                case 1 -> store.registerPhysicalVideogame(option, FILE_NAME, FILE_NAME, option, option, null, null,false, option, FILE_NAME);
                case 2 -> store.registerDigitalVideoGame(option, FILE_NAME, FILE_NAME, option, option, null, null,false, option, option);
                case 3 -> store.searchVideoGame(option);
                case 4 -> store.modifyPhysicalVideoGame(option, FILE_NAME, FILE_NAME, option, option, null, null, false, option, FILE_NAME);
                case 5 -> store.modifyDigitalVideoGame(option, FILE_NAME, FILE_NAME, option, option, null, null, false,option, option);
                case 6 -> store.deleteVideoGame(option);
                case 7 -> store.registerEmployee(option, FILE_NAME);
                case 8 -> store.searchEmployee(option);
                case 9 -> store.modifyEmployee(option, FILE_NAME);
                case 10 -> store.deleteEmployee(option);
                case 11 -> store.registerSale(option, option, null, null, null);
                case 12 -> store.searchSale(option);
                case 13 -> store.registerCustomer(option, FILE_NAME, FILE_NAME, FILE_NAME);
                case 14 -> store.searchCustomer(option);
                case 15 -> store.modifyCustomer(option, FILE_NAME, FILE_NAME, FILE_NAME);
                case 16 -> store.deleteCustomer(option);
                case 17 -> store.registerReceipt(option, null);
                case 18 -> store.searchReceipt(option);
                case 19 -> store.registerGender(option, FILE_NAME, option);
                case 20 -> store.searchGender(option);
                case 21 -> store.registerPlatform(option, FILE_NAME, option);
                case 22 -> store.searchPlatform(option);
                case 23 -> store.modifyPlatform(option, FILE_NAME, option);
                case 24 -> store.deletePlatform(option);
                case 25 -> store.registerCategory(option, null, FILE_NAME);
                case 26 -> store.searchCategory(option);
                case 27 -> store.modifyCategory(option, null, FILE_NAME);
                case 28 -> store.deleteCategory(option);
                case 29 -> Console.writeLine("Exiting system...");
                default -> Console.writeLine("invalid option. Try again ");

            }
        
        } while (option != 29);
        
        
    }

    private static void showMenu() {
    Console.writeLine("===== THE GAMINGZONE =====");
    Console.writeLine("1. Registrar videojuego");
    Console.writeLine("2. Buscar videojuego");
    Console.writeLine("3. Modificar videojuego");
    Console.writeLine("4. Eliminar videojuego");
    Console.writeLine("5. Registrar empleado");
    Console.writeLine("6. Buscar empleado");
    Console.writeLine("7. Modificar empleado");
    Console.writeLine("8. Eliminar empleado");
    Console.writeLine("9. Registrar venta");
    Console.writeLine("10. Buscar venta");
    Console.writeLine("11. Registrar cliente");
    Console.writeLine("12. Buscar cliente");
    Console.writeLine("13. Modificar cliente");
    Console.writeLine("14. Eliminar cliente");
    Console.writeLine("15. Registrar recibo");
    Console.writeLine("16. Buscar recibo");
    Console.writeLine("17. Registrar género");
    Console.writeLine("18. Buscar género");
    Console.writeLine("19. Registrar plataforma");
    Console.writeLine("20. Buscar plataforma");
    Console.writeLine("21. Modificar plataforma");
    Console.writeLine("22. Eliminar plataforma");
    Console.writeLine("23. Salir");
}

    private static void registerVideoGame(){
        Console.writeLine("1. Videojuego fisico");
        Console.writeLine("2. Videojuego digital");

        int option = Integer.parseInt(Console.readLine("Selecciona el tipo de juego"));

        switch (option) {
            case 1 -> registerPhysicalVideoGame();
            case 2 -> registerDigitalVideoGame();
            default -> Console.writeLine("Opcion invalida");
        }
    }


    private static void registerPhysicalVideoGame() {
    int id = Integer.parseInt(Console.readLine("Ingrese el id: "));
    String title = Console.readLine("Ingrese el título: ");
    String developer = Console.readLine("Ingrese el desarrollador: ");
    int releaseYear = Integer.parseInt(Console.readLine("Ingrese el año de lanzamiento: "));
    float basePrice = Float.parseFloat(Console.readLine("Ingrese el precio base: "));
    int platformId = Integer.parseInt(Console.readLine("Ingrese el id de la plataforma: "));
    Platform platform = store.searchPlatform(platformId);
    int genderId = Integer.parseInt(Console.readLine("Ingrese el id del género: "));
    Gender gender = store.searchGender(genderId);
    boolean activate = Boolean.parseBoolean(Console.readLine("¿El videojuego esta activado?"));
    int stock = Integer.parseInt(Console.readLine("Ingrese el stock: "));
    String condition = Console.readLine("Ingrese la condición (NEW o USED): ");

    store.registerPhysicalVideogame(id, title, developer, releaseYear, basePrice,platform, gender,
    activate,stock, condition);
    }


    private static void registerDigitalVideoGame() {
    int id = Integer.parseInt(Console.readLine("Ingrese el id: "));
    String title = Console.readLine("Ingrese el título: ");
    String developer = Console.readLine("Ingrese el desarrollador: ");
    int releaseYear = Integer.parseInt(Console.readLine("Ingrese el año de lanzamiento: "));
    float basePrice = Float.parseFloat(Console.readLine("Ingrese el precio base: "));

    int platformId = Integer.parseInt(Console.readLine("Ingrese el id de la plataforma: "));
    Platform platform = store.searchPlatform(platformId);

    int genderId = Integer.parseInt(Console.readLine("Ingrese el id del género: "));
    Gender gender = store.searchGender(genderId);

    boolean activate = Boolean.parseBoolean(Console.readLine("¿El videojuego está activo? (true/false): "));
    float downloadSize = Float.parseFloat(Console.readLine("Ingrese el tamaño de descarga: "));
    int availableLicenses = Integer.parseInt(Console.readLine("Ingrese la cantidad de licencias disponibles: "));

    store.registerDigitalVideoGame(id, title, developer, releaseYear, basePrice,
        platform, gender, activate, downloadSize, availableLicenses);
    }


    private static void searchVideoGame() {
    int id = Integer.parseInt(Console.readLine("Ingrese el id del videojuego que desea buscar: "));
    VideoGame videoGame = store.searchVideoGame(id);

    if (videoGame != null) {
        Console.writeLine("id: " + videoGame.getId());
        Console.writeLine("Título: " + videoGame.getTitle());
        Console.writeLine("Desarrollador: " + videoGame.getDeveloper());
        Console.writeLine("Año de lanzamiento: " + videoGame.getReleaseYear());
        Console.writeLine("Precio base: " + videoGame.getBasePrice());
        Console.writeLine("Precio de venta: " + videoGame.calculateSellingPrice());
    } else {
        Console.writeLine("Videojuego no encontrado");
    }
}
    private static void modifyVideoGame(){
        int id = Integer.parseInt(Console.readLine("ingrese el id del videojuego que deea modificar: "));
        int option = Integer.parseInt("");
        VideoGame videoGame = store.searchVideoGame(id);

        switch (option) {
            case 4 ->{
                if (videoGame instanceof PhysicalGame) {
                    store.modifyPhysicalVideoGame(id, FILE_NAME, FILE_NAME, option, id, null, null, false, option, FILE_NAME);
                }
            }
            case 5 ->{
                if (videoGame instanceof DigitalGame) {
                    store.modifyDigitalVideoGame(id, FILE_NAME, FILE_NAME, option, option, null, null, false, id, option);
                }
            }
            default -> Console.writeLine("INVALIDO");
        }
    }


    private static void modifyPhysicalVideoGame(int id) {
    String title = Console.readLine("Ingrese el nuevo título: ");
    String developer = Console.readLine("Ingrese el nuevo desarrollador: ");
    int releaseYear = Integer.parseInt(Console.readLine("Ingrese el nuevo año de lanzamiento: "));
    float basePrice = Float.parseFloat(Console.readLine("Ingrese el nuevo precio base: "));

    int platformId = Integer.parseInt(Console.readLine("Ingrese el ID de la nueva plataforma: "));
    Platform platform = store.searchPlatform(platformId);

    int genderId = Integer.parseInt(Console.readLine("Ingrese el ID del nuevo género: "));
    Gender gender = store.searchGender(genderId);

    boolean activate = Boolean.parseBoolean(Console.readLine("¿El videojuego está activo? (true/false): "));

    int stock = Integer.parseInt(Console.readLine("Ingrese el nuevo stock: "));
    String condition = Console.readLine("Ingrese la nueva condición (NEW o USED): ");

    store.modifyPhysicalVideoGame(
        id, title, developer, releaseYear, basePrice,
        platform, gender, activate, stock, condition
    );
}

    private static void modifyDigitalVideoGame(int id) {
    String title = Console.readLine("Ingrese el nuevo título: ");
    String developer = Console.readLine("Ingrese el nuevo desarrollador: ");
    int releaseYear = Integer.parseInt(Console.readLine("Ingrese el nuevo año de lanzamiento: "));
    float basePrice = Float.parseFloat(Console.readLine("Ingrese el nuevo precio base: "));

    int platformId = Integer.parseInt(Console.readLine("Ingrese el ID de la nueva plataforma: "));
    Platform platform = store.searchPlatform(platformId);

    int genderId = Integer.parseInt(Console.readLine("Ingrese el ID del nuevo género: "));
    Gender gender = store.searchGender(genderId);

    boolean activate = Boolean.parseBoolean(Console.readLine("¿El videojuego está activo? (true/false): "));
    float downloadSize = Float.parseFloat(Console.readLine("Ingrese el nuevo tamaño de descarga: "));
    int availableLicenses = Integer.parseInt(Console.readLine("Ingrese la nueva cantidad de licencias: "));

    store.modifyDigitalVideoGame(
        id, title, developer, releaseYear, basePrice,
        platform, gender, activate, downloadSize, availableLicenses);
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

        int videoGameId = Integer. parseInt(Console.readLine("ingrese el id del videojuego"));
        VideoGame videoGame = store.searchVideoGame(videoGameId);

        if (employee !=null && customer !=null && videoGame !=null) {
        store.registerSale(SaleId, amount, employee, customer, videoGame);
            Console.writeLine("Venta registrada correctamente");
        }else {
            Console.writeLine("No se pudo registrar la venta, verificar datos ingresados");
        }
    }

    private static void searchSale(){
        int id= Integer.parseInt(Console.readLine("ingrese el id de la venta que desea buscar"));
        Sale sale = store.searchSale(id);

        if (sale != null) {
            Console.writeLine("Id de la venta: "+ sale.getSaleId());
            Console.writeLine("Cantidad: "+ sale.getAmount());
            Console.writeLine("Empleado: "+ sale.getEmployee() .getName());
            Console.writeLine("Cliente: "+ sale.getCustomer() .getName());
            Console.writeLine("Videojuego: "+ sale.getVideoGame(). getTitle());
            Console.writeLine("Total: "+sale.totalPurchase());
        }else{
            Console.writeLine("venta no encontrado");
        }
    }

    private static void registerCustomer(){
        int id = Integer. parseInt(Console.readLine("Ingrese el id del cliente: "));
        String name= Console.readLine("Ingrese el nombre del cliente: ");
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

        if (sale!= null) {
        store.registerReceipt(id,sale);
        Console.writeLine("Recibo registrado correctamente");
        }else{
            Console.writeLine("No se encontro la venta");
        }
    }

    private static void searchReceipt(){
        int id = Integer. parseInt(Console.readLine("ingrese el id del recibo que desea buscar"));
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
        float surchargePercentage = Float. parseFloat(Console.readLine("ingrese el porcentaje adicional: "));
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
        float surchargePercentage= Integer.parseInt(Console.readLine("ingrese el precio de la plataforma"));
        store.registerPlatform(id, name, surchargePercentage);
    }
    
     private static void searchPlatform(){
        int id = Integer. parseInt(Console.readLine("ingrese el id de la plataforma que desea buscar"));
        Platform platform = store.searchPlatform(id);  //guardar para poder mostrar el resultado 

        if (platform != null) {
            Console.writeLine("id: "+ platform.getPlatformId());
            Console.writeLine("nombre: "+ platform.getName());
            Console.writeLine("Porcentaje adicional: "+ platform.getSurchargePercentage());
        } else {
            Console.writeLine("Plataforma no encontrada");
        }
    }

    private static void modifyPlatform(){
        int id = Integer. parseInt(Console.readLine("ingrese el id de la plataforma que desea modificar"));
        String name = Console.readLine("Ingrese el nuevo nombre");
        float surchargePercentage=Float. parseFloat(Console.readLine("Ingrese el nuevo porcentaje"));
        store.modifyPlatform(id, name, surchargePercentage);
    }

    private static void deletePlatform(){
        int id= Integer.parseInt(Console.readLine("Ingrese el id de la plataforma que desea eliminar"));
        store.deletePlatform(id);
    }

    private static void registerCategory() {
        int categoryId = Integer. parseInt(Console.readLine("ingresa el id de la categoria"));
        int genderId = Integer. parseInt(Console.readLine("ingresa el id del genero: "));
        Gender gender= store.searchGender(genderId);

        if(gender != null){
            String description = Console.readLine("Ingresa la descripcion de la categoria");
            store.registerCategory(categoryId, gender, description);
            Console.writeLine("Categoria registrada exitosamente");
        }else{
            Console.writeLine("La categoria no pudo registrarse");
        }
    }


      private static void searchCategory(){
        int id= Integer.parseInt(Console.readLine("ingrese el id de la categoria que desea buscar"));
        Category category = store.searchCategory(id);

        if (category != null) {
            Console.writeLine("Id de la categoria: "+ category.getCategoryId());
            Console.writeLine("Descripcion: "+ category.getDescription());
            Console.writeLine("Genero: "+ category. getGender() .getName());
        }else{
            Console.writeLine("Categoria no encontrada");
        }
    }


    private static void modifyCategory(){
     int categoryId = Integer.parseInt(Console.readLine("Ingrese el id de la categoría:"));
    Category category = store.searchCategory(categoryId);

    if (category != null) {
        int genderId = Integer.parseInt(
            Console.readLine("Ingrese el nuevo id del género:"));
            Gender gender = store.searchGender(genderId);
        if (gender != null) {
            String description = Console.readLine("Ingrese la nueva descripción de la categoría:");
            store.modifyCategory(categoryId, gender, description);
            Console.writeLine("Categoría modificada correctamente");
        } else {
            Console.writeLine("Género no encontrado");
        }
    } else {
        Console.writeLine("Categoría no encontrada");
    }
}


    private static void deleteCategory(){
        int categoryId = Integer.parseInt(Console.readLine("Ingrese el id de la categoria que desea eliminar "));
        Category category = store.searchCategory(categoryId);

        if (category != null) {
            store.deleteCategory(categoryId);
            Console.writeLine("Categoria eliminada correctamente");
        } else{
            Console.writeLine("Categoria no encontrada");
        }
    }
}


    

    

