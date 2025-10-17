class Solution {
  public int uniquePathsWithObstacles(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int dp[][] = new int[R][C];
    // base case
    if (matrix[0][0] == 1)
      return 0;

    dp[0][0] = 1;
    for (int i = 1; i < R; i++)
      dp[i][0] = matrix[i][0] != 1 ? dp[i - 1][0] : 0;
    for (int j = 1; j < C; j++)
      dp[0][j] = matrix[0][j] != 1 ? dp[0][j - 1] : 0;

    for (int i = 1; i < R; i++) {
      for (int j = 1; j < C; j++) {
        if (matrix[i][j] == 1)
          continue;
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    return dp[R - 1][C - 1];
  }
}