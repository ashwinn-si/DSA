class Solution {
  public int uniquePaths(int R, int C) {
    int[][] dp = new int[R][C];

    for (int i = 0; i < R; i++)
      dp[i][0] = 1;
    for (int j = 0; j < C; j++)
      dp[0][j] = 1;

    for (int i = 1; i < R; i++) {
      for (int j = 1; j < C; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[R - 1][C - 1];
  }
}
