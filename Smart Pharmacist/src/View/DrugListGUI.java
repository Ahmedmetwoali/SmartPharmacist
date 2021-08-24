/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.DrugListController;
import Model.Drug;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Model.DrugTableModel;
/**
 *
 * @author Ahmed Metwoali
 */
public class DrugListGUI extends JFrame{
    private JPanel tablePanel, buttonPanel;
    private JButton doneButton, deleteButton, newButton, detailsButton;
    private DrugTableModel drugTableModel;
    private DrugListController drugListController;
    private JTable drugTable;
    private JScrollPane tableScroller;
    private Drug drug;
    
    public DrugListGUI(DrugListController drugListController){
        this.drugListController = drugListController;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    }
    public void initComponents(){
        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1,4));
        drugTable = new JTable(drugListController.getDrugTableModel());
        drugTable.getColumnModel().getColumn(0).setPreferredWidth(15);
        drugTable.getColumnModel().getColumn(1).setPreferredWidth(75);
        drugTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        doneButton = new JButton("Done");
        doneButton.addActionListener(e-> System.exit(0));
        detailsButton = new JButton("Show Details");
        newButton = new JButton("New");
        newButton.addActionListener(e -> {
            drug = new Drug("update generic name", "update brand name", 0);
            drugListController.getDrugsArrayList().add(drug);
            drugListController.getDrugList().writeDrugsListFile();
            drugListController.getDrugTableModel().fireTableDataChanged();
        });
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e->{
            int selectedTableRow = drugTable.getSelectedRow();
            int selectedModelRow = drugTable.convertRowIndexToModel(selectedTableRow);
            if(selectedModelRow <0) selectedModelRow = 0;
            drugListController.getDrugsArrayList().remove(selectedModelRow);
            drugListController.getDrugList().writeDrugsListFile();
            drugListController.getDrugTableModel().fireTableDataChanged();
        });
        detailsButton.addActionListener(new DetailsButtonListener());
        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(doneButton);
        buttonPanel.add(deleteButton);
        tableScroller = new JScrollPane(drugTable);
        drugTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(350, 300));
        tablePanel.add(tableScroller);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
    }
    public class DetailsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt){
            int selectedTableRow = drugTable.getSelectedRow();
            int selectedModelRow = drugTable.convertRowIndexToModel(selectedTableRow);
            DrugListGUI.this.drugListController.getDrugDetailUI(selectedModelRow);
        }
    }
}
