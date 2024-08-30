//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//============================================================(GeeksforGeeks Solution Start)=======================================================================================================

class Solution {
    private void solve(int col, int n, int[] board, ArrayList<ArrayList<Integer>> result) {
        // Base case: If all queens are placed
        if (col == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i] + 1); // 1-based indexing
            }
            result.add(solution);
            return;
        }
        
        // Try placing the queen in all rows of the current column
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[col] = row; // Place the queen
                solve(col + 1, n, board, result); // Recur for the next column
                // Backtrack: Remove the queen (unnecessary in this context as we overwrite in next iteration)
            }
        }
    }
    
    private boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < col; i++) {
            // Check if there's a conflict with previously placed queens
            if (board[i] == row || Math.abs(board[i] - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n]; // board[i] will store the row number where the queen is placed in the ith column
        solve(0, n, board, result);
        return result;
    }
}


//============================================================(GeeksforGeeks Solution End)=======================================================================================================
