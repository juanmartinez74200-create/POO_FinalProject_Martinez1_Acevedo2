package domain;

import java.io.Serializable;

public class Customer extends Person implements  Serializable{
   
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
        if(phoneNumber != null && !phoneNumber.trim().isEmpty()){
        this.phoneNumber=phoneNumber;
        } else {
            throw new IllegalArgumentException("el numero de telefono es obligatorio");
        }
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
       if(email != null && !email.trim().isEmpty()){
        this.email=email;
        } else {
            throw new IllegalArgumentException("el email es obligatorio");
        } 
    }
}
