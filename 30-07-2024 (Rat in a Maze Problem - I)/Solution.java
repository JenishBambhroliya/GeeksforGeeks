//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

//=============================================================================(GeeksforGeek Solution Start)=======================================================================================


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> result = new ArrayList<>();
        
        int n = mat.length;
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return result;
        }
        
        boolean[][] visited = new boolean[n][n];
        findPathsUtil(mat, 0, 0, n, visited, "", result);
        
        Collections.sort(result);  // Sorting the paths as required
        return result;
    }
    
    private void findPathsUtil(int[][] mat, int i, int j, int n, boolean[][] visited, String path, ArrayList<String> result) {
        // If the destination is reached
        if (i == n - 1 && j == n - 1) {
            result.add(path);
            return;
        }
        
        // Mark the cell as visited
        visited[i][j] = true;
        
        // Move Down
        if (isSafe(mat, i + 1, j, n, visited)) {
            findPathsUtil(mat, i + 1, j, n, visited, path + "D", result);
        }
        
        // Move Right
        if (isSafe(mat, i, j + 1, n, visited)) {
            findPathsUtil(mat, i, j + 1, n, visited, path + "R", result);
        }
        
        // Move Up
        if (isSafe(mat, i - 1, j, n, visited)) {
            findPathsUtil(mat, i - 1, j, n, visited, path + "U", result);
        }
        
        // Move Left
        if (isSafe(mat, i, j - 1, n, visited)) {
            findPathsUtil(mat, i, j - 1, n, visited, path + "L", result);
        }
        
        // Unmark the cell (backtrack)
        visited[i][j] = false;
    }
    
    private boolean isSafe(int[][] mat, int i, int j, int n, boolean[][] visited) {
        return (i >= 0 && i < n && j >= 0 && j < n && mat[i][j] == 1 && !visited[i][j]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat1 = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        System.out.println(sol.findPath(mat1)); // Output: [DDRDRR, DRDDRR]

        int[][] mat2 = {
            {1, 0},
            {1, 0}
        };
        System.out.println(sol.findPath(mat2)); // Output: []
    }
}


//=============================================================================(GeeksforGeek Solution end)=======================================================================================
