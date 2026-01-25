import java.util.*;

class Solution {

  public int[] rotateElements(int[] nums, int k) {
    List<Integer> posNumber = new ArrayList<>();
    for (int num : nums) {
      if (num >= 0) {
        posNumber.add(num);
      }
    }
    int n = posNumber.size();
    if (n == 0) {
      return nums;
    }
    k %= n;
    if (k == 0) {
      return nums;
    }
    int pointer = k;
    for (int index = 0; index < nums.length; index++) {
      if (nums[index] >= 0) {
        nums[index] = posNumber.get(pointer++);
      }
      if (pointer == n) {
        pointer = 0;
      }
    }
    return nums;
  }
}
