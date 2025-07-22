class Solution {
  List<List<Integer>> result;
  int N;

  void dfs(int[] nums, int currPointer, int target, List<Integer> currCombination, int currSum) {
    if (currSum == target) {
      result.add(new ArrayList<>(currCombination));
    }
    for (int i = currPointer; i < N; i++) {
      if (currSum + nums[i] > target) {
        return;
      }
      if (i > currPointer + 1 && nums[i] == nums[i - 1])
        continue;
      currCombination.add(nums[i]);
      currSum += nums[i];
      dfs(nums, i, target, currCombination, currSum);
      currCombination.remove(currCombination.size() - 1);
      currSum -= nums[i];
    }
  }

  public List<List<Integer>> combinationSum(int[] nums, int target) {
    Arrays.sort(nums);
    result = new ArrayList<>();
    N = nums.length;
    dfs(nums, 0, target, new ArrayList<>(), 0);
    return result;
  }
}