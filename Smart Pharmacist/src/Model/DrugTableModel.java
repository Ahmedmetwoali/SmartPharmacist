/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ahmed Metwoali
 */
public class DrugTableModel extends AbstractTableModel{
    
    private String[]  columnNames ={"Drug Name" , "Generic Name" , "maximum Dose"};
    
    private ArrayList<Drug> drugList;
    
    public DrugTableModel(ArrayList<Drug> newDrugList){
    drugList = newDrugList;
    }

    @Override
    public int getRowCount() {
        return  drugList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return (Object) drugList.get(rowIndex).getBrandName();
            case 1 : return (Object) drugList.get(rowIndex).getGenericName();
            case 2 : return (Object) drugList.get(rowIndex).getMaxDose();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
}
