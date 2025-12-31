class Solution {
  public int candy(int[] ratings) {
    int n = ratings.length;
    int candies[] = new int[n];
    for (int index = 0; index < n; index++) {
      candies[index] = 1;
    }
    for (int index = 1; index < n; index++) {
      if (ratings[index] > ratings[index - 1]) {
        candies[index] = candies[index - 1] + 1;
      }
    }
    int res = 0;
    for (int index = n - 1; index > 0; index--) {
      if (ratings[index - 1] > ratings[index]) {
        candies[index - 1] = Math.max(candies[index] + 1, candies[index - 1]);
      }
      res += candies[index - 1];
    }
    res += candies[n - 1];
    return res;
  }
}