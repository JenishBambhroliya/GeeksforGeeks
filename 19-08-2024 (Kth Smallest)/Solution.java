//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, key));
        }
        out.flush();
    }
}

// } Driver Code Ends
//=============================================================================(GeeksforGeeks Solution Start)======================================================================================


class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Find the maximum element in the array
        int maxElement = 0;
        for (int num : arr) {
            if (num > maxElement) {
                maxElement = num;
            }
        }

        // Initialize the frequency array with size (maxElement + 1)
        int[] frequency = new int[maxElement + 1];

        // Fill the frequency array
        for (int num : arr) {
            frequency[num]++;
        }

        // Find the k-th smallest element
        int count = 0;
        for (int i = 0; i <= maxElement; i++) {
            count += frequency[i];
            if (count >= k) {
                return i;
            }
        }

        // If the k-th smallest element is not found (though it should be), return -1
        return -1;
    }
}

//=============================================================================(GeeksforGeeks Solution End)======================================================================================
