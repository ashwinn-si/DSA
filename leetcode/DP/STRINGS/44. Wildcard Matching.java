class Solution {
  public boolean isMatch(String string1, String string2) {
    int N = string1.length();
    int M = string2.length();
    boolean dp[][] = new boolean[string1.length() + 1][string2.length() + 1];

    dp[0][0] = true;

    for (int index2 = 1; index2 <= M; index2++) {
      if (string2.charAt(index2 - 1) == '*') {
        dp[0][index2] = dp[0][index2 - 1];
      }
    }

    for (int index1 = 1; index1 <= N; index1++) {
      for (int index2 = 1; index2 <= M; index2++) {
        char ch1 = string1.charAt(index1 - 1);
        char ch2 = string2.charAt(index2 - 1);
        if (ch1 == ch2 || ch2 == '?') {
          dp[index1][index2] = dp[index1 - 1][index2 - 1];
          continue;
        }

        if (ch2 == '*') {
          dp[index1][index2] = dp[index1 - 1][index2 - 1] || dp[index1 - 1][index2] || dp[index1][index2 - 1];
        }
      }
    }

    return (dp[N][M]);
  }
}