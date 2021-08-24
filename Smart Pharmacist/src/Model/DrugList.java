/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Metwoali
 */
public class DrugList {
        ArrayList<Drug> drugList = new ArrayList<>();
        private String listOf_OTC_FileName = "OTC_List.ser";
    
        public DrugList(){
            this.readDrugListFile();
            
            if (drugList.isEmpty() || drugList == null){
            this.createNewDrugList();
            this.writeDrugsListFile();
            this.readDrugListFile();
            }
            
            this.printDrugList();
            
    }
    

    public void createNewDrugList(){
        Drug d1 = new Drug("Acetaminophen","Tylenol",1000);
        Drug d2 = new Drug("Ibuprofen","ibuprofen",500);
        Drug d3 = new Drug("Ibuprofen","advil",300);
        Drug d4 = new Drug("Aleve","Aleve",700);

        drugList.add(d1);
        drugList.add(d2);
        drugList.add(d3);
        drugList.add(d4);

    }
    public ArrayList<Drug> getDrugList(){
        return drugList;
    }
    public void setDrugList(ArrayList<Drug> drugList){
        this.drugList = drugList;
    }
    public void readDrugListFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOf_OTC_FileName);
            in = new ObjectInputStream(fis);
            drugList = (ArrayList<Drug>) in.readObject();
            in.close();
            
            if(!drugList.isEmpty()){
                System.out.println("These are the drugs on file.");
            }
        } catch (Exception e) {
        }
    }
    public void writeDrugsListFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOf_OTC_FileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(drugList);
            out.close();
        } catch (Exception e) {
        }
    }
    public void printDrugList(){
        for(Drug d : drugList){
            System.out.println(d);
        }
        
    }
}
