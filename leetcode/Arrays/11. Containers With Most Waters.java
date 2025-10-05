class Solution {
  public int maxArea(int[] nums) {
    int pointer1 = 0, pointer2 = nums.length - 1;
    int max = 0;
    while (pointer1 <= pointer2) {
      max = Math.max(max, (pointer2 - pointer1) * Math.min(nums[pointer2], nums[pointer1]));
      if (nums[pointer1] <= nums[pointer2]) {
        pointer1++;
      } else {
        pointer2--;
      }
    }
    return max;
  }
}