//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
//====================================================================================(GeeksforGeeks Solution Start)===============================================================================


class Solution{
    static int maxLength(String S){
        // Initialize stack and push -1 to handle the base case
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        int maxLength = 0;
        
        // Traverse through the string
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                // Push the index of '('
                stack.push(i);
            } else {
                // For ')', pop the stack
                stack.pop();
                
                if (!stack.isEmpty()) {
                    // Calculate the length of the valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    // Push the current index as a base for the next valid substring
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }
}

//====================================================================================(GeeksforGeeks Solution End)===============================================================================

