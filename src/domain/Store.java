package domain;

import java.util.LinkedList;
import java.util.List;

import javax.imageio.IIOException;

import domain.VideoGame.Platform;

public class Store {
    private static String storeName;
    private int id;
    private List<Sale> sales;
    private List<Receipt> receipst;
    private List<Inventary> inventaries;
    private List<Employee> employees;
    private List<Customer> customers;
    private List<Category> categories;
    private List<VideoGame> videoGames;
    private VideoGame videoGame;
    private Employee employee;
    private Sale sale;
    private Customer customer;
    private Receipt receipt;
    private Inventary inventary;

    public Store() {
        sales = new LinkedList<>();
        videoGames = new LinkedList<>();
        employees = new LinkedList<>();
        customers = new LinkedList<>();
    }

    // contructor de la clase
    public Store(int id, String storeName) {
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
    public void registerVideoGame(int id, String title, String developer, int releaseYear, float basePrice,
            Plataform plataform, boolean activate) {
        VideoGame videoGame = searchVideoGame(id);
        if (videoGame == null) {
            videoGames.add(new VideoGame(id, title, developer, releaseYear, basePrice, plataform, activate));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public VideoGame searchVideoGame(int idFind) {
        for (VideoGame videoGame : videoGames) {
            if (videoGame.getId() == idFind)
                return videoGame;

        }
        return null;
    }

    public void modifyVideoGame(int id) {
        VideoGame videoGame = searchVideoGame(id);
        if (videoGame != null) {
            videoGame.setId(id);
        }
    }

    public void deleteVideoGame(int id) {
        VideoGame videoGame = searchVideoGame(id);
        if (videoGame != null) {
            videoGames.remove(videoGame);
        }

    }

    public void registeEmployee(int employeeId, String employeeName) {
        Employee employee = searchEmployee(employeeId);
        if (employee == null) {
            employees.add(new Employee(employeeId, employeeName));

        } else {
            throw new IllegalArgumentException();
        }
    }

    public Employee searchEmployee(int employeeIdFind) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeIdFind) {
                return employee;
            }

        }
        return null;
    }

    public void modifyEmployee(int Employee, String employeeName) {
        Employee employee = searchEmployee(Employee);
        if (employee != null) {
            employee.setEmployeeName(employeeName);

        }
    }

    public void deleteEmployee(int employeeId) {
        Employee employee = searchEmployee(employeeId);
        if (employee != null) {
            employees.remove(employee);
        }
    }

    public void registerSale(int saleId, int amount, Employee employee, Customer customer) {
        Sale sale = searchSale(saleId);
        if (sale != null) {
            sales.add(sale);
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
            throw new IllegalArgumentException();
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

    public void ModifyCustomer(int customerId, String name, String phoneNumber, String email) {
        Customer customer = searchCustomer(customerId);
        if (customer != null) {
            customer.setName(name);
            customer.setPhoneNumber(phoneNumber);
            customer.setEmail(email);
        }

    }

    public void deleteCustomer(int customerId) {
        Customer customer = searchCustomer(customerId);
        if (customer != null) {
            customers.remove(customer);
        }
    }

    public void registerReceipt(int receiptId,Sale sale){
        Receipt receipt =searchReceipt(receiptId);
        if (receipt!=null) {
            receipst.add(receipt);
        }
    }
    public Receipt searchReceipt(int receiptIdFind){
        for (Receipt receipt : receipst) {
            if (receipt.getReceiptId()==receiptIdFind) {
                return receipt;
            }
        }
        return null;
    }



}

