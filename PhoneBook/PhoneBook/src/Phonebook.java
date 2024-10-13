
import java.util.HashMap;

class Phonebook {
    HashMap<String, Contact> contactMap = new HashMap<>();

    // Insertion


    // Search


    // Deletion


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



}
