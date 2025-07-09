class Solution {
  boolean checker(int nums[], int targetValue, int K) {
    int count = 1;
    int currSum = 0;
    for (int num : nums) {
      if (currSum + num > targetValue) {
        count++;
        currSum = num;
      } else {
        currSum += num;
      }
    }
    return count <= K;
  }

  public int splitArray(int[] nums, int k) {
    int left = nums[0];
    int right = 0;
    for (int num : nums) {
      left = Math.max(num, left);
      right += num;
    }
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (checker(nums, mid, k)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}