package domain;

public class Customer extends Person{
   
    private String phoneNumber;
    private String email;

    public Customer(int id,String name,String phoneNumber,String email){    
        super(id, name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
