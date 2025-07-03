class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int N = nums.length;
    for (int pointer1 = 0; pointer1 < N - 2; pointer1++) {
      // we dont want any repeating numbers only need unique
      if (pointer1 > 0 && nums[pointer1] == nums[pointer1 - 1])
        continue;
      int pointer2 = pointer1 + 1;
      int pointer3 = N - 1;
      while (pointer2 < pointer3) {
        int currSum = nums[pointer1] + nums[pointer2] + nums[pointer3];
        if (currSum == 0) {
          result.add(new ArrayList<>(Arrays.asList(nums[pointer1], nums[pointer2], nums[pointer3])));
          pointer2++;
          pointer3--;
          while (pointer2 < pointer3 && nums[pointer2] == nums[pointer2 - 1])
            pointer2++;
          while (pointer2 < pointer3 && nums[pointer3] == nums[pointer3 + 1])
            pointer3--;
        } else if (currSum > 0) {
          pointer3--;
        } else {
          pointer2++;
        }
      }
    }
    return result;
  }
}