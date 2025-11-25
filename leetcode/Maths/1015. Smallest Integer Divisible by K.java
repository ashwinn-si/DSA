class Solution {
  public int smallestRepunitDivByK(int k) {
    if (k % 2 == 0 || k % 5 == 0) {
      return -1;
    }
    long num = 1;
    int count = 1;
    while (true) {
      if (num % k == 0) {
        return count;
      }
      num = ((num * 10) + 1) % k;
      count++;
    }
  }
}