import javax.swing.JTextArea;

public class BinarySearchTree {
    // Node class represents a single node in the tree
    class Node {
        int data;
        Node left, right;
    
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    
    private Node root;

    // Constructor initializes an empty tree
    public BinarySearchTree() {
        root = null;
    }

    // Public method to insert a new node
    public void insert(int data) {
        root = insert(root, data);
    }

    // Private recursive method to insert a new node
    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    // Public method to delete a node
    public void delete(int data) {
        root = delete(root, data);
    }

    // Private recursive method to delete a node
    private Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.data = findMin(node.right);
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    // Helper method to find the minimum value in a subtree
    private int findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    // Public method for tree traversal and printing to JTextArea
    public void traverseTree(String order, JTextArea outputArea) {
        outputArea.append(order.toUpperCase() + ": ");
        traverse(root, order, outputArea);
        outputArea.append("\n");
    }

    // Private method to perform tree traversal and append results to JTextArea
    private void traverse(Node node, String order, JTextArea outputArea) {
        if (node == null) {
            return;
        }
        if (order.equals("preorder")) {
            outputArea.append(node.data + " ");
        }
        traverse(node.left, order, outputArea);
        if (order.equals("inorder")) {
            outputArea.append(node.data + " ");
        }
        traverse(node.right, order, outputArea);
        if (order.equals("postorder")) {
            outputArea.append(node.data + " ");
        }
    }
}
