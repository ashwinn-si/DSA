class Solution {
  public long maximumHappinessSum(int[] happiness, int k) {
    Arrays.sort(happiness);
    long result = 0L;
    int pick = 0;
    int index = happiness.length - 1;
    System.out.println(Arrays.toString(happiness));
    while (k-- > 0) {
      result += Math.max(0, happiness[index] - pick);
      pick++;
      index--;
    }
    return result;
  }
}