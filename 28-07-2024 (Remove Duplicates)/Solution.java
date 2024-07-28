//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}


//====================================================================================(GeeksforGeeks Solution Start)================================================================================


class Solution {
    String removeDups(String str) {
        // Create a HashSet to keep track of seen characters
        HashSet<Character> seen = new HashSet<>();
        
        // StringBuilder to build the result string
        StringBuilder result = new StringBuilder();
        
        // Traverse the input string
        for (char ch : str.toCharArray()) {
            // If the character is not already in the HashSet, add it to both the HashSet and the result
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }
        
        // Convert the StringBuilder to a string and return it
        return result.toString();
    }
}


//====================================================================================(GeeksforGeeks Solution end)================================================================================
