package domain;

public class Gender {
    private final int genderId;
    private String name; 
    private float surchargePercentage;

    public Gender (int genderId,String name,float surchargePercentage){
        this.genderId=genderId;
        setName(name);
        setSurchargePercentage(surchargePercentage);
    }
    
    public int getGenderId(){
        return genderId;
    }
    public float getSurchargePercentage(){
        return surchargePercentage;
    }
    public void setSurchargePercentage(float surchargePercentage){
        this.surchargePercentage=surchargePercentage;
    }

    public String getName(){
        return name;
    }

    public void setName (String name){
        if(name != null && !name.trim().isEmpty()){
        this.name= name;
        } else {
            throw new IllegalArgumentException("el nombre del genero es obligatorio");
        }
    }  
}
