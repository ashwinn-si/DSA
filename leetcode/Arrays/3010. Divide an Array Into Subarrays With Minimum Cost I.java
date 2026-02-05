class Solution {
  public int minimumCost(int[] nums) {
    int f = Integer.MAX_VALUE;
    int s = Integer.MAX_VALUE;
    for (int index = 1; index < nums.length; index++) {
      if (f > nums[index]) {
        s = f;
        f = nums[index];
      } else if (s > nums[index]) {
        s = nums[index];
      }
    }
    return nums[0] + f + s;
  }
}