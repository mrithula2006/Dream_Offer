
class Solution {
    public int profitableSchemes(int n, int minProfit,
                                int[] group, int[] profit) {
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][minProfit + 1];

        dp[0][0] = 1;

        for (int k = 0; k < group.length; k++) {
            int people = group[k];
            int gain = profit[k];

            for (int i = n; i >= people; i--) {
                for (int p = minProfit; p >= 0; p--) {
                    int newProfit = Math.min(minProfit, p + gain);

                    dp[i][newProfit] =
                        (dp[i][newProfit]
                        + dp[i - people][p]) % MOD;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i <= n; i++) {
            ans = (ans + dp[i][minProfit]) % MOD;
        }

        return ans;
    }
}
