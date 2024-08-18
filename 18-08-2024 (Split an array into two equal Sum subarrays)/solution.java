//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

//---------------------------------------------------------------------------------------(GeeksforGeeks Solution Start)--------------------------------------------------------------------------

class Solution {
    public boolean canSplit(int arr[]) {
        int totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }
        
        // If total sum is odd, it's not possible to split into two equal subarrays
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int leftSum = 0;
        int targetSum = totalSum / 2;
        
        // Iterate through the array and check if we can find a point where leftSum equals targetSum
        for (int num : arr) {
            leftSum += num;
            if (leftSum == targetSum) {
                return true;
            }
        }
        
        return false;
    }
}

//---------------------------------------------------------------------------------------(GeeksforGeeks Solution End)--------------------------------------------------------------------------

