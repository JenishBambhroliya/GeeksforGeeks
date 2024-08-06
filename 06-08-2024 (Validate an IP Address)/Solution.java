//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// ---------------------------------------------------------------(GeeksforGeeks solution start)-------------------------------------------------

class Solution {
    public boolean isValid(String str) {
        String[] parts = str.split("\\.");

        if (parts.length != 4) return false;

        for (String part : parts) {
           
            if (part.isEmpty() || !isNumeric(part)) return false;

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;

            if (part.length() > 1 && part.charAt(0) == '0') return false;
        }

        return true;
    }

    private boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}



// ---------------------------------------------------------------(GeeksforGeeks solution end)-------------------------------------------------
