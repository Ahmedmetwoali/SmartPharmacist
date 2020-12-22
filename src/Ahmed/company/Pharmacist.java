package Ahmed.company;
import java.util.Scanner;

public class Pharmacist extends User {
    Pharmacist(int id){
        setUserId(id);
        System.out.println("Please enter pharmacist name: ");
        String pName = input.nextLine();
        setUserName(pName);
    }
    Scanner input = new Scanner(System.in);

}
