package entities;

public class Contact {
    private String contactName;
    private String contactEmail;
    private long contactPhone;

    public Contact(String contactName, String contactEmail, long contactPhone) {
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public void updateContact(String contactName, String contactEmail, long contactPhone) {
        setContactName(contactName);
        setContactEmail(contactEmail);
        setContactPhone(contactPhone);
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public long getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(long contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return  "Contact Name='" + contactName + '\'' +
                ", Contact Email='" + contactEmail + '\'' +
                ", Contact Phone=" + contactPhone;
    }
}
