// MemberListBST.java
public class MemberListBST {

    // Node class for BST
    private class Node {
        Member data;
        Node left, right;

        Node(Member data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public MemberListBST() {
        root = null;
    }

    // ----------- INSERTION -----------
    public void addMember(Member m) {
        root = insert(root, m);
    }

    private Node insert(Node node, Member m) {
        if (node == null) return new Node(m);

        if (m.compareTo(node.data) < 0) {
            node.left = insert(node.left, m);
        } else {
            node.right = insert(node.right, m);
        }
        return node;
    }

    // ----------- DELETION -----------
    public void removeMember(Member m) {
        root = delete(root, m.id);
    }

    private Node delete(Node node, int key) {
        if (node == null) return null;

        if (key < node.data.id) {
            node.left = delete(node.left, key);
        } else if (key > node.data.id) {
            node.right = delete(node.right, key);
        } else {
            // Node to delete found
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node with two children
            Node successor = minValue(node.right);
            node.data.updateFrom(successor.data);
            node.right = delete(node.right, successor.data.id);
        }
        return node;
    }

    private Node minValue(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // ----------- TRAVERSALS -----------

    public void printInOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.data);
            inOrderRec(node.right);
        }
    }

    public void printPreOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public void printPostOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.println(node.data);
        }
    }

    // ----------- MAIN FOR TESTING -----------
    public static void main(String[] args) {
        MemberListBST list = new MemberListBST();

        // Add 10 sample members
        list.addMember(new Member(1, "Daniel","Kim","206-9908-7777","dkim@ms.com","098 James St","09/30/1978","Male","1234"));
        list.addMember(new Member(2, "Janis","Lapa","206-9908-7778","jlapa@ms.com","099 James St","09/09/1980","Female","1234"));
        list.addMember(new Member(3, "Klio","Smith","206-9908-7779","ksmith@ms.com","100 James St","10/10/1990","Female","1234"));
        list.addMember(new Member(4, "Daniel","Kim","206-9908-7777","dkim@ms.com","098 James St","09/30/1978","Male","1234"));
        list.addMember(new Member(5, "Janis","Lapa","206-9908-7778","jlapa@ms.com","099 James St","09/09/1980","Female","1234"));
        list.addMember(new Member(6, "Klio","Smith","206-9908-7779","ksmith@ms.com","100 James St","10/10/1990","Female","1234"));
        list.addMember(new Member(7, "Daniel","Kim","206-9908-7777","dkim@ms.com","098 James St","09/30/1978","Male","1234"));
        list.addMember(new Member(8, "Janis","Lapa","206-9908-7778","jlapa@ms.com","099 James St","09/09/1980","Female","1234"));
        list.addMember(new Member(9, "Klio","Smith","206-9908-7779","ksmith@ms.com","100 James St","10/10/1990","Female","1234"));
        list.addMember(new Member(10, "Daniel","Kim","206-9908-7777","dkim@ms.com","098 James St","09/30/1989","Male","1234"));

        // Print all traversals
        System.out.println("Inorder Traversal:");
        list.printInOrder();

        System.out.println("\nPreorder Traversal:");
        list.printPreOrder();

        System.out.println("\nPostorder Traversal:");
        list.printPostOrder();

        // Delete member with ID 2
        list.removeMember(new Member(2,"Janis","Lapa","","","","","","",""));

        System.out.println("\nInorder after deleting ID 2:");
        list.printInOrder();
    }
}

// ----------- MEMBER CLASS -----------
class Member implements Comparable<Member> {
    int id;
    String name, surname, phone, email, address, dob, gender, password;

    public Member(int id, String name, String surname, String phone,
                  String email, String address, String dob,
                  String gender, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.password = password;
    }

    public void updateFrom(Member other) {
        this.name = other.name;
        this.surname = other.surname;
        this.phone = other.phone;
        this.email = other.email;
        this.address = other.address;
        this.dob = other.dob;
        this.gender = other.gender;
        this.password = other.password;
    }

    @Override
    public String toString() {
        return id + ": " + name + " " + surname + ", " + phone + ", " + email;
    }

    @Override
    public int compareTo(Member other) {
        return this.id - other.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Member)) return false;
        Member other = (Member) obj;
        return this.id == other.id;
    }
}