package domain;

public class Sale {
    private int saleId;
    private int amount;
    private Employee employee;
    private Customer customer;
    private VideoGame videoGame;
    

    // constructor
    public Sale(int saleId, int amount, Employee employee, Customer customer, VideoGame videoGame) {
        setSaleId(saleId);
        setAmount(amount);
        setEmployee(employee);
        setCustomer(customer);
        setVideoGame(videoGame);
    }
    

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount > 0) {      //valida que la cantidad sea mayor a cero
            this.amount = amount;
        }else{
            throw new IllegalArgumentException ("la cantidad debe ser mayor a cero");
        }
        
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public VideoGame getVideoGame(){
        return videoGame;
    }

    public void setVideoGame(VideoGame videoGame){
        if (videoGame != null) {     //valida que se haya seleccionado un videojuego antes de realizar la venta.
             this.videoGame = videoGame;
        } else {
            throw new IllegalArgumentException ("debe seleccionar un videojuego");
        }
    }

    //calcular la venta total multiplicando la cantidad de unidades por el precio del videojuego
  public float totalPurchase(){
    return amount * videoGame.calculateSellingPrice();
  }

}
