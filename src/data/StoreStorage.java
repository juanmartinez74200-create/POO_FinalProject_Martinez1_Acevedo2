package data;

import java.io.*;
import domain.Store;

public class StoreStorage {
    public static void save(Store store, String filename) {
        try (ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            ObjectOutputStream.writeObject(store);
            System.out.println("Store data saved successfully");
        } catch (Exception e) {
            System.err.println("Error saving store data :" + e.getMessage());
        }
    }

    public static Store load(String filename) {
        try (ObjectInputStream ObjectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (Store) ObjectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading store data :" + e.getMessage());
            return null;
        }
    }
}
