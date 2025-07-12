class Solution {
  static boolean checker(int nums[], int totalPagesAllowed, int K) {
    int currCount = 1;
    int currPages = 0;
    for (int num : nums) {
      if (num + currPages > totalPagesAllowed) {
        currPages = num;
        currCount++;
      } else {
        currPages += num;
      }
    }

    return currCount <= K;
  }

  public static int findPages(int[] nums, int k) {
    // code here
    if (nums.length < k) {
      return -1;
    }
    int left = nums[0];
    int right = 0;
    for (int num : nums) {
      left = Math.max(left, num);
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