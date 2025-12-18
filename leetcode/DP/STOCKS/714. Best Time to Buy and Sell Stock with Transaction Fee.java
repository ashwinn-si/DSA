class Solution {
  public int maxProfit(int[] nums, int fee) {
    int n = nums.length;
    int dp[][] = new int[n][2];
    // 0 -> buy | 1 -> sell
    dp[0][0] = -nums[0];
    for (int index = 1; index < n; index++) {
      for (int state = 0; state < 2; state++) {
        int noPick = dp[index - 1][state];
        int pick = Integer.MIN_VALUE;
        if (state == 0) {
          // buying a stock
          pick = dp[index - 1][1] + (-nums[index]);
        } else {
          // selling a stock
          pick = dp[index - 1][0] + (nums[index]) - fee;
        }
        dp[index][state] = Math.max(pick, noPick);
      }
    }
    return Math.max(dp[n - 1][0], dp[n - 1][1]);
  }
}