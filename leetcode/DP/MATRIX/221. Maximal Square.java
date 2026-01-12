class Solution {
  public int maximalSquare(char[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int dp[][] = new int[R][C];
    int result = 0;
    for (int row = 0; row < R; row++) {
      dp[row][0] = (int) (matrix[row][0] - '0');
      result = Math.max(dp[row][0], result);
    }
    for (int col = 0; col < C; col++) {
      dp[0][col] = (int) (matrix[0][col] - '0');
      result = Math.max(dp[0][col], result);
    }
    for (int row = 1; row < R; row++) {
      for (int col = 1; col < C; col++) {
        if (matrix[row][col] == '0')
          continue;
        dp[row][col] = Math.min(dp[row][col - 1], Math.min(dp[row - 1][col], dp[row - 1][col - 1])) + 1;
        result = Math.max(result, dp[row][col]);
      }
    }
    return result * result;
  }
}