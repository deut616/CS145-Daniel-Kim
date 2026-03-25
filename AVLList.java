public class AVLList {

    // Simple Member holder used for ordering by id
    public static class Member {
        public final int id;
        public Member(int id) { this.id = id; }
    }

    // Node of the AVL tree
    private static class Node {
        Member data;
        Node left, right;
        int height;
        Node(Member m) { data = m; height = 1; }
    }

    private Node root;

    private Node insert(Node current, Member m) {
        if (current == null) return new Node(m);

        // Standard recursive insert
        if (m.id < current.data.id) {
            current.left = insert(current.left, m);
        } else if (m.id > current.data.id) {
            current.right = insert(current.right, m);
        } else {
            return current; // Ignore duplicates
        }

        // Update height and fix balance in one neat call
        updateHeight(current);
        return rebalance(current);
    }

    private Node rebalance(Node n) {
        int balance = getBalance(n);

        // Left heavy
        if (balance > 1) {
            if (getBalance(n.left) < 0) {
                n.left = rotateLeft(n.left);
            }
            return rotateRight(n);
        }

        // Right heavy
        if (balance < -1) {
            if (getBalance(n.right) > 0) {
                n.right = rotateRight(n.right);
            }
            return rotateLeft(n);
        }

        return n;
    }

    private void updateHeight(Node n) {
        if (n != null) {
            n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        }
    }

    private int getHeight(Node n) {
        return (n == null) ? 0 : n.height;
    }

    // balance = height(left) - height(right)
    private int getBalance(Node n) {
        if (n == null) return 0;
        return getHeight(n.left) - getHeight(n.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // rotation
        x.right = y;
        y.left = T2;

        // update heights
        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // rotation
        y.left = x;
        x.right = T2;

        // update heights
        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // public API to insert a member
    public void insert(Member m) {
        root = insert(root, m);
    }

    // simple main to satisfy "candidate main method" requirement
    public static void main(String[] args) {
        AVLList tree = new AVLList();
        tree.insert(new Member(10));
        tree.insert(new Member(20));
        tree.insert(new Member(5));
        System.out.println("Inserted sample members into AVLList.");
    }
}