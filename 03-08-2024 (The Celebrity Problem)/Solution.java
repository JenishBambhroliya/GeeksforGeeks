//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends

//--------------------------------------------------------(Geeksforgeeks solution start) ----------------------------------
// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int candidate = 0;

        // Step 1: Find the candidate
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i;
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int mat1[][] = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}
        };

        int mat2[][] = {
            {0, 1},
            {1, 0}
        };

        System.out.println(sol.celebrity(mat1)); // Output: 1
        System.out.println(sol.celebrity(mat2)); // Output: -1
    }
}



//--------------------------------------------------------(Geeksforgeeks solution end) -----------------------------------
