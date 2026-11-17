package domain;

import java.util.concurrent.locks.Condition;

public class PhysicalGame extends VideoGame {
    private int stock;
    public enum Condition {
    NEW,
    USED
    }
    private Condition condition;

    // constructor de la clase
    public PhysicalGame(int Id, String title, String developer, int releaseYear, float basePrice,
            Plataform plataform, boolean activate, int stock, String condition) {
        super(Id, title, developer, releaseYear, basePrice, plataform, activate);
        setStock(stock);
       setCondition(getCondition());
    }

    // getters y setters
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void increaseStock() {
    };

    public void decreaseStock() {
    };

    @Override 
    public float calculateSellingPrice(){
        if (condition==Condition.NEW) {
            return calculateBasePrice()*
        }

    }

    public String gameFormat(){
        return "Fisico";
    };
}
