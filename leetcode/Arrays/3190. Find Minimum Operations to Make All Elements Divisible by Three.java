class Solution {
  public int minimumOperations(int[] nums) {
    for (int index = 0, result = 0, length = nums.length; index < length; index++) {
      if (nums[index] % 3 != 0) {
        result++;
      }
      if (index == length - 1) {
        return result;
      }
    }
    return -1;
  }
}