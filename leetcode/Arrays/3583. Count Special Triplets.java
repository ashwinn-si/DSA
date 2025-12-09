class Solution {
  private static final int MOD = 1_000_000_007;
  private static final int M = 100_000;

  public int specialTriplets(int[] nums) {
    int N = nums.length;
    int[] freq = new int[M + 1];
    int[] prevFreq = new int[M + 1];

    for (int num : nums) {
      freq[num]++;
    }

    long count = 0;
    prevFreq[nums[0]]++;

    for (int index = 1; index < N - 1; index++) {
      int x = nums[index];
      int target = x * 2;

      if (target <= M) {
        long left = prevFreq[target];
        long right = freq[target] - prevFreq[target];

        if (x == 0) {
          right--;
        }

        if (left > 0 && right > 0) {
          long add = (left % MOD) * (right % MOD) % MOD;
          count += add;
          if (count >= MOD)
            count %= MOD;
        }
      }

      prevFreq[x]++;
    }

    return (int) (count % MOD);
  }
}
