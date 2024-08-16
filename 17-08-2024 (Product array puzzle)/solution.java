//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//--------------------------------------------------------------------------------------(GeeksforGeeks Solution Start)----------------------------------------------------------------------------


class Solution {
    public static long[] productExceptSelf(int nums[]) {
        int n = nums.length;
        long[] left = new long[n];
        long[] right = new long[n];
        long[] result = new long[n];

        // Fill left array where left[i] is the product of all elements to the left of nums[i]
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        // Fill right array where right[i] is the product of all elements to the right of nums[i]
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        // Construct the result array
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}


//--------------------------------------------------------------------------------------(GeeksforGeeks Solution end)----------------------------------------------------------------------------
