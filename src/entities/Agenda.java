package entities;

import java.util.*;

public class Agenda {
    private String agendaOwnerName;
    private Map<String, Contact> contacts = new TreeMap<>();

    public Agenda(String agendaOwnerName) {
        this.agendaOwnerName = agendaOwnerName;
    }

    public String getAgendaOwnerName() {
        return agendaOwnerName;
    }

    public void setAgendaOwnerName(String agendaOwnerName) {
        this.agendaOwnerName = agendaOwnerName;
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public void addContact(String key, Scanner sc){
        if(contacts.containsKey(key)){
            System.out.printf("Contact (%s) already exist!%n", key);
            System.out.println();
            return;
        }
        System.out.print("Email: ");
        String contactEmail = sc.next();
        System.out.print("Phone: ");
        long contactPhone = sc.nextLong();
        contacts.put(key, new Contact(key, contactEmail, contactPhone));
        System.out.printf("Contact (%s) added with success%n", key);
        System.out.println();
    }

    public void editContact(String contactName, Scanner sc){
        if (contacts.containsKey(contactName)){
            System.out.print("New Name: ");
            String editedContactName = sc.next();
            System.out.print("Email: ");
            String editedContactEmail = sc.next();
            System.out.print("Phone: ");
            long editedContactPhone = sc.nextLong();
            System.out.println();
            System.out.println("Editing contact...");
            contacts.remove(contactName);
            contacts.put(editedContactName, new Contact(editedContactName, editedContactEmail, editedContactPhone));
            return;
        }
            System.out.printf("Contact (%s) doesn't exist!%n", contactName);
            System.out.println();
    }

    public void removeContact(String contactKey){
        if(!contacts.containsKey(contactKey)){
            System.out.println("Contact (%s) doesn't exist!%n");
            System.out.println();
            return;
        }
        contacts.remove(contactKey);
        System.out.printf("Removing contact: (%s)...%n", contactKey);
        System.out.println();
    }

    public void printAllContacts(){
        contacts.keySet().stream().map(this::searchContact).forEach(System.out::println);
    }


    public String searchContact(String contactKey) {
        if (!contacts.containsKey(contactKey)){
            return "Contact " + contactKey + " doesn't exist!";
        }
        return contacts.get(contactKey).toString();
    }



    public static String menu(){
        return  "Agenda options: \n" +
                "Type 1 to add a Contact\n" +
                "Type 2 to edit a Contact\n" +
                "Type 3 to remove a Contact\n" +
                "Type 4 to search for a specific Contact\n" +
                "Type 5 to print all Contacts\n" +
                "Type 0 to close the program";
    }

    public String toString() {
    return "The owner of this agenda is" + " " + agendaOwnerName;
    }
}
