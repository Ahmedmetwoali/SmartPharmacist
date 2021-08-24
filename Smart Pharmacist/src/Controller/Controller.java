/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Drug;
import Model.DrugList;
import View.DrugGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 *
 * @author Ahmed Metwoali
 */
public class Controller implements ActionListener{
    private DrugGUI drugGUI;
    private DrugList drugList = new DrugList();
    private ArrayList<Drug> drugs;
    private DrugListController drugListController;
    private int currentRow;
    public Controller(){
        drugs = drugList.getDrugList();
        drugGUI = new DrugGUI(drugs);
        addButtons();
        drugGUI.setVisible(true);
    }
    public Controller(DrugListController listController, ArrayList<Drug> druglist){
        this.drugListController = listController;
        drugs = druglist;
        drugGUI = new DrugGUI(drugs);
        addButtons();
        drugGUI.setVisible(true);
    }
    public Controller(DrugListController drugListController, int row){
        currentRow = row;
        this.drugListController = drugListController;
        drugs = drugList.getDrugList();
        drugGUI = new DrugGUI(this, row);
        addButtons();
        drugGUI.setVisible(true);
    }
     public DrugList getDrugList(){
        return drugList;
    }
    public void addButtons(){
        drugGUI.btnUpdate.addActionListener(this);
        drugGUI.btnDelete.addActionListener(this);
        drugGUI.nextBtn.addActionListener(this);
        drugGUI.prevBtn.addActionListener(this);
       
    }
    public Drug getDrug(int row){
        drugs = drugListController.getDrugsArrayList();
        return drugs.get(row);
    }
    public void getDrugDetailUI(int selectedRow){
        drugGUI = new DrugGUI(this,selectedRow);
        drugGUI.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == drugGUI.btnDelete){
            if(drugs.size() != 0){
                drugs.remove(currentRow);
                drugGUI.setupUIFields(drugs.get(currentRow));
                drugList.writeDrugsListFile();
                drugListController.getDrugTableModel().fireTableDataChanged();
            }
        }
        if(obj == drugGUI.nextBtn){
            if(currentRow == drugs.size()-1)
                currentRow = 0;
            else
                currentRow ++;
            drugGUI.setupUIFields(drugs.get(currentRow));
        }
        if(obj == drugGUI.prevBtn){
            if(currentRow == 0)
                currentRow = drugs.size()-1;
            else
                currentRow --;
            drugGUI.setupUIFields(drugs.get(currentRow));
        }
        if(obj ==drugGUI.btnUpdate){
            drugs.get(currentRow).setBrandName(drugGUI.getBrandName());
            drugs.get(currentRow).setGenericName(drugGUI.getGenericName());
            drugs.get(currentRow).setMaxDose(drugGUI.getMaxDose());
            drugList.setDrugList(drugs);
            drugList.writeDrugsListFile();
            drugListController.getDrugTableModel().fireTableDataChanged();
        }
    }
    
}

