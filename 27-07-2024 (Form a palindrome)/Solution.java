import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 

//--------------------------------------------------------------------------------(GeeksforGeeks Solution Start)----------------------------------------------------------------------------------

class Solution {
    static int countMin(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        // gap represents the length of the substring being considered
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(countMin("abcd")); // Output: 3
        System.out.println(countMin("aa"));   // Output: 0
    }
}

//--------------------------------------------------------------------------------(GeeksforGeeks Solution End)----------------------------------------------------------------------------------

