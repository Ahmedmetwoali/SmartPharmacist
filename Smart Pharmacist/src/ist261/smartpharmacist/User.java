/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist261.smartpharmacist;

/**
 *
 * @author Ahmed Metwoali
 */
public class User {
       public User(String id, String name){
        this.id = id;
        this.name = name;
    }

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString(){
        return "Id: "+getId() + "\nname: "+getName();
    }


}


