package domain;

import java.io.Serializable;

public class Employee extends Person implements Serializable{

    // constructor
    public Employee(int id,String name){
     super(id, name);
    }

}
