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

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution g = new Solution();
            int ans = g.getMiddle(head);
            System.out.println(ans);
            // printList(head);
            t--;
        }
    }
}

//=========================================================(GeeksforGeeks Solution Start)==========================================================================================================


class Solution {
    int getMiddle(Node head) {
        // Edge case: if the list is empty
        if (head == null) {
            return -1; // returning -1 or any appropriate value for empty list
        }
        
        // Initialize two pointers
        Node slow = head;
        Node fast = head;
        
        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer by 1 step
            fast = fast.next.next;  // Move fast pointer by 2 steps
        }
        
        // slow pointer is now at the middle
        return slow.data;
    }
}

//=========================================================(GeeksforGeeks Solution End)==========================================================================================================
