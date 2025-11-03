class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int N = triangle.size();
    int dp[] = new int[N];
    for (int index = 0; index < N; index++) {
      dp[index] = triangle.get(N - 1).get(index);
    }
    for (int row = 1; row < N; row++) {
      for (int col = 0; col < N - row; col++) {
        dp[col] = Math.min(dp[col] + triangle.get(N - row - 1).get(col),
            dp[col + 1] + triangle.get(N - row - 1).get(col));
      }
    }
    return dp[0];
  }
}