class Solution {
  public int helper(int[] nums, int target, int N) {
    int count = 0;
    int sum = 0;
    int left = 0, right = 0;
    if (target < 0)
      return 0;
    while (right < N) {
      sum += nums[right++];
      while (sum > target) {
        sum -= nums[left++];
      }
      count += right - left;
    }
    return count;
  }

  public int numSubarraysWithSum(int[] nums, int goal) {
    return helper(nums, goal, nums.length) - helper(nums, goal - 1, nums.length);
  }
}