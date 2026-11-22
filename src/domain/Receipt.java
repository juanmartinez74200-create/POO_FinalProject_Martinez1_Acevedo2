package domain;

import java.io.Serializable;

public class Receipt implements Serializable{
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
        if (sale != null) {
        this.sale = sale;
        } else {
            throw new IllegalArgumentException("el recibo debe estar asociada a una venta");
        }
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }
    
}
