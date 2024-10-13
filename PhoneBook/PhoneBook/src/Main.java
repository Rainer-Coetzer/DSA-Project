

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Phonebook myphonebook = new Phonebook();
        Scanner sc = new Scanner(System.in);
        int operation = 0;

        while (operation != -1) {
            try {
                System.out.println("Input an operation (0 - Insert, 1 - Search, 2 - Delete, 3 - Display, 4 - Update, -1 to Exit):");
                operation = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (operation) {
                    case 0:
                        String name = getInputWithConfirmation(sc, "name");
                        if (name == null) break;

                        String phoneNumber = getInputWithConfirmation(sc, "phone number");
                        if (phoneNumber == null) break;

                        myphonebook.insertContact(name, phoneNumber);
                        System.out.println("Contact inserted.");
                        break;

                    case 1:
                        System.out.println("Give a name to search (or type '1' to cancel): ");
                        String search = sc.nextLine();
                        if (!search.equals("1")) {
                            Contact contact = myphonebook.searchContact(search);
                            if (contact != null) {
                                System.out.println("Found: Name: " + contact.name + ", Phone Number: " + contact.phoneNumber);
                            } else {
                                System.out.println("Contact not found.");
                            }
                        }
                        break;

                    case 2:
                        System.out.println("Give a name to delete (or type '1' to cancel): ");
                        String delete = sc.nextLine();
                        if (!delete.equals("1")) {
                            System.out.println("Are you sure you want to delete " + delete + "? (y/n or 'exit' to cancel): ");
                            String confirmation = sc.nextLine().toLowerCase();

                            if (confirmation.equals("y")) {
                                myphonebook.deleteContact(delete);
                                System.out.println("Contact deleted.");
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Displaying all contacts:");
                        myphonebook.displayAllContacts();
                        break;

                    case 4:
                        System.out.println("Give the current name to update (or type '1' to cancel): ");
                        String currentName = sc.nextLine();
                        if (!currentName.equals("1")) {
                            String newName = getInputWithConfirmation(sc, "new name (leave empty to keep unchanged)");
                            String newPhoneNumber = getInputWithConfirmation(sc, "new phone number (leave empty to keep unchanged)");

                            if (newName != null || newPhoneNumber != null) {
                                myphonebook.updateContact(currentName, newName, newPhoneNumber);
                                System.out.println("Contact updated.");
                            }
                        }
                        break;

                    case -1:
                        System.out.println("Exiting phonebook...");
                        break;

                    default:
                        System.out.println("Invalid operation. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error has occurred. Please review your input and try again.");
                sc.nextLine(); // Clear the invalid input
            }
        }

        sc.close();
    }

    // Helper method to get input with confirmation
    private static String getInputWithConfirmation(Scanner sc, String inputType) {
        String input;
        String confirmation;
        while (true) {
            System.out.println("Input " + inputType + ": ");
            input = sc.nextLine();

            while (true) {
                System.out.println("Are you sure about your " + inputType + ", " + input + "? (y/n or type 'exit' to cancel): ");
                confirmation = sc.nextLine().toLowerCase();

                if (confirmation.equals("y")) {
                    return input;
                } else if (confirmation.equals("exit")) {
                    return null;
                } else if (confirmation.equals("n")) {
                    break; // Re-enter the input
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            }
        }
    }
}
