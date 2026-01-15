class Solution {
  int getMax(int nums[], int n) {
    int max = 1;
    int curr = 1;
    for (int index = 1; index < n; index++) {
      if (nums[index] == nums[index - 1] + 1) {
        curr++;
      } else {
        curr = 1;
      }
      max = Math.max(max, curr);
    }
    return max + 1;
  }

  public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
    Arrays.sort(hBars);
    Arrays.sort(vBars);
    int maxArea = Math.min(getMax(hBars, hBars.length), getMax(vBars, vBars.length));
    return maxArea * maxArea;
  }
}