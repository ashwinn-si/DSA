class Solution {
  public int numberOfPaths(int[][] matrix, int k) {
    int R = matrix.length;
    int C = matrix[0].length;
    int MOD = 1_000_000_007;
    int dp[][][] = new int[R][C][k];
    dp[0][0][matrix[0][0] % k]++;

    for (int row = 1; row < R; row++) {
      int currNum = matrix[row][0] % k;
      for (int index = 0; index < k; index++) {
        if (dp[row - 1][0][index] == 0)
          continue;
        dp[row][0][(currNum + index) % k]++;
      }
    }

    for (int col = 1; col < C; col++) {
      int currNum = matrix[0][col] % k;
      for (int index = 0; index < k; index++) {
        if (dp[0][col - 1][index] == 0)
          continue;
        dp[0][col][(currNum + index) % k]++;
      }
    }

    for (int row = 1; row < R; row++) {
      for (int col = 1; col < C; col++) {
        int currNum = matrix[row][col] % k;
        for (int index = 0; index < k; index++) {
          int newRemainder = (currNum + index) % k;
          dp[row][col][newRemainder] += (dp[row][col - 1][index] + dp[row - 1][col][index]) % MOD;
        }
      }
    }
    return dp[R - 1][C - 1][0] % MOD;
  }
}