import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    Node left, right;
    
    Node(int item) {
        val = item;
        left = right = null;
    }
}


//----------------------------------------------------------------------------------------------------(GeeksforGeeks Solution Start)---------------------------------------------------------------

class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        // Perform in-order traversal on both BSTs and store the results in list1 and list2
        inOrderTraversal(root1, list1);
        inOrderTraversal(root2, list2);
        
        // Merge the two sorted lists
        return mergeSortedLists(list1, list2);
    }
    
    // Helper function to perform in-order traversal and store the result in a list
    private void inOrderTraversal(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, result);
        result.add(root.val);
        inOrderTraversal(root.right, result);
    }
    
    // Helper function to merge two sorted lists
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        
        // Add remaining elements from list1
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        
        // Add remaining elements from list2
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }
        
        return mergedList;
    }
}


//----------------------------------------------------------------------------------------------------(GeeksforGeeks Solution end)-----------------------------------------------------------------


// Example usage
public class Main {
    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(6);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);

        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        root2.right.right = new Node(7);
        root2.right.right.left = new Node(6);
        
        Solution solution = new Solution();
        List<Integer> mergedList = solution.merge(root1, root2);
        
        System.out.println(mergedList); // Output: [1, 2, 2, 3, 3, 4, 5, 6, 6, 7]
    }
}
