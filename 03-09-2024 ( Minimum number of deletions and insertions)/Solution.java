//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//===============================================================================(GeeksforGeeks Solution Start)====================================================================================

class Solution {
    public int minOperations(String str1, String str2) {
        int m = str1.length();
        int s = str2.length();
        
        // dp[i][j] will hold the length of LCS of str1[0...i-1] and str2[0...j-1]
        int[][] dp = new int[m + 1][s + 1];
        
        // Building the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= s; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The length of the longest common subsequence
        int lcs_length = dp[m][s];
        
        // Calculate the number of deletions and insertions
        int deletions = m - lcs_length;
        int insertions = s - lcs_length;
        
        // Total operations = deletions + insertions
        return deletions + insertions;
    }
}

//===============================================================================(GeeksforGeeks Solution End)====================================================================================
