class Solution {
  public boolean kLengthApart(int[] nums, int k) {
    int prevIndex = -1;
    for (int index = 0; index < nums.length; index++) {
      if (nums[index] == 1) {
        if (prevIndex != -1) {
          if (index - prevIndex <= k) {
            return false;
          }
        }
        prevIndex = index;
      }
    }
    return true;
  }
}