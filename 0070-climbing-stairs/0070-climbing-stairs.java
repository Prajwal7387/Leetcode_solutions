import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return climbStairs2(n, dp);
    }

    public int climbStairs2(int n, int[] dp) {

        if (n < 0) return 0;
        if (n == 0) return 1;

        if (dp[n] != -1) return dp[n];
        dp[n] = climbStairs2(n-1, dp) + climbStairs2(n-2, dp);
        return dp[n];
    }
}
