class Solution {
  public int minNumberOperations(int[] target) {
    int result = target[0];
    int N = target.length;
    for (int index = 1; index < N; index++) {
      result += Math.max(0, target[index] - target[index - 1]);
    }
    return result;
  }
}