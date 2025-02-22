//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

//============================================================================(GeeksforGeeks solution start)=======================================================================================

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sorting jobs by profit in descending order
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        
        // Finding the maximum deadline to set the size of the timeline
        int maxDeadline = 0;
        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        
        // Array to keep track of which slot is occupied
        boolean[] slots = new boolean[maxDeadline + 1];
        int totalProfit = 0, jobsCount = 0;
        
        // Greedily assign jobs to the latest possible slot
        for (Job job : arr) {
            // Find a free slot for this job
            for (int j = job.deadline; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;  // Mark this slot as occupied
                    totalProfit += job.profit;
                    jobsCount++;
                    break;
                }
            }
        }
        
        return new int[]{jobsCount, totalProfit};
    }
}

//============================================================================(GeeksforGeeks solution End)========================================================================================
