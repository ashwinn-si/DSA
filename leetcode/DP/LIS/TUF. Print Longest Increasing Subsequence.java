class Solution {
  public List<Integer> longestIncreasingSubsequence(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n];
    int hash[] = new int[n];
    for (int index = 0; index < n; index++) {
      hash[index] = index;
    }
    int ans = 0;
    int ansIndex = 0;
    for (int currIndex = 0; currIndex < n; currIndex++) {
      for (int prevIndex = 0; prevIndex < currIndex; prevIndex++) {
        if (nums[prevIndex] < nums[currIndex]) {
          if (dp[currIndex] < dp[prevIndex] + 1) {
            dp[currIndex] = dp[prevIndex] + 1;
            hash[currIndex] = prevIndex;
          }
        }
      }
      if (ans < dp[currIndex]) {
        ans = dp[currIndex];
        ansIndex = currIndex;
      }
    }
    ArrayList<Integer> answer = new ArrayList<>();
    while (true) {
      answer.add(0, nums[ansIndex]);
      if (hash[ansIndex] == ansIndex) {
        break;
      }
      ansIndex = hash[ansIndex];
    }
    return answer;
  }
}
