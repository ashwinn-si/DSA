class Solution {
  public int LongestBitonicSequence(int[] nums) {
    int n = nums.length;
    int incDP[] = new int[n];
    int decDP[] = new int[n];
    for (int currIndex = 0; currIndex < n; currIndex++) {
      for (int prevIndex = 0; prevIndex < currIndex; prevIndex++) {
        if (nums[currIndex] > nums[prevIndex]) {
          incDP[currIndex] = Math.max(incDP[currIndex], incDP[prevIndex] + 1);
        }

      }
    }
    for (int currIndex = n - 1; currIndex >= 0; currIndex--) {
      for (int prevIndex = n - 1; prevIndex > currIndex; prevIndex--) {
        if (nums[currIndex] > nums[prevIndex]) {
          decDP[currIndex] = Math.max(decDP[currIndex], decDP[prevIndex] + 1);
        }
      }
    }
    int ans = 0;
    for (int index = 0; index < n; index++) {
      ans = Math.max(incDP[index] + decDP[index], ans);
    }
    return ans + 1;
  }
}
