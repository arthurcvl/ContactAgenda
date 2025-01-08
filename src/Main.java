import entities.Agenda;
import entities.Contact;
import entities.UserInterface;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userChoice = 0;
        Agenda agenda = UserInterface.initializeAgenda(sc);

        do {
            try {
                agenda.importContacts();
                System.out.println(Agenda.menu());
                System.out.println();
                System.out.print("Type here: ");
                userChoice = sc.nextInt();
                sc.nextLine();
                UserInterface.userMethodCaller(sc, agenda, userChoice);
                agenda.exportContacts();
            } catch (InputMismatchException e){
                System.out.println("Invalid Input!");
                sc.nextLine();
                System.out.println();
                userChoice = 1;
                agenda.exportContacts();
            } catch (IOException e) {
                userChoice = 0;
            } catch (NumberFormatException e){
                userChoice = 1;
            }
        } while (userChoice != 0);
        sc.close();
    }
}
