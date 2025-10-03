class Solution {
  public int maxProfit(int[] nums) {
    int N = nums.length;
    int dp[][] = new int[N][2]; // 2 -> there can be two states 0 -> no stock | 1 -> has a stock
    // base case: the first stock should always been bought
    dp[0][0] = -nums[0];

    for (int index = 1; index < N; index++) {
      for (int state = 0; state < 2; state++) {
        int noPick = dp[index - 1][state];
        int pick = Integer.MIN_VALUE;
        if (state == 0) {
          pick = -nums[index] + dp[index - 1][1];
        } else {
          pick = nums[index] + dp[index - 1][0];
        }
        dp[index][state] = Math.max(noPick, pick);
      }
    }
    return Math.max(dp[N - 1][0], dp[N - 1][1]);
  }
}