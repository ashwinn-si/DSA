class Solution {
  public int maxIncreasingSubarrays(List<Integer> nums) {
    int N = nums.size();
    int result = 0;
    int currCount = 1, prevCount = 0, maxLen = 0;
    for (int index = 1; index < N; index++) {
      if (nums.get(index) > nums.get(index - 1)) {
        currCount++;
      } else {
        prevCount = currCount;
        currCount = 1;
      }
      maxLen = Math.max(maxLen, Math.max(currCount >> 1, Math.min(currCount, prevCount)));
      result = Math.max(maxLen, result);
    }
    return result;
  }
}