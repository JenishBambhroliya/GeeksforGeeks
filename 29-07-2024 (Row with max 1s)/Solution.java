//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

//==========================================================================(GeeksforGeeks solution start)=========================================================================================


class Solution {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        
        // Start from the top-right corner
        int row = 0, col = m - 1;
        int maxRowIndex = -1;
        
        // Traverse the matrix
        while (row < n && col >= 0) {
            if (arr[row][col] == 1) {
                // Move left and update the row with max 1s
                maxRowIndex = row;
                col--;
            } else {
                // Move down
                row++;
            }
        }
        
        return maxRowIndex;
    }
}
//==========================================================================(GeeksforGeeks solution end)=========================================================================================
