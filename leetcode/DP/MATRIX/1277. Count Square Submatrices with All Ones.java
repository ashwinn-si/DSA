class Solution {
  public int countSquares(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int dp[][] = new int[R][C];
    int result = 0;
    for (int row = 0; row < R; row++) {
      dp[row][0] = matrix[row][0];
    }
    for (int col = 0; col < C; col++) {
      dp[0][col] = matrix[0][col];
    }
    for (int row = 1; row < R; row++) {
      for (int col = 1; col < C; col++) {
        if (matrix[row][col] == 0)
          continue;
        dp[row][col] = Math.min(dp[row - 1][col - 1], Math.min(dp[row - 1][col], dp[row][col - 1])) + 1;
      }
    }
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        result += dp[row][col];
      }
    }
    return result;
  }
}