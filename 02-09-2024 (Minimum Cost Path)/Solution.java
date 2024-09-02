//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

//===============================================================================(GeeksforGeeks Solution Start)====================================================================================


class Solution {
    // Function to return the minimum cost to reach the bottom right cell from the top left cell.
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        // Initialize the distance array with a large number (infinity equivalent).
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Priority queue to store (cost, x, y) tuples.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Start with the top-left corner (0, 0).
        dist[0][0] = grid[0][0];
        pq.add(new int[]{grid[0][0], 0, 0});

        // Possible directions to move: left, right, up, down.
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int x = current[1];
            int y = current[2];

            // If we have reached the bottom-right corner, return the cost.
            if (x == n - 1 && y == n - 1) {
                return currentCost;
            }

            // Explore all four possible directions.
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // Check if the new position is within bounds.
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    int newCost = currentCost + grid[newX][newY];
                    // If a cheaper path to (newX, newY) is found, update it.
                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        pq.add(new int[]{newCost, newX, newY});
                    }
                }
            }
        }

        return dist[n-1][n-1];
    }
}


//===============================================================================(GeeksforGeeks Solution End)======================================================================================
