class Solution {
  public boolean canPartition(int[] nums) {
    int possibleSum = 0;
    int N = nums.length;
    for (int num : nums) {
      possibleSum += num;
    }
    if (possibleSum % 2 == 1)
      return false;
    possibleSum = (possibleSum / 2);
    boolean dp[][] = new boolean[N][possibleSum + 1];
    for (int row = 0; row < N; row++) {
      dp[row][0] = true;
    }
    if (nums[0] <= possibleSum) {
      dp[0][nums[0]] = true;
    }

    for (int index = 1; index < N; index++) {
      for (int target = 1; target <= possibleSum; target++) {
        dp[index][target] = dp[index - 1][target];
        if (target >= nums[index]) {
          dp[index][target] |= dp[index - 1][target - nums[index]];
        }
      }
    }
    return dp[N - 1][possibleSum];
  }
}