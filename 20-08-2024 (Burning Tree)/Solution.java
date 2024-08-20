//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends
//======================================================================================(GeeksforGeeks Solution Start)============================================================================

class Solution {
    
    // Class representing the tree node
   
    
    // Helper method to build the parent map
    private static void buildParentMap(Node root, Map<Node, Node> parentMap, Node targetNode, int target, Node[] targetRef) {
        if (root == null) return;
        
        if (root.data == target) {
            targetRef[0] = root;
        }
        
        if (root.left != null) {
            parentMap.put(root.left, root);
            buildParentMap(root.left, parentMap, targetNode, target, targetRef);
        }
        
        if (root.right != null) {
            parentMap.put(root.right, root);
            buildParentMap(root.right, parentMap, targetNode, target, targetRef);
        }
    }
    // BFS to find the minimum time to burn the tree
    public static int minTime(Node root, int target) {
        if (root == null) return 0;
        
        // To store the parent of each node
        Map<Node, Node> parentMap = new HashMap<>();
        Node[] targetRef = new Node[1];
        
        // Build the parent map and get the reference to the target node
        buildParentMap(root, parentMap, null, target, targetRef);
        Node targetNode = targetRef[0];
        
        // Perform BFS from the target node
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(targetNode);
        visited.add(targetNode);
        int time = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;
            
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                
                // Process the left child
                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                    burned = true;
                }
                
                // Process the right child
                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                    burned = true;
                }
                
                // Process the parent
                if (parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    queue.add(parentMap.get(current));
                    visited.add(parentMap.get(current));
                    burned = true;
                }
            }
            
            if (burned) time++;
        }
        
        return time;
    }
}

//======================================================================================(GeeksforGeeks Solution End)============================================================================
