//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends



//--------------------------------------------------------------------------------------------(GeeksforGeeks Solution Start)-----------------------------------------------------------------------

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int n = arr1.length;
        
        // Ensure arr1 is the smaller array to reduce the search space
        if (arr1.length > arr2.length) {
            return SumofMiddleElements(arr2, arr1);
        }
        
        int low = 0, high = n;
        
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = n - partition1;
            
            // If partition1 is 0 it means nothing is there on the left side of arr1
            // If partition1 is n it means nothing is there on the right side of arr1
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int minRight1 = (partition1 == n) ? Integer.MAX_VALUE : arr1[partition1];
            
            // Similarly for arr2
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : arr2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : arr2[partition2];
            
            // Check if we have found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // We have found the middle elements
                return Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2);
            } else if (maxLeft1 > minRight2) {
                // Move towards the left in arr1
                high = partition1 - 1;
            } else {
                // Move towards the right in arr1
                low = partition1 + 1;
            }
        }
        
        // The arrays are sorted, so there should be no case of this
        throw new IllegalArgumentException("Input arrays are not sorted or have different sizes.");
    }
}
//--------------------------------------------------------------------------------------------(GeeksforGeeks Solution end)-----------------------------------------------------------------------


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}



// } Driver Code Ends
