class Solution {
  public int maxProfit(int[] nums) {
    int n = nums.length;
    int dp[][][] = new int[n + 1][2][3];

    for (int index = n - 1; index >= 0; index--) {
      // 0 -> buy | 1 -> sell
      for (int buy = 0; buy < 2; buy++) {

        for (int cap = 1; cap <= 2; cap++) {

          int noPick = dp[index + 1][buy][cap];
          int pick = Integer.MIN_VALUE;
          if (buy == 0) {
            // i can buy a stock
            pick = -nums[index] + dp[index + 1][1][cap];
          } else {
            // i can sell a stock
            pick = nums[index] + dp[index + 1][0][cap - 1];
          }
          dp[index][buy][cap] = Math.max(pick, noPick);
        }
      }
    }
    // we return 0 -> for the state, because in the 0th day we can only buy the
    // stock not sell it
    return dp[0][0][2];
  }
}