class Solution {
  Integer memo[][][];

  int dfs(int currIndex, int nums[][], int curr0, int curr1, int zeroT, int oneT) {
    if (currIndex == nums.length) {
      return 0;
    }
    if (memo[currIndex][curr0][curr1] != null) {
      return memo[currIndex][curr0][curr1];
    }
    int noPick = dfs(currIndex + 1, nums, curr0, curr1, zeroT, oneT);
    int pick = Integer.MIN_VALUE;
    if (curr0 + nums[currIndex][0] <= zeroT && curr1 + nums[currIndex][1] <= oneT) {
      pick = 1 + dfs(currIndex + 1, nums, curr0 + nums[currIndex][0], curr1 + nums[currIndex][1], zeroT, oneT);
    }
    int res = Math.max(pick, noPick);
    memo[currIndex][curr0][curr1] = res;
    return res;
  }

  int[] getCount(String str) {
    int oneCount = 0, zeroCount = 0;
    for (int index = 0; index < str.length(); index++) {
      if (str.charAt(index) == '0') {
        zeroCount++;
      } else {
        oneCount++;
      }
    }
    return new int[] { zeroCount, oneCount };
  }

  public int findMaxForm(String[] strs, int zeroT, int oneT) {
    int nums[][] = new int[strs.length][2];
    memo = new Integer[strs.length][zeroT + 1][oneT + 1];
    // 0 -> count of 0 and 1 -> count of 1
    for (int index = 0; index < strs.length; index++) {
      nums[index] = getCount(strs[index]);
    }

    return dfs(0, nums, 0, 0, zeroT, oneT);
  }
}