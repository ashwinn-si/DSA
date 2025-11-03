class Solution {
  public int minCost(String colors, int[] neededSum) {
    int n = colors.length();
    int dp[] = new int[n];
    dp[0] = 0;
    for (int index = 1; index < n; index++) {
      if (colors.charAt(index) != colors.charAt(index - 1)) {
        dp[index] = dp[index - 1];
      } else {
        dp[index] = dp[index - 1] + Math.min(neededSum[index], neededSum[index - 1]);
        neededSum[index] = Math.max(neededSum[index], neededSum[index - 1]);
      }
    }
    return dp[n - 1];
  }
}