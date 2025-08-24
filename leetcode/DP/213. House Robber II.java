class Solution {
  public int rob(int[] nums) {
    int N = nums.length;
    int result = 0;
    int resultArray[][] = new int[N][2];
    for (int index = 0; index < N; index++) {
      for (int prevIndex = index - 2; prevIndex >= 0; prevIndex--) {
        resultArray[index][1] = Math.max(resultArray[index][1], resultArray[prevIndex][1] + nums[index]);
        if (index == N - 1)
          continue;
        resultArray[index][0] = Math.max(resultArray[index][0], resultArray[prevIndex][0] + nums[index]);
      }
      if (index == 0) {
        resultArray[0][0] = nums[index];
      }
      if (index == 1) {
        resultArray[1][1] = nums[index];
      }
      result = Math.max(resultArray[index][1], Math.max(resultArray[index][0], result));
    }
    return result;
  }
}