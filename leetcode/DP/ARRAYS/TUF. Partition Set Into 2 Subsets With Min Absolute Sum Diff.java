class Solution {
  public int minDifference(int[] nums, int N) {
    int total = 0;
    for (int num : nums)
      total += num;

    boolean dp[][] = new boolean[N][total + 1];

    // Base case
    for (int i = 0; i < N; i++)
      dp[i][0] = true;
    if (nums[0] <= total)
      dp[0][nums[0]] = true;

    // Fill DP table
    for (int i = 1; i < N; i++) {
      for (int t = 1; t <= total; t++) {
        dp[i][t] = dp[i - 1][t];
        if (t >= nums[i]) {
          dp[i][t] |= dp[i - 1][t - nums[i]];
        }
      }
    }

    // Now compute result from last row
    int result = Integer.MAX_VALUE;
    for (int s1 = 0; s1 <= total / 2; s1++) {
      if (dp[N - 1][s1]) {
        int s2 = total - s1;
        result = Math.min(result, Math.abs(s2 - s1));
      }
    }

    return result;
  }
}
