class Solution {
    Integer dp[][];
    int dfs(int curr_row, int curr_col, int matrix[][], int R, int C){
        if(curr_row >= R || curr_col >= C){
            return 0;
        }
        if(dp[curr_row][curr_col] != null){
            return dp[curr_row][curr_col];
        }
        if(matrix[curr_row][curr_col] == 1){
            return 0;
        }
        if(curr_row == R - 1 && curr_col == C - 1){
            return 1;
        }
        int result = 0;
        result += dfs(curr_row + 1, curr_col, matrix, R, C);
        result += dfs(curr_row, curr_col + 1, matrix, R, C);
        dp[curr_row][curr_col] = result;
        return result;
    }
    public int uniquePathsWithObstacles(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        dp = new Integer[R][C];
        return dfs(0, 0, matrix, R, C);
    }
}