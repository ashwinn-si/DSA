class Solution {
  private Integer dp[][];
  private int R, C;

  private boolean isValid(int currR, int currC) {
    return (0 <= currR && currR < R && 0 <= currC && currC < C);
  }

  private int dfs(int currR, int currC) {
    if (currR == R - 1 && currC == C - 1) {
      return 1;
    }
    if (!isValid(currR, currC)) {
      return 0;
    }
    if (dp[currR][currC] != null)
      return dp[currR][currC];

    int bottom = dfs(currR + 1, currC);
    int right = dfs(currR, currC + 1);

    dp[currR][currC] = bottom + right;
    return bottom + right;
  }

  public int uniquePaths(int m, int n) {
    dp = new Integer[m][n];
    R = m;
    C = n;
    return dfs(1, 0) + dfs(0, 1);
  }
}