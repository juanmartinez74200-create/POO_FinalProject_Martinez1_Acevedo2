package domain;

//import java.util.concurrent.locks.Condition; //ya tenemos un propio enum condition ¿eliminiar?

public class PhysicalGame extends VideoGame {
    private int stock;
    public enum Condition {
    NEW,
    USED
    }
    private Condition condition;

    // constructor de la clase
    public PhysicalGame(int Id, String title, String developer, int releaseYear, float basePrice,
            Platform platform, boolean activate, int stock, String condition) {
        super(Id, title, developer, releaseYear, basePrice, platform, activate);
        setStock(stock);
       setCondition(Condition.valueOf(condition.toUpperCase())); //recibe NEW o USED
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
        float price= getBasePrice() + calculateBasePrice();   //precio base del videojuego + precio de la plataforma                                                //precio de la plataforma

        if (condition==Condition.USED) {
            return price * 0.95f;       //descuento de el 5% si el videojuego es usado.
        }
            return  price;
    }

    public String gameFormat(){
        return "Fisico";
    };
}
