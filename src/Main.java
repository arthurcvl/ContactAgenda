import entities.Agenda;
import entities.Contact;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to this Agenda!\nTo start you will need to tell us your name!\n");
        System.out.print("Name: ");
        String agendaOwnerName = sc.nextLine();

        Agenda agenda = new Agenda(agendaOwnerName);
        System.out.println();

        int userChoice;
        do {
            System.out.println(Agenda.menu());
            System.out.println();
            System.out.print("Type here: ");
            userChoice = sc.nextInt();
            switch (userChoice){
                case 1: {
                    System.out.println("Type the contact info: ");
                    System.out.print("Name: ");
                    String contactName = sc.next();
                    System.out.print("Email: ");
                    String contactEmail = sc.next();
                    System.out.print("Phone: ");
                    long contactPhone = sc.nextLong();
                    agenda.addContact(new Contact(contactName, contactEmail, contactPhone));
                    System.out.println();
                    System.out.printf("Contact (%s) added with sucess%n", contactName);
                    System.out.println();
                    break;
                }
                case 2: {
                    // i will have to remade this shit bc it can have 2 contacts with the same name zzz
                    System.out.println("Type the contact name you wanna edit: ");
                    System.out.print("Name: ");
                    String contactName = sc.next();
                    System.out.println();
                    boolean found =  false;
                    for (Contact c : agenda.getContacts()){
                        if(c.getContactName().equals(contactName)){
                            System.out.print("New Name: ");
                            String editedcontactName = sc.next();
                            System.out.print("Email: ");
                            String contactEmail = sc.next();
                            System.out.print("Phone: ");
                            long contactPhone = sc.nextLong();
                            agenda.editContact(c, editedcontactName, contactEmail, contactPhone);
                            System.out.println();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.printf("Contact (%s) not found! ", contactName);
                        System.out.println();
                        break;
                    }
                    break;
                }
                case 3: {
                    System.out.println("Type the contact name you wanna remove: ");
                    System.out.print("Name: ");
                    String contactName = sc.next();
                    boolean found =  false;
                    for (Contact c : agenda.getContacts()) {
                        if (c.getContactName().equals(contactName)) {
                            agenda.removeContact(c);
                            found = true;
                            System.out.println();
                        }
                    }
                    if (!found) {
                        System.out.printf("Contact (%s) not found! %n", contactName);
                        System.out.println();
                        break;
                    }
                    break;
                }
                case 4: {
                    System.out.println("Type the contact name you wanna search: ");
                    System.out.print("Name: ");
                    String contactName = sc.next();
                    System.out.println(agenda.searchContact(contactName));
                    System.out.println();
                    break;
                }
                case 5: {
                    agenda.printAllContacts();
                    System.out.println();
                    break;
                }
            }
        } while(userChoice !=0);

        sc.close();
    }

}