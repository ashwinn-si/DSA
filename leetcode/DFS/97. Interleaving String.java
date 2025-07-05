class Solution {
  int N1, N2, N3;
  Boolean[][] memo;

  public boolean dfs(String s1, String s2, String s3, int p1, int p2, int p3) {
    if (memo[p1][p2] != null) {
      return memo[p1][p2];
    }

    if (p1 == N1 && p2 == N2 && p3 == N3) {
      return memo[p1][p2] = true;
    }

    boolean result = false;

    if (p1 < N1 && s1.charAt(p1) == s3.charAt(p3)) {
      result |= dfs(s1, s2, s3, p1 + 1, p2, p3 + 1);
    }

    if (!result && p2 < N2 && s2.charAt(p2) == s3.charAt(p3)) {
      result |= dfs(s1, s2, s3, p1, p2 + 1, p3 + 1);
    }

    return memo[p1][p2] = result;
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    N1 = s1.length();
    N2 = s2.length();
    N3 = s3.length();

    if (N1 + N2 != N3) {
      return false;
    }

    memo = new Boolean[N1 + 1][N2 + 1];
    return dfs(s1, s2, s3, 0, 0, 0);
  }
}
