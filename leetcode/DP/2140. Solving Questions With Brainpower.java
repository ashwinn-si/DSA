class Solution {
    private Long dp[];

    long dfs(int index, int len, int matrix[][]) {
        // base case
        if (index >= len) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        // picking
        long pick = matrix[index][0] + dfs(index + matrix[index][1] + 1, len, matrix);
        // not picking
        long noPick = dfs(index + 1, len, matrix);

        dp[index] = Math.max(pick, noPick);

        return dp[index];
    }

    public long mostPoints(int[][] matrix) {
        int len = matrix.length;
        dp = new Long[len];
        return dfs(0, len, matrix);
    }
}