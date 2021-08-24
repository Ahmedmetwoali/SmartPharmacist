/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import ist261.smartpharmacist.User;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Metwoali
 */
public class Patient extends User{
    public Patient (String id, String name){
        super( id, name);
    }
    ArrayList<String> medicationHistory = new ArrayList<>();

    public void requestDrug(){

    }
}
