class Solution {
  public boolean isSubsetSum(int[] nums, int target) {
    int N = nums.length;
    boolean dp[][] = new boolean[N][target + 1];

    // base case
    for (int i = 0; i < N; i++) {
      dp[i][0] = true;
    }

    if (nums[0] <= target) {
      dp[0][nums[0]] = true;
    }

    for (int i = 1; i < N; i++) {
      for (int K = 1; K <= target; K++) {
        boolean result = dp[i - 1][K];
        if (nums[i] <= K) {
          result |= dp[i - 1][K - nums[i]];
        }
        dp[i][K] = result;
      }
    }
    return dp[N - 1][target];
  }
}
