class Solution {
  public int maxProfit(int k, int[] nums) {
    int n = nums.length;
    int dp[][][] = new int[n + 1][2][k + 1];
    for (int index = n - 1; index >= 0; index--) {
      for (int state = 0; state < 2; state++) {
        // 0 -> buy | 1 -> sell
        for (int trans = 1; trans <= k; trans++) {
          int noPick = dp[index + 1][state][trans];
          int pick = Integer.MIN_VALUE;
          if (state == 0) {
            // we can buy a stock
            pick = dp[index + 1][1][trans] + (-nums[index]);
          } else {
            // we can sell a stock
            pick = dp[index + 1][0][trans - 1] + nums[index];
          }
          dp[index][state][trans] = Math.max(pick, noPick);
        }
      }
    }
    return dp[0][0][k];
  }
}