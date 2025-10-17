class Solution {
  public int frogJump(int[] nums, int K) {
    int N = nums.length;
    int[] dp = new int[N];
    dp[0] = 0;

    for (int i = 1; i < N; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j = 1; j <= K && i - j >= 0; j++) {
        dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(nums[i] - nums[i - j]));
      }
    }
    return dp[N - 1];
  }
}
