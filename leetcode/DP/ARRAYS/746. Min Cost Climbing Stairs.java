class Solution {
  public int minCostClimbingStairs(int[] cost) {
    int N = cost.length;
    int dp[] = new int[N + 2];

    for (int step = 1; step <= N + 1; step++) {
      int currStepCost = step == N + 1 ? 0 : cost[step - 1];
      int poss1 = currStepCost;
      int poss2 = currStepCost;
      if (step - 1 >= 0) {
        poss1 += dp[step - 1];
      }
      if (step - 2 >= 0) {
        poss2 += dp[step - 2];
      }
      dp[step] = poss1 < poss2 ? poss1 : poss2;
    }
    return dp[N + 1];
  }
}