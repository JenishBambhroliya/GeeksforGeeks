//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            // int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().Maximize(arr));
        }
        out.close();
    }
}
// } Driver Code Ends

//==============================================================================(GeeksforGeeks solution start)=====================================================================================

class Solution {
    private static final int MOD = 1000000007;

    public int Maximize(int[] arr) {
        Arrays.sort(arr);
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += (long) arr[i] * i;
        }

        long ans = sum % MOD;
        return (int) ans;
    }
}

//==============================================================================(GeeksforGeeks solution end)=====================================================================================
