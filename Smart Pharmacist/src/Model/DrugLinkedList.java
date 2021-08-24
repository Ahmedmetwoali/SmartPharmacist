/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author ahmedmetwoali
 */
public class DrugLinkedList {
    public LinkedList <Drug> drugLinkedList = new LinkedList<>();
    
    public DrugLinkedList(){
       createDrugLinkedList();
       printDrigLinkedList();
    }
    public void createDrugLinkedList (){
        addDrug(new Drug ("Cometrix","oxiton",700));
        addDrug(new Drug ("Cometrix","oxiton",400));
        addDrug(new Drug ("Cometrix","oxiton",500));
        addDrug(new Drug ("Cometrix","oxiton",600));

        for (int i = 0 ; i < 3 ; i++){
            addDrug(new Drug("e","e",1000));
        }
    }
    public void addDrug(Drug newDrug){
        boolean drugAdded = false;
        boolean insertDecision = false;
        ListIterator <Drug> drugIterator = drugLinkedList.listIterator();
        
        while (drugIterator.hasNext()) {
            insertDecision = drugIterator.next().decideToInsert(newDrug);
            if (insertDecision == true) {
            drugLinkedList.add(drugIterator.previousIndex(), newDrug);
            drugAdded = true;
            break;
            }
        }
        if(!drugAdded){
            drugLinkedList.add(newDrug);
        }
    }
    
    public void printDrigLinkedList(){
        ListIterator <Drug> drugIterator = drugLinkedList.listIterator();
        while (drugIterator.hasNext()) {
            System.err.println(drugIterator.next().toString());            
        }
    }

}
