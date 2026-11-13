package domain;

public class Customer {
    private int customerId;
    private String name;
    private String PhoneNumber;
    private String email;

    public Customer(int customerId,String name,String phoneNumber,String email){
        setCustomerId(customerId);
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public int getCustomerId(){
        return customerId;
    }
    public void setCustomerId(int customerId){
        this.customerId=customerId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.PhoneNumber=phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
