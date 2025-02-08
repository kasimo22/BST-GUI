import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BST_GUI {
    private BinarySearchTree bst;
    private JTextArea outputArea;
    private JTextField inputField;

    public BST_GUI() {
        bst = new BinarySearchTree();

        // Create main frame
        JFrame frame = new JFrame("Binary Search Tree GUI");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(10);
        JButton insertButton = new JButton("Insert");
        JButton deleteButton = new JButton("Delete");

        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertNode();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteNode();
            }
        });

        inputPanel.add(new JLabel("Enter Value:"));
        inputPanel.add(inputField);
        inputPanel.add(insertButton);
        inputPanel.add(deleteButton);

        // Output Area
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Button Panel for Traversal
        JPanel buttonPanel = new JPanel();
        JButton inorderButton = new JButton("InOrder");
        JButton preorderButton = new JButton("PreOrder");
        JButton postorderButton = new JButton("PostOrder");

        inorderButton.addActionListener(e -> displayTraversal("inorder"));
        preorderButton.addActionListener(e -> displayTraversal("preorder"));
        postorderButton.addActionListener(e -> displayTraversal("postorder"));

        buttonPanel.add(inorderButton);
        buttonPanel.add(preorderButton);
        buttonPanel.add(postorderButton);

        // Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Display frame
        frame.setVisible(true);
    }

    private void insertNode() {
        try {
            int value = Integer.parseInt(inputField.getText());
            bst.insert(value);
            outputArea.append("Inserted: " + value + "\n");
            inputField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
        }
    }

    private void deleteNode() {
        try {
            int value = Integer.parseInt(inputField.getText());
            bst.delete(value);
            outputArea.append("Deleted: " + value + "\n");
            inputField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
        }
    }

    private void displayTraversal(String order) {
        outputArea.append(order.toUpperCase() + ": ");
        bst.traverseTree(order, outputArea);
        outputArea.append("\n");
    }

    public static void main(String[] args) {
        new BST_GUI();
    }
}
