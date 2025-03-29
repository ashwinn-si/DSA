class Solution {
    private int R, C;
    private Integer dp[][];

    private boolean isValid(int currR, int currC) {
        return 0 <= currR && currR < R && 0 <= currC && currC < C;
    }

    private int dfs(int currR, int currC, int matrix[][]) {
        if (!isValid(currR, currC) || matrix[currR][currC] == 1) {
            return 0;
        }
        if (currR == R - 1 && currC == C - 1) {
            return 1;
        }
        if (dp[currR][currC] != null) {
            return dp[currR][currC];
        }
        int bottom = dfs(currR + 1, currC, matrix);
        int left = dfs(currR, currC + 1, matrix);
        dp[currR][currC] = bottom + left;
        return bottom + left;
    }

    public int uniquePathsWithObstacles(int[][] matrix) {
        R = matrix.length;
        C = matrix[0].length;
        dp = new Integer[R][C];
        return dfs(0, 0, matrix);
    }
}