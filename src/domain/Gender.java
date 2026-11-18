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
        this.name = name;
    }
}
