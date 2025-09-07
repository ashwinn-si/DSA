class Solution {
  public int maxScore(int[] nums, int k) {
    int currSum = 0, maxSum = 0;
    int N = nums.length;
    for (int i = 0; i < k; i++) {
      currSum += nums[i];
    }
    maxSum = currSum;
    int leftPointer = k - 1;
    int rightPointer = N - 1;
    for (int i = 0; i < k; i++) {
      currSum -= nums[leftPointer--];
      currSum += nums[rightPointer--];
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }
}