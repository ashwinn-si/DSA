class Solution {
  int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public int minOperations(int[] nums) {
    int n = nums.length;
    int oneCount = 0;
    for (int index = 0; index < n; index++) {
      if (nums[index] == 1) {
        oneCount++;
      }
    }
    if (oneCount != 0) {
      return n - oneCount;
    }

    int res = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int currGCD = nums[i];
      for (int j = i + 1; j < n; j++) {
        currGCD = gcd(currGCD, nums[j]);
        if (currGCD == 1) {
          // total_operations = (operations to get a single 1) + (operations to spread it)
          res = Math.min(res, j - i + n - 1);
          break;
        }
      }
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}