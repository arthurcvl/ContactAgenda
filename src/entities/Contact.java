package entities;

public class Contact {
    private String contactName;
    private String contactEmail;
    private long contactPhone;

    public Contact(String contactName, String contactEmail, long contactPhone){
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }


    @Override
    public String toString() {
        return String.format("Contact:%nName - %s%nEmail - %s%nPhone - %d%n", contactName, contactEmail, contactPhone );
    }
}
