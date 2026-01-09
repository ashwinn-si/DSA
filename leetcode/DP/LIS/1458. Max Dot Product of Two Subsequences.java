class Solution {
  public int maxDotProduct(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int dp[][] = new int[n + 1][m + 1];
    int NEG = (int) -1e9;
    for (int index1 = 0; index1 <= n; index1++) {
      for (int index2 = 0; index2 <= m; index2++) {
        dp[index1][index2] = NEG;
      }
    }

    for (int index1 = 1; index1 <= n; index1++) {
      for (int index2 = 1; index2 <= m; index2++) {
        int taken = (nums1[index1 - 1] * nums2[index2 - 1]) + Math.max(0, dp[index1 - 1][index2 - 1]);
        int noTaken = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
        dp[index1][index2] = Math.max(taken, noTaken);
      }
    }
    return dp[n][m];
  }
}