class Solution {
  public int coinChange(int[] nums, int target) {
    Arrays.sort(nums);
    Integer dp[] = new Integer[target + 1];
    dp[0] = 0;

    for (int num : nums) {
      for (int index = num; index <= target; index++) {
        int remaining = index - num;
        if (dp[remaining] == null)
          continue;
        dp[index] = dp[index] == null ? 1 + dp[remaining] : Math.min(1 + dp[remaining], dp[index]);
      }
    }
    return dp[target] == null ? -1 : dp[target];
  }
}