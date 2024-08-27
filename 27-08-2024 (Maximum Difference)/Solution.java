//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends

//========================================================================(GeeksforGeeks Solution Start)===========================================================================================
class Solution {
    public int findMaxDiff(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n]; // nearest smaller to left
        int[] nsr = new int[n]; // nearest smaller to right

        Stack<Integer> stack = new Stack<>();

        // Find nearest smaller to left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsl[i] = 0;
            } else {
                nsl[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        stack.clear(); // Clear the stack to reuse for NSR

        // Find nearest smaller to right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsr[i] = 0;
            } else {
                nsr[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        // Find the maximum absolute difference
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nsl[i] - nsr[i]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }
}

//========================================================================(GeeksforGeeks Solution End)===========================================================================================
