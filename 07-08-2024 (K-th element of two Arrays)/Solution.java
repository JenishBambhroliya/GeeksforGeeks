//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// =====================================================================(GeeksforGeeks Solution Start)=============================================================================================


class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        if (n > m) {
            return kthElement(k, arr2, arr1);  // ensure that we always binary search the smaller array
        }

        int low = Math.max(0, k - m), high = Math.min(n, k);

        while (low <= high) {
            int i = (low + high) / 2;
            int j = k - i;

            int arr1Left = (i == 0) ? Integer.MIN_VALUE : arr1[i - 1];
            int arr1Right = (i == n) ? Integer.MAX_VALUE : arr1[i];
            int arr2Left = (j == 0) ? Integer.MIN_VALUE : arr2[j - 1];
            int arr2Right = (j == m) ? Integer.MAX_VALUE : arr2[j];

            if (arr1Left <= arr2Right && arr2Left <= arr1Right) {
                return Math.max(arr1Left, arr2Left);
            } else if (arr1Left > arr2Right) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays do not have a valid k");
    }
}


// =====================================================================(GeeksforGeeks Solution End)=============================================================================================

