//DOUBT Y WE ARE USING MOD = 10000000007
class Solution {
  public int perfectSum(int[] nums, int K) {
    int N = nums.length;
    int dp[][] = new int[N][K + 1];
    int MOD = 1000000007;
    for (int i = 0; i < N; i++) {
      dp[i][0] = 1;
    }
    if (nums[0] <= K)
      dp[0][nums[0]] = 1;
    for (int index = 1; index < N; index++) {
      for (int target = 1; target <= K; target++) {
        dp[index][target] = dp[index - 1][target] % MOD;
        if (target >= nums[index]) {
          dp[index][target] = (dp[index][target] + dp[index - 1][target - nums[index]]) % MOD;
        }
      }
    }
    return dp[N - 1][K] % MOD;
  }
}
