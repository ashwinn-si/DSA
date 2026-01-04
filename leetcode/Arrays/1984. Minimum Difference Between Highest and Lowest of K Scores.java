class Solution {
  public int minimumDifference(int[] nums, int k) {
    if (k == 1) {
      return 0;
    }
    Arrays.sort(nums);
    int result = Integer.MAX_VALUE;
    for (int index = 0; index <= nums.length - k; index++) {
      result = Math.min(result, nums[index + k - 1] - nums[index]);
    }
    return result;
  }
}