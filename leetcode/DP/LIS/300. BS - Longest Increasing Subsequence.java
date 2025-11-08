class Solution {
  private void bs(int insertNumber, List<Integer> arr) {
    int left = 0;
    int right = arr.size();
    while (left < right) {
      int mid = (left + right) / 2;
      if (insertNumber <= arr.get(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    if (left == arr.size()) {
      arr.add(insertNumber);
    } else {
      arr.set(left, insertNumber);
    }
  }

  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    List<Integer> result = new ArrayList<>();
    for (int currIndex = 0; currIndex < n; currIndex++) {
      bs(nums[currIndex], result);
    }
    return result.size();
  }
}