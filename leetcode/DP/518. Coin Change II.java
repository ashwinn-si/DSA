class Solution {
  public int change(int amount, int[] nums) {
    int N = nums.length;
    int dp[][] = new int[N][amount + 1];
    for (int target = 0; target <= amount; target++) {
      if (target % nums[0] == 0) {
        dp[0][target] = 1;
      } else {
        dp[0][target] = 0;
      }
    }

    for (int index = 1; index < N; index++) {
      for (int target = 0; target <= amount; target++) {
        dp[index][target] = dp[index - 1][target];
        if (target >= nums[index]) {
          dp[index][target] += dp[index][target - nums[index]];
        }
      }
    }
    return dp[N - 1][amount];
  }
}