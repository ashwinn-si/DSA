class Solution {
  int bs(int start, int end, int max, int[] nums) {
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] <= max) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return end;
  }

  public int numSubseq(int[] nums, int K) {
    Arrays.sort(nums);
    int MOD = 1_000_000_007;
    int N = nums.length;

    int POWERS_2[] = new int[N];
    POWERS_2[0] = 1;
    for (int i = 1; i < N; i++) {
      POWERS_2[i] = (POWERS_2[i - 1] * 2) % MOD;
    }

    int result = 0;
    for (int i = 0; i < N; i++) {
      int required_num = K - nums[i];
      if (required_num < nums[i]) {
        break;
      }
      int j = bs(i, N - 1, required_num, nums);
      if (i <= j) {
        result = (result + POWERS_2[(j - i)]) % MOD;
      }

    }
    return result;
  }
}