class Solution {
  public int maxDistinctElements(int[] nums, int k) {
    Arrays.sort(nums);
    int nextNum = nums[0] - k + 1;
    int uniqNumberGenerated = 1;
    for (int index = 1; index < nums.length; index++) {
      int start = nums[index] - k;
      int end = nums[index] + k;
      if (nextNum >= start && nextNum <= end) {
        nextNum++;
        uniqNumberGenerated++;
      } else if (nextNum < start) {
        nextNum = start + 1;
        uniqNumberGenerated++;
      }
    }
    return uniqNumberGenerated;
  }
}