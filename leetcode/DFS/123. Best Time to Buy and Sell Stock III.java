class Solution {
  Integer memo[][][];

  int dfs(int index, int nums[], int n, int transcationMade, boolean buyFlag) {
    if (index == n || transcationMade >= 2) {
      return 0;
    }
    if (memo[index][buyFlag ? 1 : 0][transcationMade] != null) {
      return memo[index][buyFlag ? 1 : 0][transcationMade];
    }
    int result = Integer.MIN_VALUE;
    // skiping the day
    result = Math.max(result, dfs(index + 1, nums, n, transcationMade, buyFlag));
    // buying stock
    if (!buyFlag)
      result = Math.max(result, -nums[index] + dfs(index + 1, nums, n, transcationMade, true));
    // selling the stock
    if (buyFlag)
      result = Math.max(result, nums[index] + dfs(index + 1, nums, n, transcationMade + 1, false));
    memo[index][buyFlag ? 1 : 0][transcationMade] = result;
    return result;
  }

  public int maxProfit(int[] prices) {
    int n = prices.length;
    memo = new Integer[n][2][2];

    return dfs(0, prices, n, 0, false);
  }
}