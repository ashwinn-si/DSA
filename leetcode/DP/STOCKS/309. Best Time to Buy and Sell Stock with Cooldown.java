class Solution {
  public int maxProfit(int[] nums) {
    int N = nums.length;

    int dp[][] = new int[N + 2][2];

    for (int index = N - 1; index >= 0; index--) {

      int noPick_state0 = dp[index + 1][0];

      int pick_state0 = -nums[index] + dp[index + 1][1];
      dp[index][0] = Math.max(noPick_state0, pick_state0);

      int noPick_state1 = dp[index + 1][1];
      int pick_state1 = nums[index] + dp[index + 2][0];
      dp[index][1] = Math.max(noPick_state1, pick_state1);
    }

    return dp[0][0];
  }
}