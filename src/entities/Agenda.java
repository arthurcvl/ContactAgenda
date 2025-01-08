package entities;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Agenda {
    private Map<String, Contact> contacts = new TreeMap<>();

    public Agenda() {
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
            System.out.printf("Contact (%s) doesn't exist!%n", contactKey);
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

    public void importContacts() throws IOException{
        try {
            String path = "put/the/a/file/path";
            File file = new File(path);
            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                    String line = br.readLine();
                    while (line != null) {
                        String[] set = line.split(",");
                        contacts.put(set[0], new Contact(set[0], set[1], Integer.parseInt(set[2])));
                        line = br.readLine();
                    }
                }
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("redacted");
        }
    }

    public void exportContacts(){
        String path = "put/the/same/file/path";
        try(BufferedWriter br = new BufferedWriter(new FileWriter(path))) {
            if(contacts != null){
                for(String key :  contacts.keySet()){
                    Contact contact = contacts.get(key);
                    br.write(contact.getContactName() + "," + contact.getContactEmail() + "," + contact.getContactPhone() + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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

}
