package domain;

public class Gender {
    private String name; 

    public Gender (String name){
        setName(name);
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
