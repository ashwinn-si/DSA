class Solution {
  public void sortColors(int[] nums) {
    int zeroPointer = 0;
    int onePointer = 0;
    int twoPointer = nums.length - 1;
    while (onePointer <= twoPointer) {
      if (nums[onePointer] == 1) {
        onePointer++;
      } else if (nums[onePointer] == 0) {
        nums[onePointer] = nums[zeroPointer];
        nums[zeroPointer] = 0;
        zeroPointer++;
        onePointer++;
      } else {
        nums[onePointer] = nums[twoPointer];
        nums[twoPointer--] = 2;
      }
    }
  }
}