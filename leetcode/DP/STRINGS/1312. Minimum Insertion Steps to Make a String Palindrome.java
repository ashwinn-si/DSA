class Solution {
  public int minInsertions(String text1) {
    String text2 = (new StringBuffer(text1).reverse()).toString();
    int N = text1.length();
    int M = text2.length();
    int dp[][] = new int[N][M];
    StringBuffer str = new StringBuffer();
    for (int index1 = 0; index1 < N; index1++) {
      for (int index2 = 0; index2 < M; index2++) {
        // match testcase
        if (text1.charAt(index1) == text2.charAt(index2)) {
          int prevMatch = index1 == 0 || index2 == 0 ? 0 : dp[index1 - 1][index2 - 1];
          dp[index1][index2] = 1 + prevMatch;
        } else {
          // not match
          int up = index1 == 0 ? 0 : dp[index1 - 1][index2];
          int left = index2 == 0 ? 0 : dp[index1][index2 - 1];
          dp[index1][index2] = Math.max(up, left);
        }
      }
    }
    return text1.length() - dp[N - 1][M - 1];
  }
}