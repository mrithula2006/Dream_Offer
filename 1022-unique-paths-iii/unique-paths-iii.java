class Solution {
    int paths = 0;
    int empty = 1;

    public int uniquePathsIII(int[][] grid) {
        int sr = 0, sc = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    empty++;
                else if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
            }
        }

        dfs(grid, sr, sc, empty);
        return paths;
    }

    void dfs(int[][] grid, int r, int c, int remain) {

        if (r < 0 || c < 0 ||
            r >= grid.length || c >= grid[0].length ||
            grid[r][c] == -1)
            return;

        if (grid[r][c] == 2) {
            if (remain == 0)
                paths++;
            return;
        }

        int temp = grid[r][c];
        grid[r][c] = -1;

        dfs(grid, r + 1, c, remain - 1);
        dfs(grid, r - 1, c, remain - 1);
        dfs(grid, r, c + 1, remain - 1);
        dfs(grid, r, c - 1, remain - 1);

        grid[r][c] = temp;
    }
}