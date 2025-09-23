class Solution {
  public int numDistinct(String S, String T) {
    int N = S.length();
    int M = T.length();

    int[][] dp = new int[N][M];

    for (int i = 0; i < N; i++) {
      if (S.charAt(i) == T.charAt(0)) {
        dp[i][0] = 1;
      }
      if (i > 0)
        dp[i][0] += dp[i - 1][0];

    }

    for (int i = 1; i < N; i++) {
      for (int j = 1; j < M; j++) {
        if (S.charAt(i) == T.charAt(j)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[N - 1][M - 1];
  }
}