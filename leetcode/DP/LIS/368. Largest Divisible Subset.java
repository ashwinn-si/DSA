class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int dp[] = new int[n];
    int hash[] = new int[n];
    int maxC = 0;
    int maxI = 0;
    for (int index = 0; index < n; index++) {
      hash[index] = index;
    }
    for (int currIndex = 0; currIndex < n; currIndex++) {
      for (int prevIndex = 0; prevIndex < currIndex; prevIndex++) {
        if (nums[currIndex] % nums[prevIndex] == 0 || nums[prevIndex] % nums[currIndex] == 0) {
          if (dp[currIndex] < dp[prevIndex] + 1) {
            dp[currIndex] = dp[prevIndex] + 1;
            hash[currIndex] = prevIndex;
          }
        }
      }
      if (maxC < dp[currIndex]) {
        maxC = dp[currIndex];
        maxI = currIndex;
      }
    }
    List<Integer> result = new ArrayList<>();
    while (true) {
      result.add(0, nums[maxI]);
      if (maxI == hash[maxI]) {
        break;
      }
      maxI = hash[maxI];
    }
    return result;
  }
}