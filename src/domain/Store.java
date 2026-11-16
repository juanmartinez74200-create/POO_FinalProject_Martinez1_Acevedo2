package domain;

import java.util.LinkedList;
import java.util.List;

import javax.imageio.IIOException;

import domain.VideoGame.Plataform;

public class Store {
    private static String storeName;
    private int id;
    private List<Sale> sales;
    private List<Receipt> receipst;
    private List<PhysicalGame> physiclaGames;
    private List<DigitalGame> digitalGames;
    private List<Inventary> inventaries;
    private List<Employee> employees;
    private List<Customer> customers;
    private List<Category> categories;
    private List<VideoGame> videoGames;
    private VideoGame videoGame;
    private Employee employee;
    private Sale sale;
    private Customer customer;

    public Store() {
        sales = new LinkedList<>();
        videoGames=new LinkedList<>();
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

    public void listVideoGame() {
    };

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

    // crud para employee
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
            ;
        }
    }

    public void deleteEmployee(int employeeId) {
        Employee employee = searchEmployee(employeeId);
        if (employee != null) {
            employees.remove(employee);
        }
    }

    // CRUDS dee busqueda

    public Sale searchSale(int saleIdFind) {
        for (Sale sale : sales) {
            if (sale.getSaleId() == saleIdFind) {
                return sale;
            }

        }
        return null;
    }

    public Customer searchCustomer(int customerIdFind) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerIdFind) {
                return customer;
            }

        }
        return null;
    }

}
