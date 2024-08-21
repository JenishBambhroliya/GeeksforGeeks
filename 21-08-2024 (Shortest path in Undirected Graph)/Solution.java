//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends
//--------------------------------------------------------------------------------------(GeeksforGeeks Solution Satrt)----------------------------------------------------------------------------

class Solution {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Step 1: Build the graph using adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // Step 2: Initialize the distance array and the queue for BFS
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        
        // Step 3: Perform BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentDist = dist[node];
            
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == Integer.MAX_VALUE) {  // Unvisited node
                    dist[neighbor] = currentDist + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        // Step 4: Replace unreachable nodes' distances with -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}

//--------------------------------------------------------------------------------------(GeeksforGeeks Solution End)----------------------------------------------------------------------------
