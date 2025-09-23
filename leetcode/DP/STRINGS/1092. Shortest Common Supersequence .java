class Solution {
  public String shortestCommonSupersequence(String text1, String text2) {
    int N = text1.length();
    int M = text2.length();
    int dp[][] = new int[N + 1][M + 1];

    for (int index1 = 1; index1 <= N; index1++) {
      for (int index2 = 1; index2 <= M; index2++) {
        // match testcase
        if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
          dp[index1][index2] = dp[index1 - 1][index2 - 1] + 1;
        } else {
          // not match
          dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
        }
      }
    }

    StringBuffer str = new StringBuffer();
    int index1 = N, index2 = M;
    while (index1 > 0 && index2 > 0) {
      if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
        str.append(text1.charAt(index1 - 1));
        index1--;
        index2--;
      } else {
        if (dp[index1 - 1][index2] >= dp[index1][index2 - 1]) {
          str.append(text1.charAt(index1 - 1));
          index1--;
        } else {
          str.append(text2.charAt(index2 - 1));
          index2--;
        }
      }
    }
    while (index1 != 0) {
      str.append(text1.charAt(index1 - 1));
      index1--;
    }

    while (index2 != 0) {
      str.append(text2.charAt(index2 - 1));
      index2--;
    }

    return str.reverse().toString();
  }
}