class Solution {
  public int countPartitions(int[] nums) {
    int totalSum = 0;
    for (int num : nums) {
      totalSum += num;
    }
    int curr = 0;
    int res = 0;
    for (int num : nums) {
      curr += num;
      if (curr == totalSum) {
        continue;
      }
      if ((curr - (totalSum - curr)) % 2 == 0) {
        res++;
      }
    }
    return res;
  }
}