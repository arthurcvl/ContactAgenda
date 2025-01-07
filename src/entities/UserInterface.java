package entities;

import java.util.Scanner;

public class UserInterface {


    public static Agenda initializeAgenda(Scanner sc){
        System.out.println("Welcome to this Agenda!\nTo start you will need to tell us your name!\n");
        System.out.print("Name: ");
        String agendaOwnerName = sc.nextLine();
        System.out.println();

        return new Agenda(agendaOwnerName);
    }


    public static void userMethodCaller(Scanner sc, Agenda agenda, int userChoice){
        switch (userChoice){
            case 1: {
                System.out.println("Type the contact info: ");
                System.out.print("Nickname *2 Users cant have the same nickname* : ");
                String contactName = sc.nextLine();
                agenda.addContact(contactName, sc);
                break;
            }
            case 2: {
                System.out.println("Type the contact name you wanna edit: ");
                System.out.print("Nickname: ");
                String contactName = sc.nextLine();


                System.out.println();
                agenda.editContact(contactName, sc);


                break;
            }
            case 3: {
                System.out.println("Type the contact name you wanna remove: ");
                System.out.print("Name: ");
                String contactName = sc.next();
                System.out.println();
                agenda.removeContact(contactName);

                break;
            }
            case 4: {
                System.out.println("Type the contact name you wanna search: ");
                System.out.print("Name: ");
                String contactName = sc.next();
                System.out.println();
                System.out.println(agenda.searchContact(contactName));
                System.out.println();
                break;
            }
            case 5: {
                System.out.println();
                agenda.printAllContacts();
                System.out.println();
                break;
            }
            default: {
                System.out.println();
            }
        }
    }

}
