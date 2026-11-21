package domain;

import java.util.LinkedList;
import java.util.List;
// solucion static a final 

public class Store {
    private static String storeName;
    private int id;

    // listas de la tienda
    private List<Sale> sales;
    private List<Receipt> receipts;
    private List<Employee> employees;
    private List<Customer> customers;
    private List<Category> categories;
    private List<VideoGame> videoGames;
    private List<Gender> gendes;
    private List<Platform> platforms;

    private VideoGame videoGame;
    private Employee employee;
    private Sale sale;
    private Customer customer;
    private Receipt receipt;
    private Gender gerder;
    private Platform platform;
    private Category category;

    // constructor vacio
    public Store() {
        sales = new LinkedList<>();
        videoGames = new LinkedList<>();
        employees = new LinkedList<>();
        customers = new LinkedList<>();
        receipts = new LinkedList<>();
        categories = new LinkedList<>();
        platforms = new LinkedList<>();
        categories = new LinkedList<>();
    }

    // contructor de la clase con parametros
    public Store(int id, String storeName) {
        this();
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

    // CRUDs completos y unos parciales

    // CRUD completo class VideoGame
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

    public void modifyVideoGame(int id, String title, String developer, int releaseYear, float basePrice,
            boolean activate) {
        VideoGame videoGame = searchVideoGame(id);
        if (videoGame != null) {
            videoGame.setDeveloper(developer);
            videoGame.setBasePrice(basePrice);
            videoGame.setActivate(activate);
        } else {
            throw new IllegalArgumentException("el videojuego no existe");
        }
    }

    public void deleteVideoGame(int id) {
        VideoGame videoGame = searchVideoGame(id);
        if (videoGame != null) {
            videoGames.remove(videoGame);
        } else {
            throw new IllegalArgumentException("el videojuego no existe");
        }
    }

    // CRUD completo de class Employee

    public void registerEmployee(int employeeId, String employeeName) {
        Employee employee = searchEmployee(employeeId);
        if (employee == null) {
            employees.add(new Employee(employeeId, employeeName));

        } else {
            throw new IllegalArgumentException("el empleado ya esta registrado");
        }
    }

    public Employee searchEmployee(int idFind) {
        for (Employee employee : employees) {
            if (employee.getId() == idFind) {
                return employee;
            }

        }
        return null;
    }

    public void modifyEmployee(int id, String name) {
        Employee employee = searchEmployee(id);
        if (employee != null) {
            employee.setName(name);
        } else {
            throw new IllegalArgumentException("El empleado no existe");
        }
    }

    public void deleteEmployee(int employeeId) {
        Employee employee = searchEmployee(employeeId);
        if (employee != null) {
            employees.remove(employee);
        } else {
            throw new IllegalArgumentException("el empleado no existe");
        }
    }

    // CRUD parcial de class Sale

    public void registerSale(int saleId, int amount, Employee employee, Customer customer, VideoGame videoGame) {
        Sale sale = searchSale(saleId);
        if (sale == null) {
            sales.add(new Sale(saleId, amount, employee, customer, videoGame));
        } else {
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

    public void registerCustomer(int id, String name, String phoneNumber, String email) {
        Customer customer = searchCustomer(id);
        if (customer == null) {
            customers.add(new Customer(id, name, phoneNumber, email));
        } else {
            throw new IllegalArgumentException("El cliente ya esta registrado");
        }
    }

    // CRUD completo class Customer

    public Customer searchCustomer(int idFind) {
        for (Customer customer : customers) {
            if (customer.getId() == idFind) {
                return customer;
            }

        }
        return null;
    }

    public void modifyCustomer(int Id, String name, String phoneNumber, String email) {
        Customer customer = searchCustomer(Id);
        if (customer != null) {
            customer.setName(name);
            customer.setPhoneNumber(phoneNumber);
            customer.setEmail(email);
        } else {
            throw new IllegalArgumentException("el cliente no existe");
        }

    }

    public void deleteCustomer(int Id) {
        Customer customer = searchCustomer(Id);
        if (customer != null) {
            customers.remove(customer);
        } else {
            throw new IllegalArgumentException("el cliente no existe");
        }
    }

    // CRUD parcial class Receipt

    public void registerReceipt(int receiptId, Sale sale) {
        Receipt receipt = searchReceipt(receiptId);
        if (receipt == null) {
            receipts.add(new Receipt(receiptId, sale));
        } else {
            throw new IllegalArgumentException("el recibo ya esta registrado");
        }
    }

    public Receipt searchReceipt(int receiptIdFind) {
        for (Receipt receipt : receipts) {
            if (receipt.getReceiptId() == receiptIdFind) {
                return receipt;
            }
        }
        return null;
    }

    // CRUD parcial class Gender

    public void registerGender(int genderId, String name, float surchargePercentage) {
        Gender gender = searchGender(genderId);
        if (gender == null) {
            gendes.add(new Gender(genderId, name, surchargePercentage));
        } else {
            throw new IllegalArgumentException("este genero esta agregado");
        }
    }

    public Gender searchGender(int genderIdFind) {
        for (Gender gender : gendes) {
            if (gender.getGenderId() == genderIdFind) {
                return gender;
            }
        }
        return null;
    }

    // CRUD completo Class Platform

    public void registerPlatform(int platformId, String name, float price) {
        Platform platform = searchPlatform(platformId);
        if (platform == null) {
            platforms.add(new Platform(platformId, name, price));
        } else {
            throw new IllegalArgumentException("la pataforma ya esta asignada");
        }
    }

    public Platform searchPlatform(int platformIdFind) {
        for (Platform platmform : platforms) {
            if (platmform.getplatformId() == platformIdFind) {
                return platform;
            }

        }
        return null;
    }

    public void modifyPlatform(int platformId, String name, float surchargePercentage) {
        Platform platform = searchPlatform(id);
        if (platform != null) {
            platform.setName(name);
            platform.setSurchargePercentage(surchargePercentage);
        }
    }

    public void deletePlatform(int id) {
        Platform platform = searchPlatform(id);
        if (platform != null) {
            platforms.remove(platform);
        } else {
            throw new IllegalArgumentException("plataforma no encontrada");
        }
    }

    // CRUD COPLETO CATEGORY

    public Category searchCategory(int categoryIdFind) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryIdFind) {
                return category;
            }

        }
        return null;
    }

    public void registerCategory(int categoryId, Gender gender, String description) {
        Category category = searchCategory(categoryId);
        if (category != null) {
            categories.add(new Category(categoryId, gender, description));
        } else {
            throw new IllegalArgumentException("esta categoria ya esta asignada");
        }
    }

    public void modifyCategory(int categoryId, Gender gender, String description) {
        Category category = searchCategory(categoryId);
        if (category != null) {
            category.setDescription(description);
        }
    }

    public void deleteCategory(int categoryId) {
        Category category = searchCategory(categoryId);
        if (category != null) {
            categories.remove(category);
        }else{
            throw new IllegalArgumentException("la categoria no existe");
        }
    }
}
