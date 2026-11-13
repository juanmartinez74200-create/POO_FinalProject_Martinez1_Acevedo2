package domain;

import java.util.ArrayList;

public class Store {
    private static String storeName;
    private int id;
    private ArrayList<Sale> sales;

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

    public void registerVideoGame() {
    };

    public void SearchVideoGame() {
    };

    public void listVideoGame() {
    };

    public void modifyVideoGame() {
    };

    public void deleteVideoGame() {
    };

}
