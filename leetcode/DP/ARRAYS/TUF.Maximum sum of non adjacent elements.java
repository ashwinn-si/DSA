class Solution {
  public int nonAdjacent(int[] nums) {
    int N = nums.length;
    for (int i = 0; i < N; i++) {
      int result = nums[i];
      for (int j = i - 2; j >= 0; j--) {
        result = Math.max(nums[i] + nums[j], result);
      }
      nums[i] = result;
    }
    int result = nums[0];
    for (int i = 0; i < N; i++) {
      result = Math.max(result, nums[i]);
    }
    return result;
  }
}