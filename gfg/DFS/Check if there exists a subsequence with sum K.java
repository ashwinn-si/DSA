// User function Template for Java

class Solution {
  static boolean result;

  static void dfs(int currIndex, int N, int nums[], int target, int currSum) {
    if (currSum == target) {
      result = true;
      return;
    }
    for (int i = currIndex; i < N; i++) {
      int requiredNumber = target - currSum;
      if (requiredNumber < nums[i] || result)
        return;
      currSum += nums[i];
      dfs(i + 1, N, nums, target, currSum);
      currSum -= nums[i];

    }

  }

  public static boolean checkSubsequenceSum(int N, int[] nums, int K) {
    // code here
    result = false;
    Arrays.sort(nums);
    dfs(0, N, nums, K, 0);
    return result;
  }
}
