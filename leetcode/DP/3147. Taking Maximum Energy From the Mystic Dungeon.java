class Solution {
  public int maximumEnergy(int[] energy, int k) {
    int N = energy.length;
    int dp[] = new int[N];
    int maxEnergy = Integer.MIN_VALUE;
    for (int index = N - 1; index >= 0; index--) {
      dp[index] = energy[index];
      if (index + k < N) {
        dp[index] += dp[index + k];
      }
      maxEnergy = Math.max(maxEnergy, dp[index]);
    }
    return maxEnergy;
  }
}