//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

//===========================================================================(GeeksforGeeks Solution Start)===================================================================================================

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        int low = 0, mid = 0;
        int high = arr.size() - 1;

        // Traverse the array and arrange 0s, 1s, and 2s
        while (mid <= high) {
            switch (arr.get(mid)) {
                case 0:
                    // Swap the 0 with the element at 'low' and increment both 'low' and 'mid'
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    // If the element is 1, just move the 'mid' pointer
                    mid++;
                    break;

                case 2:
                    // Swap the 2 with the element at 'high' and decrement 'high'
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
    // Helper function to swap elements in the array
    private void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}


//===========================================================================(GeeksforGeeks Solution End)===================================================================================================
