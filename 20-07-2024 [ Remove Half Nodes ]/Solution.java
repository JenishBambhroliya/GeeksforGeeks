import java.io.*;
import java.util.*;

// Node class for binary tree
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// Utility class for tree operations
class TreeUtils {

    // Build tree from string representation
    static Node buildTree(String str) {
        if (str.isEmpty() || str.charAt(0) == 'N') {
            return null;
        }

        String[] values = str.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            Node current = queue.poll();

            // Left child
            if (!values[index].equals("N")) {
                current.left = new Node(Integer.parseInt(values[index]));
                queue.add(current.left);
            }
            index++;
            if (index >= values.length) break;

            // Right child
            if (!values[index].equals("N")) {
                current.right = new Node(Integer.parseInt(values[index]));
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }

    // Print tree in inorder traversal
    static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}

// Solution class to modify the tree




// this solution class is GFG solution from here
class Solution {
    // Remove nodes with only one child
    Node removeHalfNodes(Node root) {
        if (root == null) return null;

        root.left = removeHalfNodes(root.left);
        root.right = removeHalfNodes(root.right);

        if (root.left == null && root.right != null) {
            return root.right;
        } else if (root.right == null && root.left != null) {
            return root.left;
        }

        return root;
    }
}
// end of GFG solution.......





// Driver code
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(reader.readLine());

        while (testCaseCount-- > 0) {
            String input = reader.readLine();
            Node root = TreeUtils.buildTree(input);
            Solution solution = new Solution();
            Node updatedRoot = solution.removeHalfNodes(root);
            TreeUtils.printInorder(updatedRoot);
            System.out.println();
        }
    }
}
