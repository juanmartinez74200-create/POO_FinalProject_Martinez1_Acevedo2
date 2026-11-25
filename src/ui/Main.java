package ui;

import data.StoreStorage;
import domain.*;
import utils.Console;
import data.*;
public class Main {
    private static final String FILE_NAME = "store.csv";
    private static  Store store = new Store(0, "The GamingZone");

    public static void main (String [] args){
        int option;
        do {
            showMenu();
            option=Integer.parseInt(Console.readLine("select option"));
            
            switch (option) {
                case 1 -> registerVideoGame();
                case 2 -> searchVideoGame();
                case 3 -> modifyVideoGame();
                case 4 -> deleteVideoGame();
                case 5 -> registerEmployee();
                case 6 -> searchEmployee();
                case 7 -> modifyEmployee();
                case 8 -> deleteEmployee();
                case 9 -> registerSale();
                case 10 -> searchSale();
                case 11 -> registerCustomer();
                case 12 -> searchCustomer();
                case 13 -> modifyCustomer();
                case 14 -> deleteCustomer();
                case 15 -> registerReceipt();
                case 16 -> searchReceipt();
                case 17 -> registerGender();
                case 18 -> searchGender();
                case 19 -> registerPlatform();
                case 20 -> searchPlatform();
                case 21 -> modifyPlatform();
                case 22 -> deletePlatform();
                case 23 -> registerCategory();
                case 24 -> searchCategory();
                case 25 -> modifyCategory();
                case 26 -> deleteCategory();
                case 27 -> storeSave();
                case 28 -> storeLoad();
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
    Console.writeLine("23. Registrar una categoria");
    Console.writeLine("24, Buscar un videojuego");
    Console.writeLine("25, Modificar categoria");
    Console.writeLine("26, Eliminar Categoria");
    Console.writeLine("27, Guardar");
    Console.writeLine("28, Cargar ");
    Console.writeLine("========================");
}

    private static void storeSave(){
        StoreStorage.save(store, FILE_NAME);
    }
    private static void storeLoad(){
        Store load = StoreStorage.load(FILE_NAME);
        if (load != null){
            store = load;
            Console.writeLine("Datos Cargados Correctamente");
        }
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
    boolean activate = Boolean.parseBoolean(Console.readLine("¿El videojuego esta activado? (true/false) " ));
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
    float downloadSize = Float.parseFloat(Console.readLine("Ingrese el tamaño de descarga: " + "GB"));
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
        VideoGame videoGame = store.searchVideoGame(id);
        if (videoGame!=null) {
            if(videoGame instanceof PhysicalGame){
                modifyPhysicalVideoGame(id);
            }else if (videoGame instanceof DigitalGame) {
                modifyDigitalVideoGame(id);
            }
        }else{
            Console.writeLine("no hay videojuego con ese id");
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
        String name= Console.readLine("ingrese el nombre de la plataforma");
        float surchargePercentage= Float.parseFloat(Console.readLine("ingrese el porcentaje de recargo de la plataforma"));
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


    

    

