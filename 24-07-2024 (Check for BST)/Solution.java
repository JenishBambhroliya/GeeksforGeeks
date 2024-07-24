class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}


//--------------------------------------------------------------------------(GeeksforGeeks Solution Start)-----------------------------------------------------------------------------------------


class Solution {
    // Helper function to validate the BST property.
    boolean isBSTUtil(Node node, int min, int max) {
        // An empty tree is a BST
        if (node == null)
            return true;

        // False if this node violates the min/max constraints
        if (node.data < min || node.data > max)
            return false;

        // Otherwise, check the subtrees recursively
        // Tighten the min or max constraint
        return (isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max));
    }

    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // Initial call to the helper function with the full range of integer values
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}


//--------------------------------------------------------------------------(GeeksforGeeks Solution end)-----------------------------------------------------------------------------------------


// Example usage:
public class Main {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        Solution sol = new Solution();
        if (sol.isBST(root)) {
            System.out.println("The tree is a BST.");
        } else {
            System.out.println("The tree is not a BST.");
        }

        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.right = new Node(20);
        root2.right.left = new Node(9);  // Invalid node for a BST
        root2.right.right = new Node(25);

        if (sol.isBST(root2)) {
            System.out.println("The tree is a BST.");
        } else {
            System.out.println("The tree is not a BST.");
        }
    }
}
