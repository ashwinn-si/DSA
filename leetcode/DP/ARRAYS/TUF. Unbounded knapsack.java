class Solution {
  public int unboundedKnapsack(int[] weights, int[] values, int n, int W) {
    int N = weights.length;
    int dp[][] = new int[N][W + 1];

    for (int index = 0; index < N; index++) {
      int weight = weights[index];
      int value = values[index];
      for (int target = 1; target <= W; target++) {
        int noPick = index > 0 ? dp[index - 1][target] : 0;
        int pick = target - weight >= 0 ? dp[index][target - weight] + value : 0;
        dp[index][target] = Math.max(pick, noPick);
      }
    }
    return dp[N - 1][W];
  }
}
