class Solution {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n];
    int ans = 0;
    for (int currIndex = 0; currIndex < n; currIndex++) {
      for (int prevIndex = 0; prevIndex < currIndex; prevIndex++) {
        if (nums[prevIndex] < nums[currIndex]) {
          dp[currIndex] = Math.max(dp[currIndex], dp[prevIndex] + 1);
        }
      }
      ans = Math.max(ans, dp[currIndex]);
    }
    return ans + 1;
  }
}