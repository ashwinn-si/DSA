class Solution {
  public int rob(int[] nums) {
    int N = nums.length;
    int result = 0;
    for (int index = 0; index < N; index++) {
      int currIndexVal = nums[index];
      for (int prevIndex = index - 2; prevIndex >= 0; prevIndex--) {
        nums[index] = Math.max(nums[index], nums[prevIndex] + currIndexVal);
      }
      result = Math.max(nums[index], result);
    }
    return result;
  }
}