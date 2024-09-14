//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

//----------------------------------------------------------------(GeeksforGeeks Solution Start)---------------------------------------------------------------------------------------------------


class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // Create lists for storing positive and negative numbers
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        
        // Separate positive and negative numbers
        for (int num : arr) {
            if (num >= 0) {
                positive.add(num);  // considering 0 as positive
            } else {
                negative.add(num);
            }
        }
        
        // Clear the original array to start rearranging
        arr.clear();
        
        // Merge positive and negative numbers alternately
        int i = 0, j = 0;
        boolean flag = true;  // true -> place positive, false -> place negative
        
        while (i < positive.size() && j < negative.size()) {
            if (flag) {
                arr.add(positive.get(i++));
            } else {
                arr.add(negative.get(j++));
            }
            flag = !flag;  // Toggle between positive and negative
        }
        
        // If any positive numbers are left, append them
        while (i < positive.size()) {
            arr.add(positive.get(i++));
        }
        
        // If any negative numbers are left, append them
        while (j < negative.size()) {
            arr.add(negative.get(j++));
        }
    }
}

//----------------------------------------------------------------(GeeksforGeeks Solution End)---------------------------------------------------------------------------------------------------
