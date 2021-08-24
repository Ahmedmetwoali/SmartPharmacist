/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Drug;
import Model.DrugList;
import Model.DrugTableModel;
import View.DrugGUI;
import View.DrugListGUI;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Metwoali
 */
public class DrugListController {
   private DrugList drugList = new DrugList();
   
   // private ArrayList<Address> addresses;
    private DrugTableModel drugTableModel;
    private DrugGUI drugGUI;
    private DrugListGUI drugListGUI;
    private Controller controller;
    public DrugListController(){
        drugTableModel = new DrugTableModel(drugList.getDrugList());
        drugListGUI = new DrugListGUI(this);
        drugListGUI.setVisible(true);
    }
    public DrugTableModel getDrugTableModel(){
        return drugTableModel;
    }
    public ArrayList<Drug> getDrugsArrayList(){
        return drugList.getDrugList();
    }
    public DrugList getDrugList(){
        return drugList;
    }
    public void getDrugDetailUI(int selectedRow){
        controller = new Controller(this,selectedRow);
    }
  
     
}
