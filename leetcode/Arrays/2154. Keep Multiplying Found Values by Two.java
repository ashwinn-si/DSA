class Solution {
  public int findFinalValue(int[] nums, int original) {
    Arrays.sort(nums);
    int pointer = 0;
    while (pointer < nums.length) {
      if (nums[pointer] == original) {
        original *= 2;
      }
      pointer++;
    }
    return original;
  }
}