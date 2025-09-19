class Solution {
  public int countPartitions(int N, int diff, int[] nums) {
    int totalSum = 0;
    int MOD = 1000000007;
    for (int num : nums)
      totalSum += num;

    if ((diff + totalSum) % 2 != 0)
      return 0;
    int target = (diff + totalSum) / 2;

    int[][] dp = new int[N][target + 1];

    dp[0][0] = 1;
    if (nums[0] <= target)
      dp[0][nums[0]] += 1;

    for (int i = 1; i < N; i++) {
      for (int t = 0; t <= target; t++) {
        dp[i][t] = dp[i - 1][t] % MOD;
        if (t >= nums[i]) {
          dp[i][t] = (dp[i][t] + dp[i - 1][t - nums[i]]) % MOD;
        }
      }
    }

    return dp[N - 1][target];
  }
}
