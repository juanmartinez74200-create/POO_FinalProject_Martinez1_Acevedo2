package domain;

import java.util.LinkedList;
import java.util.List;

//import javax.imageio.IIOException; //esto no se esta utilzando

public class Store {
    private static String storeName;
    private int id;

//listas de la tienda 
    private List<Sale> sales;
    private List<Receipt> receipts;
    private List<Employee> employees;
    private List<Customer> customers;
    private List<Category> categories;
    private List<VideoGame> videoGames;

    //¿Eliminar esto? dentro de los metodos se pueden crear variables locales cuando se necesiten, ya que tenemos las listas.
    private VideoGame videoGame;
    private Employee employee;
    private Sale sale;
    private Customer customer;
    private Receipt receipt;
    //

    //constructor vacio 
    public Store() {
        sales = new LinkedList<>();
        videoGames = new LinkedList<>();
        employees = new LinkedList<>();
        customers = new LinkedList<>();
        receipts = new LinkedList<>();
        categories = new LinkedList<>();
    }

    // contructor de la clase con parametros 
    public Store(int id, String storeName) {
        this();  //llamamos al constructor vacio 
        setId(id);
        setStoreName(storeName);
    }

    // getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getStoreName() {
        return storeName;
    }

    public static void setStoreName(String storeName) {
        Store.storeName = storeName;
    }

    //CRUDs completos y unos parciales

     //recibimos el videogame como objeto para poder registrar tanto videojuegos digitales como fisicos
     //sin tener que crear un metodo para cada uno, todo esto porque videogame es una clase abstracta.
    public void registerVideoGame(VideoGame videoGame) {
        VideoGame existingGame = searchVideoGame(videoGame.getId());

        if (existingGame == null) {
            videoGames.add(videoGame);
        } else {
            throw new IllegalArgumentException("el videojuego ya esta registrado");
        }
    }

    public VideoGame searchVideoGame(int idFind) {
        for (VideoGame videoGame : videoGames) {
            if (videoGame.getId() == idFind)
                return videoGame;

        }
        return null;
    }

    //aca se busca el videojuego por id y se permite modificar todos los atributos del videojuego
    //si mno existe el videojuego se muestra error 
    public void modifyVideoGame(int id, String title,String developer, int releaseYear, float basePrice,
         Platform platform, boolean activate){
        VideoGame videoGame = searchVideoGame(id);
        if (videoGame != null) {
            videoGame.setId(id);
            videoGame.setTitle(title);
            videoGame.setDeveloper(developer);
            videoGame.setReleaseYear(releaseYear);
            videoGame.setBasePrice(basePrice);
            videoGame.setPlatform(platform);
            videoGame.setActivate(activate);
        }else{
            throw new IllegalArgumentException ("el videojuego no existe");
        }
    }

    public void deleteVideoGame(int id) {
        VideoGame videoGame = searchVideoGame(id);
        if (videoGame != null) {
            videoGames.remove(videoGame);
        } else {
            throw new IllegalArgumentException ("el videojuego no existe");
        }
    }

    public void registerEmployee(int employeeId, String employeeName) {
        Employee employee = searchEmployee(employeeId);
        if (employee == null) {
            employees.add(new Employee(employeeId, employeeName));

        } else {
            throw new IllegalArgumentException();
        }
    }
  
    //busca el empleado y si no esta registrado, lo agrega a la lista 
    public Employee searchEmployee(int employeeIdFind) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeIdFind) {
                return employee;
            }

        }
        return null;
    }
        //busca el empleado por su id y permite cambiar su nombre
        //si no existe, aparece error 
    public void modifyEmployee(int EmployeeId, String employeeName) {
        Employee employee = searchEmployee(EmployeeId);
        if (employee != null) {
            employee.setEmployeeName(employeeName);
        } else{
            throw new IllegalArgumentException("El empleado no existe");
        }
    }

    public void deleteEmployee(int employeeId) {
        Employee employee = searchEmployee(employeeId);
        if (employee != null) {
            employees.remove(employee);
        }else{
            throw new IllegalArgumentException("el empleado no existe");
        }
    }

    //busca si la venta ya existe
    //si no existe crea una nueva venta y la agrega a la lista 
    //si la venta ya existe, muestra error
    public void registerSale(int saleId, int amount, Employee employee, Customer customer) {
        Sale sale = searchSale(saleId);
        if (sale == null) {
            sales.add(new Sale(saleId, amount, employee, customer, videoGame));
        }else{
            throw new IllegalArgumentException("la venta ya esta registrada");
        }
    }


    public Sale searchSale(int saleIdFind) {
        for (Sale sale : sales) {
            if (sale.getSaleId() == saleIdFind) {
                return sale;
            }

        }
        return null;
    }


    public void registerCustomer(int customerId, String name, String phoneNumber, String email) {
        Customer customer = searchCustomer(customerId);
        if (customer == null) {
            customers.add(new Customer(customerId, name, phoneNumber, email));
        } else {
            throw new IllegalArgumentException("El cliente ya esta registrado");
        }
    }

    public Customer searchCustomer(int customerIdFind) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerIdFind) {
                return customer;
            }

        }
        return null;
    }


    public void modifyCustomer(int customerId, String name, String phoneNumber, String email) {
        Customer customer = searchCustomer(customerId);
        if (customer != null) {
            customer.setName(name);
            customer.setPhoneNumber(phoneNumber);
            customer.setEmail(email);
        }else{
            throw new IllegalArgumentException("el cliente no existe");
        }

    }

    public void deleteCustomer(int customerId) {
        Customer customer = searchCustomer(customerId);
        if (customer != null) {
            customers.remove(customer);
        }else{
            throw new IllegalArgumentException("el cliente no existe");
        }
    }


    public void registerReceipt(int receiptId,Sale sale){
        Receipt receipt =searchReceipt(receiptId);
        if (receipt ==null) {
            receipts.add(new Receipt(receiptId, sale));
        }else{
            throw new IllegalArgumentException("el recibo ya ersta registrado");
        }
    }


    public Receipt searchReceipt(int receiptIdFind){
        for (Receipt receipt : receipts) {
            if (receipt.getReceiptId()==receiptIdFind) {
                return receipt;
            }
        }
        return null;
    }
}

