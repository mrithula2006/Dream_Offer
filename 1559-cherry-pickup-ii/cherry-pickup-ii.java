
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int r = m - 1; r >= 0; r--) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int c2 = 0; c2 < n; c2++) {
                    int cherries = grid[r][c1];

                    if (c1 != c2) {
                        cherries += grid[r][c2];
                    }

                    if (r == m - 1) {
                        dp[r][c1][c2] = cherries;
                    } else {
                        int best = 0;

                        for (int d1 = -1; d1 <= 1; d1++) {
                            for (int d2 = -1; d2 <= 1; d2++) {
                                int nc1 = c1 + d1;
                                int nc2 = c2 + d2;

                                if (nc1 >= 0 && nc1 < n &&
                                    nc2 >= 0 && nc2 < n) {
                                    best = Math.max(
                                        best, dp[r + 1][nc1][nc2]
                                    );
                                }
                            }
                        }

                        dp[r][c1][c2] = cherries + best;
                    }
                }
            }
        }

        return dp[0][0][n - 1];
    }
}
