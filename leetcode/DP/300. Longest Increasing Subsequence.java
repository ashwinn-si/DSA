class Solution {
  public int lengthOfLIS(int[] arr) {
    int N = arr.length;
    int result[] = new int[N];
    Arrays.fill(result, 1);
    int max = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j <= i; j++) {
        if (arr[j] < arr[i]) {
          result[i] = Math.max(result[j] + 1, result[i]);
          max = Math.max(result[i], max);
        }
      }
    }
    return max;

  }
}