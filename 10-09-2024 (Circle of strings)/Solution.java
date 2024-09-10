//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}

//========================================================================(GeeksforGeeks Solution Start)==========================================================================================


class Solution {
    // Function to check if strings can form a circle
    public int isCircle(String arr[]) {
        int n = arr.length;
        if (n == 0) return 0;
        
        // Create graph for the characters 'a' to 'z' (26 letters)
        int[] inDegree = new int[26];  // in-degree for each character
        int[] outDegree = new int[26]; // out-degree for each character
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph
        for (String s : arr) {
            int first = s.charAt(0) - 'a';  // First character of the string
            int last = s.charAt(s.length() - 1) - 'a'; // Last character of the string
            graph.get(first).add(last);  // Create a directed edge
            outDegree[first]++;  // Increment out-degree of 'first'
            inDegree[last]++;    // Increment in-degree of 'last'
        }
        
        // Check if in-degree equals out-degree for all nodes
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0;
            }
        }
        
        // Check if all the characters form a strongly connected component
        // Start DFS from any character that has edges
        boolean[] visited = new boolean[26];
        int start = -1;
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0) {
                start = i;  // Find a character with an outgoing edge
                break;
            }
        }
        
        // If no character has an outgoing edge, it means the array is empty or invalid
        if (start == -1) return 0;
        
        // Perform DFS to check connectivity
        dfs(graph, visited, start);
        
        // Check if all nodes with edges were visited
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0 && !visited[i]) {
                return 0;
            }
        }
        
        return 1;  // All checks passed, strings can form a circle
    }
    
    // DFS function to traverse the graph
    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}

//========================================================================(GeeksforGeeks Solution End)==========================================================================================

