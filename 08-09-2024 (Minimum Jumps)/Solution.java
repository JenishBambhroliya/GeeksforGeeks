//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
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

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends

//=========================================================================(GeeksforGeeks Solution Start)==========================================================================================
class Solution {
    static int minJumps(int[] arr) {
        if (arr.length == 1) {
            return 0; // If array has only one element, no jumps are needed.
        }
        
        if (arr[0] == 0) {
            return -1; // If the first element is 0, we can't make any progress.
        }
        
        int maxReach = arr[0]; // Maximum index we can currently reach
        int steps = arr[0];    // Steps we can still take
        int jumps = 1;         // Number of jumps made
        
        // Traverse the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached the last element
            if (i == arr.length - 1) {
                return jumps;
            }
            
            // Update the maximum reach
            maxReach = Math.max(maxReach, i + arr[i]);
            
            // Use a step to move to the current index
            steps--;
            
            // If no more steps left
            if (steps == 0) {
                // We need to make another jump
                jumps++;
                
                // If the current index is beyond the maximum reachable index, return -1
                if (i >= maxReach) {
                    return -1;
                }
                
                // Reinitialize the steps to the number of steps to reach maxReach from the current index
                steps = maxReach - i;
            }
        }
        
        return -1; // If the loop ends without reaching the last index
    }
}

//=========================================================================(GeeksforGeeks Solution Ens)==========================================================================================

