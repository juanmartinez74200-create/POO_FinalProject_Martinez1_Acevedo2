package domain;

public class Platform {
    private final int platformId;
    private String name;
    private float price;


    public Platform(int platformId,String name, float price){
    this.platformId=platformId;
       setName(name); 
       setPrice(price);
    }
    

    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name != null && !name.trim().isEmpty()){
        this.name= name;
        } else {
            throw new IllegalArgumentException("el nombre de la plataforma es obligatorio");
        }
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        if (price >= 0) {
        this.price = price;
        } else{ 
            throw new IllegalArgumentException ("el precio no puede ser negativo");
        }
    }


    public int getplatformId() {
        return platformId;
    }


}
