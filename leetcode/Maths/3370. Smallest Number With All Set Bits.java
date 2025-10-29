class Solution {
  public int smallestNumber(int n) {
    int result = 0;
    while (true) {
      if ((1 << result) - 1 >= n) {
        return (1 << result) - 1;
      }
      result++;
    }
  }
}