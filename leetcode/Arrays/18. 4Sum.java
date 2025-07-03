class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int N = nums.length;
    List<List<Integer>> result = new ArrayList<>();
    for (int pointer1 = 0; pointer1 < N - 3; pointer1++) {
      if (pointer1 > 0 && nums[pointer1] == nums[pointer1 - 1])
        continue;
      for (int pointer2 = pointer1 + 1; pointer2 < N - 2; pointer2++) {
        if (pointer2 > pointer1 + 1 && nums[pointer2] == nums[pointer2 - 1])
          continue;
        int pointer3 = pointer2 + 1;
        int pointer4 = N - 1;
        while (pointer3 < pointer4) {
          Long sum = (long) nums[pointer1] + nums[pointer2] + nums[pointer3] + nums[pointer4];
          if (sum == target) {
            result.add(Arrays.asList(nums[pointer1], nums[pointer2], nums[pointer3], nums[pointer4]));
            pointer3++;
            pointer4--;
            while (pointer3 < pointer4 && nums[pointer3] == nums[pointer3 - 1])
              pointer3++;
            while (pointer3 < pointer4 && nums[pointer4] == nums[pointer4 + 1])
              pointer4--;
          } else if (sum > target) {
            pointer4--;
          } else {
            pointer3++;
          }
        }
      }
    }
    return result;
  }

}