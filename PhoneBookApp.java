/**
 * Represents a single contact in the phonebook.
 * Each contact stores a name, a phone number, and a reference
 * to the next contact in the linked list.
 */
class Directory {
    String name;
    String phoneNumber;
    Directory next;

    public Directory(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }
}
/**
 * Manages the phonebook linked list.
 * Provides methods to add contacts and display the list.
 */
class PhoneBookManager { 
    private Directory head;

    public PhoneBookManager() {
        head = null;
    }
/**
     * Adds a new contact to the end of the list.
     * Traverses from head to the last node and appends the new contact.
     * @param name - contact's name
     * @param phoneNumber - contact's phone number
     */
    public void add(String name, String phoneNumber) {
        Directory newContact = new Directory(name, phoneNumber);
        if (head == null) {
            head = newContact;
        } else {
            Directory current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newContact;
        }
    }
/**
     * Displays all contacts in the phonebook.
     * Iterates through each node from head to last node.
     */
    public void displayContacts() {
        Directory current = head; //starting point(head) of the linked list
        while (current != null) {
            System.out.println("Name: " + current.name + ", Phone: " + current.phoneNumber);
            current = current.next;
        }
    }
}
/**
 * Main program to demonstrate the PhoneBookManager.
 * Creates a phonebook, adds some contacts, and displays them.
 */

public class PhoneBookApp {
    public static void main(String[] args) {

        PhoneBookManager phoneBook = new PhoneBookManager();

        phoneBook.add("Felix", "111-2200");
        phoneBook.add("Obama", "333-4489");
        phoneBook.add("Daniel", "253-6645");

        phoneBook.displayContacts();
    }
}