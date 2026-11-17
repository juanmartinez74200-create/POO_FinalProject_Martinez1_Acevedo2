package domain;

public class Receipt {
    private int receiptId;
    private Sale sale;

    public Receipt(int receiptId,Sale sale){
        setSale(sale);
        setReceiptId(receiptId);
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }
    
}
