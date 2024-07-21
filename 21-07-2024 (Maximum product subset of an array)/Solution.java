import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
        sc.close();
    }
}

//-------------------------------------------------------------------------------(GeeksforGeeks Solution start)-------------------------------------------------------------------
class Solution {
    public long findMaxProduct(List<Integer> arr) {
        final int MOD = 1000000007;

        if (arr.size() == 1) {
            return arr.get(0) % MOD;
        }

        long maxNeg = Long.MIN_VALUE;
        int countNeg = 0, countZero = 0;
        long product = 1;

        for (int num : arr) {
            if (num == 0) {
                countZero++;
                continue;
            }
            if (num < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, num);
            }
            product = (product * num) % MOD;
        }

        if (countZero == arr.size()) {
            return 0;
        }

        if (countNeg % 2 != 0) {
            if (countNeg == 1 && countZero > 0 && countZero + countNeg == arr.size()) {
                return 0;
            }
            product = product / maxNeg;
        }

        return (product + MOD) % MOD; // To handle negative products
    }
}
//-------------------------------------------------------------------------------(GeeksforGeeks Solution end)-------------------------------------------------------------------





