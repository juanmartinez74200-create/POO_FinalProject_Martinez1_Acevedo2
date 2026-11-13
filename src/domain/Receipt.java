package domain;

public class Receipt {
    private Sale sale;

    public Receipt(Sale sale){
        setSale(sale);
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
    
}
