class Solution {
  static boolean result;

  static void dfs(int currIndex, int currSum, int target, int nums[], int N) {

    if (currSum == target) {
      result = true;
      return;
    }

    if (result || currIndex == N || target - currSum < nums[currIndex])
      return;

    dfs(currIndex + 1, currSum + nums[currIndex], target, nums, N);
    dfs(currIndex + 1, currSum, target, nums, N);
  }

  static Boolean isSubsetSum(int nums[], int sum) {
    // code here
    result = false;
    Arrays.sort(nums);
    int N = nums.length;
    dfs(0, 0, sum, nums, N);
    return result;

  }
}