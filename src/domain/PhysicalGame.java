package domain;

public class PhysicalGame extends VideoGame  {
    private int stock;
    
    public enum Condition {
    NEW,
    USED
    }
    private Condition condition;

    // constructor de la clase
    public PhysicalGame(int Id, String title, String developer, int releaseYear, float basePrice,
            Platform platform,Gender gender, boolean activate, int stock, String condition) {
        super(Id, title, developer, releaseYear, basePrice, platform,gender, activate);
        setStock(stock);
       setCondition(Condition.valueOf(condition.toUpperCase())); //recibe NEW o USED
    }

    // getters y setters
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }else{
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        if (condition != null) {
        this.condition = condition;
        } else{
            throw new IllegalArgumentException("se debe seleccionar una condicion");
        }
    }

    public void increaseStock() {
        stock++;    //aumenta el inventario en una unidad
    };

    public void decreaseStock() {
        if (stock > 0) {
            stock--;  //disminuye el inventario si hay unidades disponibles
        }else{
            throw new IllegalArgumentException("no hay videojuegos disponibles");
        }
    };

    @Override 
    public float calculateSellingPrice(){
        float price= calculatePriceAdjusted();   //precio base del videojuego + recargo de la plataforma +  recargo por genero                                               //precio de la plataforma

        if (condition==Condition.USED) {
            return price * 0.95f;       //descuento de el 5% si el videojuego es usado.
        }
        return  price;
    }

}
