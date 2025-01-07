package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
    private String agendaOwnerName;
    private List<Contact> contacts = new ArrayList<>();

    public Agenda(String agendaOwnerName) {
        this.agendaOwnerName = agendaOwnerName;
    }

    public String getAgendaOwnerName() {
        return agendaOwnerName;
    }

    public void setAgendaOwnerName(String agendaOwnerName) {
        this.agendaOwnerName = agendaOwnerName;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public void editContact(Contact contact, String contactName, String contactEmail, long contactPhone){
        if (contacts.contains(contact)){
            System.out.println("Editing contact...");
            contact.updateContact(contactName, contactEmail, contactPhone);

        }
        else{
            System.out.printf("Contact (%s) not found%n", contact.getContactName());
        }
    }

    public void removeContact(Contact contact){
        contacts.remove(contact);
    }

    public void printAllContacts(){
        for (Contact c : contacts){
            System.out.println(c);
        }
    }

    public String searchContact(String contactName){
        for (Contact contact : contacts){
            if (contact.getContactName().equals(contactName)){
                return contact.toString();
            }
        }
        return "Contact not found";

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
