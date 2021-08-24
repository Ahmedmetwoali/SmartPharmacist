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
public class Pharmacist extends User {
    
   public Pharmacist(String id, String name) {
        super(id, name);
    }
    public void scanMedication(){

    }
    @Override
    public String toString(){
        return "Id: "+getId() + "\nname: "+getName();
    }
}