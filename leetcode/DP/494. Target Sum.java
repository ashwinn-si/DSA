class Solution {
  public int findTargetSumWays(int[] nums, int diff) {
    int totalSum = 0;
    int N = nums.length;
    for (int num : nums)
      totalSum += num;

    // feasibility checks
    if (Math.abs(diff) > totalSum)
      return 0;
    if ((diff + totalSum) % 2 != 0)
      return 0;

    int target = (diff + totalSum) / 2;
    if (target < 0)
      return 0;

    int[][] dp = new int[N][target + 1];

    // initialize first row correctly
    if (nums[0] == 0) {
      dp[0][0] = 2; // +0 and -0
    } else {
      dp[0][0] = 1; // not taking nums[0]
      if (nums[0] <= target)
        dp[0][nums[0]] = 1; // taking nums[0]
    }

    for (int index = 1; index < N; index++) {
      for (int K = 0; K <= target; K++) { // include K = 0
        int noTake = dp[index - 1][K];
        int take = 0;
        if (K >= nums[index])
          take = dp[index - 1][K - nums[index]];
        dp[index][K] = take + noTake;
      }
    }
    return dp[N - 1][target];
  }
}
