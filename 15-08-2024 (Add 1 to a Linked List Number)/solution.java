//{ Driver Code Starts
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

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/


//===============================================================(Geeksforgeeks solution start)======================================================================================================


class Solution {
    // Function to reverse the linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Function to add 1 to a number represented by a linked list
    public Node addOne(Node head) {
        // Step 1: Reverse the linked list
        head = reverse(head);

        // Step 2: Add one to the reversed list
        Node temp = head;
        int carry = 1;  // Initialize carry to 1 since we want to add 1
        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;  // Update the node's value
            carry = sum / 10;  // Calculate the carry

            // If carry is 0, we can stop early
            if (carry == 0) {
                break;
            }

            // Move to the next node
            if (temp.next == null && carry != 0) {
                temp.next = new Node(carry);  // If at the end, add a new node for carry
                break;
            }
            temp = temp.next;
        }

        // Step 3: Reverse the list again to restore original order
        head = reverse(head);

        return head;
    }
}
//===============================================================(Geeksforgeeks solution end)======================================================================================================
