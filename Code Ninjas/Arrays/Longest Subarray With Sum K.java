public class Solution {
  public static int longestSubarrayWithSumK(int[] nums, long K) {
    // Write your code here
    int leftPointer = 0;
    int rightPointer = 0;
    int len = nums.length;
    int result = 0;
    long sum = 0;
    while (rightPointer < len) {
      sum += nums[rightPointer];
      while (sum > K && leftPointer < rightPointer) {
        sum -= nums[leftPointer++];
      }
      if (K == sum) {
        result = Math.max(result, rightPointer - leftPointer);
      }

      rightPointer++;
    }
    return result + 1;
  }
}