class Solution {
  public int RodCutting(int prices[], int maxSize) {
    int N = prices.length;
    int dp[][] = new int[N][maxSize + 1];

    for (int index = 0; index < N; index++) {
      int size = index + 1;
      int value = prices[index];
      for (int target = 1; target <= maxSize; target++) {
        int noPick = index == 0 ? 0 : dp[index - 1][target];
        int pick = target >= size ? dp[index][target - size] + value : 0;
        dp[index][target] = Math.max(pick, noPick);
      }
    }
    return dp[N - 1][maxSize];
  }
}