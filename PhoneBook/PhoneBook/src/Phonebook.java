
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
        
    // Group contacts under a single group name using a HashMap
    public void groupContacts(String groupName, String[] contactNames) {
        HashMap<String, Contact> groupContacts = new HashMap<>();

        for (String name : contactNames) {
            if (contactMap.containsKey(name)) {
                groupContacts.put(name, contactMap.get(name));
            } else {
                System.out.println("Contact not found: " + name);
            }
        }

        if (!groupContacts.isEmpty()) {
            groupMap.put(groupName, groupContacts);
            System.out.println("Contacts added to group: " + groupName);
        } else {
            System.out.println("No contacts added to group.");
        }
    }

    // Search for contacts by group name using HashMap
    public void searchContactsByGroup(String groupName) {
        if (groupMap.containsKey(groupName)) {
            HashMap<String, Contact> groupContacts = groupMap.get(groupName);
            System.out.println("Contacts in group: " + groupName);
            for (Contact contact : groupContacts.values()) {
                System.out.println("Name: " + contact.name + ", Phone Number: " + contact.phoneNumber);
            }
        } else {
            System.out.println("Group not found: " + groupName);
        }
    }

    // Insert a contact into a specific group
    public void insertIntoGroup(String name, String groupName) {
        // Check if contact exists in contactMap
        if (contactMap.containsKey(name)) {
            // Check if the group already exists
            if (!groupMap.containsKey(groupName)) {
                // Create the group if it doesn't exist
                groupMap.put(groupName, new HashMap<>());
            }

            // Add the contact to the group
            groupMap.get(groupName).put(name, contactMap.get(name));
            System.out.println("Contact " + name + " added to group: " + groupName);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    // Delete an entire group from groupMap
    public void deleteGroup(String groupName) {
        // Check if the group exists
        if (groupMap.containsKey(groupName)) {
            // Remove the group from the groupMap
            groupMap.remove(groupName);
            System.out.println("Group deleted: " + groupName);
        } else {
            // If the group doesn't exist, print an error message
            System.out.println("Group not found: " + groupName);
        }
    }

    // Delete a contact from a specific group
    public void deleteFromGroup(String name, String groupName) {
        // Check if the group exists in groupMap
        if (groupMap.containsKey(groupName)) {
            // Get the group contacts
            HashMap<String, Contact> groupContacts = groupMap.get(groupName);

            // Check if the contact exists in the group
            if (groupContacts.containsKey(name)) {
                // Remove the contact from the group
                groupContacts.remove(name);
                System.out.println("Contact " + name + " removed from group: " + groupName);

                // If the group becomes empty after removal, you may choose to delete the group
                if (groupContacts.isEmpty()) {
                    groupMap.remove(groupName);
                    System.out.println("Group " + groupName + " is now empty and has been removed.");
                }
            } else {
                System.out.println("Contact not found in group: " + groupName);
            }
        } else {
            System.out.println("Group not found: " + groupName);
        }
    }
}
