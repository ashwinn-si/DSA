class Solution {
  int helper(int nums[], int target, int N) {
    int left = 0, right = 0, count = 0, currCount = 0;
    while (right < N) {
      if (nums[right++] % 2 == 1) {
        currCount++;
      }
      while (currCount > target) {
        currCount -= nums[left++] % 2 == 1 ? 1 : 0;
      }
      count += right - left;
    }
    return count;
  }

  public int numberOfSubarrays(int[] nums, int k) {
    return helper(nums, k, nums.length) - helper(nums, k - 1, nums.length);
  }
}