package ui;

import java.util.List;

import data.StoreStorage;
import domain.*;
import utils.Console;

public class Main {
    private static final String FILE_NAME = "store.csv";
    private static Store store = new Store(0, "The GamingZone");

    public static void main(String[] args) {
        int option;
        do {
            showMenu();
            option = Integer.parseInt(Console.readLine("select option"));

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
                case 23 -> storeSave();
                case 24 -> storeLoad();
                case 25 -> Console.writeLine("Exiting system...");
                default -> Console.writeLine("invalid option. Try again ");
            }
        } while (option != 25);
    }

    private static void showMenu() {
        Console.writeLine(" ");
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
        Console.writeLine("23. Guardar");
        Console.writeLine("24. Cargar ");
        Console.writeLine("25. Salir");
        Console.writeLine("========================");
    }
    
    private static void storeSave() {
        StoreStorage.save(store, FILE_NAME);
    }

    private static void storeLoad() {
        Store load = StoreStorage.load(FILE_NAME);
        if (load != null) {
            store = load;
            Console.writeLine("Datos Cargados Correctamente");
        }
    }

    private static void registerVideoGame() {

        Console.writeLine("1. Videojuego fisico");
        Console.writeLine("2. Videojuego digital");

        int option = 0;
        option = Integer.parseInt(Console.readLine("Selecciona el tipo de juego"));

        switch (option) {
            case 1 -> registerPhysicalVideoGame();
            case 2 -> registerDigitalVideoGame();
            default -> Console.writeLine("Opcion invalida");
        }
    }

    private static void registerPhysicalVideoGame() {
        int id = 0;
        String title = "";
        String developer = "";
        int releaseYear = 0;
        float basePrice = 0;
        int platformId = 0;
        Platform platform = null;
        Gender gender = null;
        int genderId = 0;
        boolean activate = false;
        int stock = 0;
        String condition = "";

        id = Integer.parseInt(Console.readLine("Ingrese el id : "));
        title = Console.readLine("Ingrese el título : ");
        developer = Console.readLine("Ingrese el desarrollador : ");
        releaseYear = Integer.parseInt(Console.readLine("Ingrese el año de lanzamiento : "));
        basePrice = Float.parseFloat(Console.readLine("Ingrese el precio base : "));

        showPlatforms();
        do {
            platformId = Integer.parseInt(Console.readLine("Ingrese el id de la plataforma : "));
            platform = store.searchPlatform(platformId);
            if (platform == null) {
                Console.writeLine("La plataforma seleccionada no existe");
            }
        } while (platform == null);

        showGenders();
        do {
            genderId = Integer.parseInt(Console.readLine("Ingrese el id del género : "));
            gender = store.searchGender(genderId);
            if (gender == null) {
                Console.writeLine("El genero seleccionado no es valido");
            }
        } while (gender == null);

        activate = Boolean.parseBoolean(Console.readLine("¿El videojuego esta activado? (true/false) "));
        stock = Integer.parseInt(Console.readLine("Ingrese el stock : "));
        condition = Console.readLine("Ingrese la condición (NEW o USED) : ");

        store.registerPhysicalVideogame(id, title, developer, releaseYear, basePrice, platform, gender,
                activate, stock, condition);
    }

    private static void registerDigitalVideoGame() {
        int id = 0;
        String title = "";
        int platformId = 0;
        float basePrice = 0;
        String developer = "";
        int releaseYear = 0;
        Gender gender = null;
        int genderId = 0;
        Platform platform = null;
        int availableLicenses = 0;
        boolean activate = false;
        float downloadSize = 0;

        id = Integer.parseInt(Console.readLine("Ingrese el id : "));
        title = Console.readLine("Ingrese el título : ");
        developer = Console.readLine("Ingrese el desarrollador : ");
        releaseYear = Integer.parseInt(Console.readLine("Ingrese el año de lanzamiento : "));
        basePrice = Float.parseFloat(Console.readLine("Ingrese el precio base : "));

        showPlatforms();
        do {
            platformId = Integer.parseInt(Console.readLine("Ingrese el id de la plataforma: "));
            platform = store.searchPlatform(platformId);
            if (platform == null) {
                Console.writeLine("La plataforma seleccionada no existe");
            }
        } while (platform == null);
        
        showGenders();
        do {
            genderId = Integer.parseInt(Console.readLine("Ingrese el id del género: "));
            gender = store.searchGender(genderId);
            if (gender == null) {
                Console.writeLine("El genero seleccionado no es valido");
            }
        } while (gender == null);

        activate = Boolean.parseBoolean(Console.readLine("¿El videojuego está activo? (true/false) : "));
        downloadSize = Float.parseFloat(Console.readLine("Ingrese el tamaño de descarga : " + "GB"));
        availableLicenses = Integer.parseInt(Console.readLine("Ingrese la cantidad de licencias disponibles : "));
        
        store.registerDigitalVideoGame(id, title, developer, releaseYear, basePrice,
                platform, gender, activate, downloadSize, availableLicenses);
    }

    private static void searchVideoGame() {
        int id = 0;
        VideoGame videoGame;

        showVideoGames();
        do{
        id = Integer.parseInt(Console.readLine("Ingrese el id del videojuego que desea buscar: "));
        videoGame = store.searchVideoGame(id);
    
        if (videoGame == null) {
            Console.writeLine("El videojuego seleccionado no existe");
        }
        }while(videoGame==null);

            Console.writeLine("id : " + videoGame.getId());
            Console.writeLine("Título : " + videoGame.getTitle());
            Console.writeLine("Desarrollador : " + videoGame.getDeveloper());
            Console.writeLine("Año de lanzamiento : " + videoGame.getReleaseYear());
            Console.writeLine("Precio base : " + videoGame.getBasePrice());
            Console.writeLine("Precio de venta : " + videoGame.calculateSellingPrice());
            Console.writeLine("Genero: "+ videoGame.getGender().getName());
            Console.writeLine("Plataforma: "+videoGame.getPlatform().getName());

            if (videoGame instanceof PhysicalGame physical) {
                Console.writeLine("La condicion es :" + physical.getCondition());
                Console.writeLine("La cantidad de stock es :" + physical.getStock());
            } else if (videoGame instanceof DigitalGame digital) {
                Console.writeLine("El peso del Videojuego :" + digital.getDownloadSize());
                Console.writeLine("La cantidad de licencias disponibles :" + digital.getAvailableLicenses());
            }
    }

    private static void modifyVideoGame() {
        int id = 0;
        VideoGame videoGame = null;

        showVideoGames();
        do{
        id = Integer.parseInt(Console.readLine("ingrese el id del videojuego que desea modificar : "));
        videoGame = store.searchVideoGame(id);
        if (videoGame == null) {
            Console.writeLine("El videojuego seleccionado no existe");
        }
        }while (videoGame == null);

            if (videoGame instanceof PhysicalGame) {
                modifyPhysicalVideoGame(id);
            } else if (videoGame instanceof DigitalGame) {
                modifyDigitalVideoGame(id);
            }
    }

    private static void modifyPhysicalVideoGame(int id) {
        String title = "";
        String developer = "";
        float basePrice = 0;
        int releaseYear = 0;
        int platformId = 0;
        Platform platform = null;
        int genderId = 0;
        Gender gender = null;
        boolean activate = false;
        int stock = 0;
        String condition = "";

        title = Console.readLine("Ingrese el nuevo título : ");
        developer = Console.readLine("Ingrese el nuevo desarrollador : ");
        releaseYear = Integer.parseInt(Console.readLine("Ingrese el nuevo año de lanzamiento : "));
        basePrice = Float.parseFloat(Console.readLine("Ingrese el nuevo precio base : "));
        
        showPlatforms();
        do {
            platformId = Integer.parseInt(Console.readLine("Ingrese el ID de la nueva plataforma : "));
            platform = store.searchPlatform(platformId);
            if (platform == null) {
                Console.writeLine("La plataforma es invalida/no existe");
            }
        } while (platform == null);

        showGenders();
        do {
            genderId = Integer.parseInt(Console.readLine("Ingrese el Genero que desas cambiar"));
            gender = store.searchGender(genderId);
            if (gender == null) {
                Console.writeLine("El genero no existe");
            }
        } while (gender == null);

        activate = Boolean.parseBoolean(Console.readLine("¿El videojuego está activo? (true/false): "));
        stock = Integer.parseInt(Console.readLine("Ingrese el nuevo stock : "));
        condition = Console.readLine("Ingrese la nueva condición (NEW o USED): ");
        store.modifyPhysicalVideoGame(id, title, developer, releaseYear, basePrice,
                platform, gender, activate, stock, condition);
    }


    private static void modifyDigitalVideoGame(int id) {
        float basePrice = 0;
        String title = "";
        String developer = "";
        int releaseYear = 0;
        int platformId = 0;
        Platform platform = null;
        int genderId = 0;
        Gender gender = null;
        boolean activate = false;
        float downloadSize = 0;
        int availableLicenses = 0;

        title = Console.readLine("Ingrese el nuevo título : ");
        developer = Console.readLine("Ingrese el nuevo desarrollador : ");
        releaseYear = Integer.parseInt(Console.readLine("Ingrese el nuevo año de lanzamiento : "));
        basePrice = Float.parseFloat(Console.readLine("Ingrese el nuevo precio base : "));

        showPlatforms();
        do {
            platformId = Integer.parseInt(Console.readLine("Ingrese el id de la plataforma : "));
            platform = store.searchPlatform(platformId);
            if (platform == null) {
                Console.writeLine("La plataforma seleccionada no existe");
            }
        } while (platform == null);

        showGenders();
        do {
            genderId = Integer.parseInt(Console.readLine("Ingrese el id del género : "));
            gender = store.searchGender(genderId);
            if (gender == null) {
                Console.writeLine("El genero seleccionado no es valido");
            }
        } while (gender == null);

        activate = Boolean.parseBoolean(Console.readLine("¿El videojuego está activo? (true/false) : "));
        downloadSize = Float.parseFloat(Console.readLine("Ingrese el nuevo tamaño de descarga : "));
        availableLicenses = Integer.parseInt(Console.readLine("Ingrese la nueva cantidad de licencias : "));
        store.modifyDigitalVideoGame(id, title, developer, releaseYear, basePrice,
                platform, gender, activate, downloadSize, availableLicenses);
    }

    private static void deleteVideoGame() {
        int id = 0;

        showVideoGames();
        id = Integer.parseInt(Console.readLine("Ingrese el id del videojuego que desea eliminar"));
        store.deleteVideoGame(id);
    }

    private static void registerEmployee() {
        int id = 0;
        String name = "";

        showEmployees();
        id = Integer.parseInt(Console.readLine("Ingrese el id del empleado : "));
        name = Console.readLine("Ingrese el nombre del empleado : ");
        store.registerEmployee(id, name);
    }

    private static void searchEmployee() {
        int id = 0;
        Employee employee;

        showEmployees();
        do{
        id = Integer.parseInt(Console.readLine("ingrese el id del empleado que desea buscar"));
        employee = store.searchEmployee(id); // guardar para poder mostrar el resultado

        if (employee == null) {
            Console.writeLine("El empleado seleccionado no existe");
        }
        }while (employee == null);

            Console.writeLine("id: " + employee.getId());
            Console.writeLine("name: " + employee.getName());
    }
    

    private static void modifyEmployee() {
        int id = 0;
        String name = "";

        showEmployees();
        id = Integer.parseInt(Console.readLine("ingrese el id del empleado que desea modificar"));
        name = Console.readLine("Ingrese el nuevo nombre");
        store.modifyEmployee(id, name);
    }

    private static void deleteEmployee() {
        int id = 0;

        showEmployees();
        id = Integer.parseInt(Console.readLine("Ingrese el id de el empleado que desea eliminar"));
        store.deleteEmployee(id);
    }

    private static void registerSale() {
        int saleId = 0;
        int amount = 0;
        Employee employee = null;
        int employeeId = 0;
        int customerId = 0;
        Customer customer = null;
        VideoGame videoGame = null;
        int videoGameId = 0;
        
        showSales();
        saleId = Integer.parseInt(Console.readLine("Ingrese el id de la venta : "));
        amount = Integer.parseInt(Console.readLine("Ingrese la cantidad : "));

        showEmployees();
        do {
            employeeId = Integer.parseInt(Console.readLine("ingrese el id del empleado que realiza la venta"));
            employee = store.searchEmployee(employeeId);
            if (employee == null) {
                Console.writeLine("El id del empleado no es valido");
            }
        } while (employee == null);

        showCustomers();
        do {
            customerId = Integer.parseInt(Console.readLine("Ingrese el id del cliente al que se le realiza la venta"));          customer = store.searchCustomer(customerId);
            if (customer == null) {
                Console.writeLine("El cliente no esta registrado");
            }
        } while (customer == null);

        showVideoGames();
        do {
            videoGameId = Integer.parseInt(Console.readLine("ingrese el id del videojuego"));
            videoGame = store.searchVideoGame(videoGameId);
            if (videoGame == null) {
                Console.writeLine("El videojuego con ese id no existe");
            }
        } while (videoGame == null);

            store.registerSale(saleId, amount, employee, customer, videoGame);
            Console.writeLine("Venta registrada correctamente");   
    }


    private static void searchSale() {
        int id = 0;
        Sale sale = null;

        showSales();
        do {
            id = Integer.parseInt(Console.readLine("ingrese el id de la venta que desea buscar"));
            sale = store.searchSale(id);
            if (sale == null) {
                Console.writeLine("la venta que buscan nunca se proceso");
            }
        } while (sale == null);

        Console.writeLine("Id de la venta: " + sale.getSaleId());
        Console.writeLine("Cantidad: " + sale.getAmount());
        Console.writeLine("Empleado: " + sale.getEmployee().getName());
        Console.writeLine("Cliente: " + sale.getCustomer().getName());
        Console.writeLine("Videojuego: " + sale.getVideoGame().getTitle());
        Console.writeLine("Total: " + sale.totalPurchase());

    }

    private static void registerCustomer() {
        int id = 0;
        String name = "";
        String phoneNumber = "";
        String email = "";

        showCustomers();
        id = Integer.parseInt(Console.readLine("Ingrese el id del cliente : "));
        name = Console.readLine("Ingrese el nombre del cliente : ");
        phoneNumber = Console.readLine("ingrese el numero de telefono de el cliente");
        email = Console.readLine("Ingrese el email de el cliente");
        store.registerCustomer(id, name, phoneNumber, email);

    }

    private static void searchCustomer() {

        int id = 0;
        Customer customer = null;

        showCustomers();
        do {
            id = Integer.parseInt(Console.readLine("ingrese el id del cliente que desea buscar"));
            customer = store.searchCustomer(id);
            if (customer == null) {
                Console.writeLine("El cliente seleccionado no existe");
            }
        } while (customer == null);

        Console.writeLine("id: " + customer.getId());
        Console.writeLine("nombre: " + customer.getName());
        Console.writeLine("numero de telefono: " + customer.getPhoneNumber());
        Console.writeLine("email: " + customer.getEmail());
    }

    private static void modifyCustomer() {
        int id = 0;
        String name = "";
        String phoneNumber = "";
        String email = "";
        
        showCustomers();
        id = Integer.parseInt(Console.readLine("ingrese el id del cliente que desea modificar"));
        name = Console.readLine("Ingrese el nuevo nombre");
        phoneNumber = Console.readLine("ingrese el nuevo numero de telefono");
        email = Console.readLine("ingrese el email");

        store.modifyCustomer(id, name, phoneNumber, email);
    }

    private static void deleteCustomer() {
        int id = 0;

        showCustomers();
        id = Integer.parseInt(Console.readLine("Ingrese el id de el cliente que desea eliminar"));
        store.deleteCustomer(id);
    }

    private static void registerReceipt() {
        int id = 0;
        int saleId = 0;
        Sale sale = null;

        showReceipts();
        id = Integer.parseInt(Console.readLine("Ingrese el id del recibo : "));

        showSales();
        do {
            saleId = Integer.parseInt(Console.readLine("Ingrese el id de la venta : "));
            sale = store.searchSale(saleId);
            if (sale == null) {
                Console.writeLine("La venta seleccionada no existe");
            }
        } while (sale == null);

        store.registerReceipt(id, sale);
        Console.writeLine("Recibo registrado correctamente");

    }

    private static void searchReceipt() {
        int id = 0;
        Receipt receipt = null;

        showReceipts();
        do {
            id = Integer.parseInt(Console.readLine("ingrese el id del recibo que desea buscar"));
            receipt = store.searchReceipt(id);
            if (receipt == null) {
                Console.writeLine("El comprobante seleccionado no existe");
            }
        } while (receipt == null);

        Console.writeLine("id del recibo: " + receipt.getReceiptId());
        Console.writeLine("id de la venta: " + receipt.getSale().getSaleId());
        Console.writeLine("total de la venta: " + receipt.getSale().totalPurchase());
    }

    private static void registerGender() {
        int id = 0;
        String name = "";
        float surchargePercentage = 0;

        showGenders();
        id = Integer.parseInt(Console.readLine("Ingrese el id del genero: "));
        name = Console.readLine("Ingrese el nombre del genero: ");
        surchargePercentage = Float.parseFloat(Console.readLine("ingrese el porcentaje adiciona : "));
        store.registerGender(id, name, surchargePercentage);
    }

    private static void searchGender() {
        int id = 0;
        Gender gender = null;

        showGenders();
        do {
            id = Integer.parseInt(Console.readLine("ingrese el id del genero que desea buscar"));
            gender = store.searchGender(id);
            if (gender == null) {
                Console.writeLine("El genero seleccionado no existe");
            }
        } while (gender == null);

        Console.writeLine("id: " + gender.getGenderId());
        Console.writeLine("Nombre del genero: " + gender.getName());
        Console.writeLine("porcentaje adicional: " + gender.getSurchargePercentage());
    }

    private static void registerPlatform() {
        int id = 0;
        String name = "";
        float surchargePercentage = 0;

        showPlatforms();
        id = Integer.parseInt(Console.readLine("registe el id de la plataforma"));
        name = Console.readLine("ingrese el nombre de la plataforma");
        surchargePercentage = Float.parseFloat(Console.readLine("ingrese el porcentaje de recargo de la plataforma"));
        store.registerPlatform(id, name, surchargePercentage);
    }

    private static void searchPlatform() {
        int id = 0;
        Platform platform = null;

        showPlatforms();
        do {
            id = Integer.parseInt(Console.readLine("ingrese el id de la plataforma que desea buscar"));
            platform = store.searchPlatform(id);
            if (platform == null) {
                Console.writeLine("La plataforma seleccionada no existe");
            }
        } while (platform == null);

        Console.writeLine("id: " + platform.getPlatformId());
        Console.writeLine("nombre: " + platform.getName());
        Console.writeLine("Porcentaje adicional: " + platform.getSurchargePercentage());
    }

    private static void modifyPlatform() {
        int id = 0;
        String name = "";
        float surchargePercentage = 0;
        
        showPlatforms();
        id = Integer.parseInt(Console.readLine("ingrese el id de la plataforma que desea modificar"));
        name = Console.readLine("Ingrese el nuevo nombre");
        surchargePercentage = Float.parseFloat(Console.readLine("Ingrese el nuevo porcentaje"));
        store.modifyPlatform(id, name, surchargePercentage);
    }

    private static void deletePlatform() {
        int id = 0;

        showPlatforms();
        id = Integer.parseInt(Console.readLine("Ingrese el id de la plataforma que desea eliminar"));
        store.deletePlatform(id);
    }



    //metodos para mostrar las plataformas
    
    private static void showPlatforms() {
        Console.writeLine("platafromas registradas");
        
        for (Platform platform : store.listPlatforms()){
            Console.writeLine("id: "+ platform.getPlatformId() + "nombre: " + platform.getName());
        }
        }

    private static void showGenders() {
        Console.writeLine("Generos registrados");

        for (Gender gender : store.listGenders()) {
            Console.writeLine("id: "+ gender.getGenderId() + "Nombre: "+ gender.getName());
        }
    }

     private static void showVideoGames() {
        Console.writeLine("Videojuegos registrados");

        for (VideoGame videoGame : store.listVideoGames()) {
            Console.writeLine("id: "+ videoGame.getId() + "Nombre: "+ videoGame.getTitle());
        }
    }

         private static void showEmployees() {
        Console.writeLine("Empleados registrados");

        for (Employee employee : store.listEmployees()) {
            Console.writeLine("id: "+ employee.getId() + "Nombre: "+ employee.getName());
        }
    }

     private static void showCustomers() {
        Console.writeLine("Clientes registrados");

        for (Customer customer : store.listCustomers()) {
            Console.writeLine("id: "+ customer.getId() + "Nombre: "+ customer.getName());
        }
    }

    private static void showSales(){
        Console.writeLine("Ventas registradas");

        for (Sale sale : store.listSales()) {
            Console.writeLine("id de venta: "+ sale.getSaleId());
        }
    }

     private static void showReceipts() {
        Console.writeLine("Recibos registrados");

        for (Receipt receipt : store.listReceipts()) {
            Console.writeLine("id del recibo: "+ receipt.getReceiptId());
        }
    }

}
