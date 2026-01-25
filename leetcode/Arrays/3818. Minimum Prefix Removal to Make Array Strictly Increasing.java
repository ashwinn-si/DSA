class Solution {
  public int minimumPrefixLength(int[] nums) {
    for (int index = nums.length - 2; index >= 0; index--) {
      if (nums[index] >= nums[index + 1]) {
        return index + 1;
      }
    }
    return 0;
  }
}