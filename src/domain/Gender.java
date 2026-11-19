package domain;

public class Gender {
    private final int genderId;
    private String name; 

    public Gender (int genderId,String name){
        this.genderId=genderId;
        setName(name);
    }
    
    public int getGenderId(){
        return genderId;
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
