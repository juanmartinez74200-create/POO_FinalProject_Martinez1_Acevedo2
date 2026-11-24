package domain;

import java.io.Serializable;

public class Gender implements Serializable{
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
        if (surchargePercentage >=0) {
        this.surchargePercentage=surchargePercentage;
        }else{
            throw new IllegalArgumentException("El porcentaje adicional no puede ser negativo");
        }
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
