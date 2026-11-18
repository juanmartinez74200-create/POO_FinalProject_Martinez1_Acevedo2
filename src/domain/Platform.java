package domain;

public class Platform {
    private String name;
    private float price;


    public Platform(String name, float price){
       setName(name); 
       setPrice(price);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name= name; 
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }


}
