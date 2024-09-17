//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

//=============================================================================(GeeksforGeeks Solution Start)======================================================================================


class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        
        // Sort the array
        Arrays.sort(arr);
        
        // Initial difference between max and min
        int result = arr[n - 1] - arr[0];
        
        // Handle corner case if there's only one tower
        if (n == 1) return result;
        
        // The minimum value after adjustment will be either arr[0] + k or arr[i] - k
        // The maximum value after adjustment will be either arr[n-1] - k or arr[i-1] + k
        
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        
        // Traverse through the sorted array and find the potential minimum and maximum difference
        for (int i = 1; i < n; i++) {
            int minVal = Math.min(smallest, arr[i] - k); // Either arr[0]+k or arr[i]-k (if positive)
            int maxVal = Math.max(largest, arr[i - 1] + k); // Either arr[n-1]-k or arr[i-1]+k
            if (minVal < 0) continue; // Skip if minVal is negative since we can't have negative heights
            
            result = Math.min(result, maxVal - minVal);
        }
        
        return result;
    }
}

//=============================================================================(GeeksforGeeks Solution End)======================================================================================
