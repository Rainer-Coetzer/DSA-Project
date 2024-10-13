
import java.util.HashMap;

class Phonebook {
    HashMap<String, Contact> contactMap = new HashMap<>();

    // Insertion
    public void insertContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        contactMap.put(name, contact);
        System.out.println("Contact inserted: " + name);
    }
    // Search


    // Deletion
    public void deleteContact(String name) {
        if (contactMap.containsKey(name)) {
            contactMap.remove(name);
            System.out.println("Contact deleted: " + name);
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Updating
    public void updateContact(String currentName, String newName, String newPhoneNumber) {
        if (contactMap.containsKey(currentName)) {
            Contact contact = contactMap.get(currentName);
            
            // Update the phone number if a new phone number is provided
            if (newPhoneNumber != null && !newPhoneNumber.isEmpty()) {
                contact.phoneNumber = newPhoneNumber;
                System.out.println("Phone number updated for: " + currentName);
            }
    
            // Update the name if a new name is provided
            if (newName != null && !newName.isEmpty() && !newName.equals(currentName)) {
                contactMap.remove(currentName); // Remove the old entry
                contactMap.put(newName, contact); // Add the contact with the new name
                contact.name = newName; //update contact with new name
                System.out.println("Contact name updated from " + currentName + " to " + newName);
            }
    
        } else {
            System.out.println("Contact not found.");
        }
    }
    

    // Display all contacts
    public void displayAllContacts() {
        if (contactMap.isEmpty()) {
            System.out.println("Phonebook is empty.");
        } else {
            for (Contact contact : contactMap.values()) {
                System.out.println("Name: " + contact.name + ", Phone Number: " + contact.phoneNumber);
            }

    }
}
