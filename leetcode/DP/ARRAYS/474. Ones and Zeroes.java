class Solution {
  int[] getCount(String str) {
    int oneCount = 0, zeroCount = 0;
    for (int index = 0; index < str.length(); index++) {
      if (str.charAt(index) == '0') {
        zeroCount++;
      } else {
        oneCount++;
      }
    }
    return new int[] { zeroCount, oneCount };
  }

  public int findMaxForm(String[] strs, int m, int n) {
    int dp[][] = new int[m + 1][n + 1];
    for (String str : strs) {
      int count[] = getCount(str);
      // 0 -> count of zero & 1 -> count of 1

      for (int targetZero = m; targetZero >= count[0]; targetZero--) {
        for (int targetOne = n; targetOne >= count[1]; targetOne--) {
          dp[targetZero][targetOne] = Math.max(dp[targetZero][targetOne],
              1 + dp[targetZero - count[0]][targetOne - count[1]]);
        }
      }
    }
    return dp[m][n];
  }
}