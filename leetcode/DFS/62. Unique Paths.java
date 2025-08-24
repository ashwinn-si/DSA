class Solution {
  Integer dp[][];

  public int dfs(int curr_row, int curr_col, int R, int C) {
    if (curr_row >= R || curr_col >= C) {
      return 0;
    }
    if (dp[curr_row][curr_col] != null) {
      return dp[curr_row][curr_col];
    }
    if (curr_row == R - 1 && curr_col == C - 1) {
      return 1;
    }
    int result = 0;
    result += dfs(curr_row + 1, curr_col, R, C);
    result += dfs(curr_row, curr_col + 1, R, C);
    dp[curr_row][curr_col] = result;
    return result;
  }

  public int uniquePaths(int m, int n) {
    dp = new Integer[m][n];
    return (dfs(0, 0, m, n));
  }
}