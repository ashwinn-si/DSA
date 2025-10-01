class Solution {
  public int largestPerimeter(int[] nums) {
    Arrays.sort(nums);
    for (int index = nums.length - 1; index >= 2; index--) {
      if (nums[index] + nums[index - 1] > nums[index - 2] && nums[index - 1] + nums[index - 2] > nums[index]
          && nums[index] + nums[index - 2] > nums[index - 1]) {
        return nums[index] + nums[index - 1] + nums[index - 2];
      }
    }
    return 0;
  }
}