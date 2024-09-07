/{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}

//===============================================================(GeeksforGeeks Solution Start)===================================================================================================

class Solution {
    long findNth(long n) {
        long result = 0;
        long base = 1;
        
        // Converting n to its base-9 equivalent
        while (n > 0) {
            result += (n % 9) * base;
            n /= 9;
            base *= 10;
        }
        
        return result;
    }
}
  //===============================================================(GeeksforGeeks Solution End)===================================================================================================

