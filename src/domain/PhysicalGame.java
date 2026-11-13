package domain;

public class PhysicalGame extends VideoGame {
    private int stock;
    private String condition;

    // constructor de la clase
    public PhysicalGame(int gameId, String title, String developer, int releaseYear, float basePrice,
            Plataform plataform, boolean activate, int stock, String condition) {
        super(gameId, title, developer, releaseYear, basePrice, plataform, activate);
        setStock(stock);
        setCondition(condition);
    }

    // getters y setters
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void increaseStock() {
    };

    public void decreaseStock() {
    };

}
