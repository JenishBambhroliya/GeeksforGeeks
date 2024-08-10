//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends

//------------------------------------------------------------------------------------------------------(GeeksforGeeks Solution start)------------------------------------------------------------

class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // Base cases
        if (head == null || k == 0) {
            return head;
        }
        
        // Initialize pointers
        Node current = head;
        int count = 1;
        
        // Traverse the list to find the kth node
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        
        // If k is greater than or equal to the length of the list, return head
        if (current == null) {
            return head;
        }
        
        // current is now the kth node, and it will be the new end of the list
        Node kthNode = current;
        
        // Traverse to the end of the list
        while (current.next != null) {
            current = current.next;
        }
        
        // Connect the end of the list to the head
        current.next = head;
        
        // New head is the node next to kth node
        head = kthNode.next;
        
        // Break the list at kth node
        kthNode.next = null;
        
        return head;
    }
}


//------------------------------------------------------------------------------------------------------(GeeksforGeeks Solution end)------------------------------------------------------------


//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}
