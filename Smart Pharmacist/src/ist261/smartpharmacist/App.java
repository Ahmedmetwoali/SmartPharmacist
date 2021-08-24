/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist261.smartpharmacist;

import Controller.DrugListController;
import Model.DrugLinkedList;
import java.util.HashMap;

/**
 *
 * @author Ahmed Metwoali
 */
public class App {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        DrugListController Controller = new DrugListController();
        DrugLinkedList drugLinkedList = new DrugLinkedList();
        
        
        HashMap<String, String> drugHashMap = new HashMap<String, String>();
        drugHashMap.put("Tylenol", "Acetaminophen");
        drugHashMap.put("Ibuprofen", "Ibuprofen");
        drugHashMap.put("Aleve", "Aleve");
        
        System.out.println("Printing all drugs Brand names in the HashMap");
        
        for (String i : drugHashMap.keySet()) {
            System.out.println(i);
        }
    
         System.out.println("Printing all drugs Generic names in the HashMap");
        
        for (String i : drugHashMap.values()) {
            System.out.println(i);
        }
        System.out.println("Printing all items in the HashMap");
        System.out.println(drugHashMap);
        
        System.out.println("Print items in the HashMap after removing 'Tylenol'.");
        drugHashMap.remove("Tylenol");
        System.out.println(drugHashMap);
        
        
    }
}
