package domain;

import java.io.Serializable;

public class Person implements Serializable {

    private int id;
    private String name;

    public Person(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id >= 0){
            this.id = id;
        }else{
            throw new IllegalArgumentException("El id no puede ser negativo");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
    }
}

