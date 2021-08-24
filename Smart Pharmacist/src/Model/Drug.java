/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.LinkedList;
import Model.DrugLinkedList;

/**
 *
 * @author Ahmed Metwoali
 */
public class Drug implements Serializable{
    public Drug(String genericName, String _brandName, int _maxDose){
        this.genericName = genericName;
        this.brandName = _brandName;
        this.maxDose = _maxDose;
    }
    private int maxDose;
    private String genericName;
    private String brandName;
    private LinkedList <Drug> drugLinkedList = new LinkedList<>();

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String _id) {
        this.genericName = _id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String _brandName) {
        this.brandName = _brandName;
    }

    @Override
    public String toString(){
        return "genericName: "+getGenericName()+ "\nBrand name: "+getBrandName() +"\nMaximum daily dose: " + getMaxDose();
    }

    public int getMaxDose() {
        return maxDose;
    }

    public void setMaxDose(int maxDose) {
        this.maxDose = maxDose;
    }

    public int maxDose(){
        return maxDose;
    }
    
    
    public boolean decideToInsert(Drug d){
        boolean decision = false;
        
        if(d.maxDose < this.maxDose){
        return true;
        }
        
        return decision;
    }
}
