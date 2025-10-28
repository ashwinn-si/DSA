class Solution {
  boolean helper(int[] nums, int index, int direction) {
    while (index >= 0 && index < nums.length) {
      if (nums[index] != 0) {
        nums[index]--;
        direction = direction == 1 ? -1 : 1;
      }
      index += direction;
    }
    System.out.println(Arrays.toString(nums));
    for (int num : nums) {
      if (num != 0) {
        return false;
      }
    }

    return true;
  }

  public int countValidSelections(int[] nums) {
    int count = 0;
    for (int index = 0; index < nums.length; index++) {
      if (nums[index] == 0) {
        if (helper(Arrays.copyOf(nums, nums.length), index, 1)) {
          count++;
        }
        if (helper(Arrays.copyOf(nums, nums.length), index, -1)) {
          count++;
        }
      }
    }
    return count;
  }
}