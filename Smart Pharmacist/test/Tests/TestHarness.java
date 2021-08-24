/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Model.Drug;
import Model.Patient;
import ist261.smartpharmacist.Pharmacist;
import ist261.smartpharmacist.User;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Metwoali
 */
public class TestHarness {

        public TestHarness() {

            // Test the instrument class
            Pharmacist p1 = new Pharmacist("1111", "Joe");
            if(p1 != null){
                System.out.println("Test Pharmacist created successfully");
                System.out.println("Pharmacist info: "+p1.getName()+" "+p1.getId());
                //Change the object
                p1.setId("1122");
                System.out.println("Pharmacist new info: "+p1.getName()+" "+p1.getId());
            }
            Drug ibuprofen = new Drug("ib1234","Advil",500);
            int ibuprofenDose = 600;
            if((ibuprofen.maxDose() > ibuprofenDose) && (ibuprofen != null)){
                System.out.println("Dosage test created successfully");
                System.out.println("Maximum ibuprofen daily dose is : "+ibuprofen.maxDose());
            }else {
                System.out.println("You're about to inhale an overdose of ibuprofen.");
            }

            }
        public static void testClassHierarchy(){
            ArrayList<User> users = new ArrayList<>();
            Pharmacist pharmacist1 = new Pharmacist("1","Ahmed");
            Patient patient1 = new Patient("2","Joe");

            users.add(pharmacist1);
            users.add(patient1);

            for (User user :users){
                System.out.println(user);
            }
            }
        }

