//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Complete the function below*/
//---------------------------------------------------------------------------(GeeksforGeeks Solution Start)---------------------------------------------------------------------------------------
class Solution {
    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;

        if (n < 3) {
            return new ArrayList<>();
        }

        // Step 1: Create the leftMin array
        int[] leftMin = new int[n];
        leftMin[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], arr[i - 1]);
        }

        // Step 2: Create the rightMax array
        int[] rightMax = new int[n];
        rightMax[n - 1] = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i + 1]);
        }

        // Step 3: Find the subsequence
        for (int j = 1; j < n - 1; j++) {
            if (leftMin[j] < arr[j] && arr[j] < rightMax[j]) {
                List<Integer> result = new ArrayList<>();
                result.add(leftMin[j]);
                result.add(arr[j]);
                result.add(rightMax[j]);
                return result;
            }
        }

        // Step 4: No such subsequence found
        return new ArrayList<>();
    }
}


//---------------------------------------------------------------------------(GeeksforGeeks Solution End)---------------------------------------------------------------------------------------
