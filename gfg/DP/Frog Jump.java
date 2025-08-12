// User function Template for Java
class Solution {
  int minCost(int[] nums) {
    // code here
    int N = nums.length;
    int dp[] = new int[N];
    dp[0] = 0;
    for (int i = 1; i < N; i++) {
      if (i == 1) {
        dp[i] = Math.abs(nums[i] - nums[0]);
      } else {
        int steps = Integer.MAX_VALUE;
        if (i - 1 < N) {
          steps = Math.min(steps, dp[i - 1] + Math.abs(nums[i] - nums[i - 1]));
        }
        if (i - 2 < N) {
          steps = Math.min(steps, dp[i - 2] + Math.abs(nums[i] - nums[i - 2]));
        }
        dp[i] = steps;
      }
    }
    return dp[N - 1];
  }
}