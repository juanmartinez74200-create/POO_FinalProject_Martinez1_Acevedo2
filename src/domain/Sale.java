package domain;

public class Sale {
    private int saleId;
    private int amount;
    private Employee employee;
    private Customer customer;
    

    // constructor
    public Sale(int saleId, int amount, Employee employee, Customer customer) {
        setSaleId(saleId);
        setAmount(amount);
        setEmployee(employee);
        setCustomer(customer);

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
        this.amount = amount;
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


  public float totalPurchase(){

  }

}
