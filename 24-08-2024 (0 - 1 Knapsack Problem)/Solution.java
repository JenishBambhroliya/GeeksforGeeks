//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends
//---------------------------------------------------(GeeksfoeGeeks Solution Start)-----------------------------------------------------------------------------------------------------------------

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        int N = val.length; // Number of items
        
        // DP table
        int[][] dp = new int[N + 1][W + 1];
        
        // Build the DP table
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    // Include the item
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                } else {
                    // Exclude the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        // The answer is in dp[N][W]
        return dp[N][W];
    }
}



//---------------------------------------------------(GeeksfoeGeeks Solution End)-----------------------------------------------------------------------------------------------------------------
