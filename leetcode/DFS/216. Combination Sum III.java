class Solution {
  List<List<Integer>> result;

  void dfs(List<Integer> currCombination, int currSum, int currIndex, int target, int lenTarget, int currSize) {
    if (currSum == target && currSize == lenTarget) {
      result.add(new ArrayList<>(currCombination));
      return;
    }
    for (int i = currIndex; i < 10; i++) {
      if (target - currSum < i || currSize + 1 > lenTarget) {
        return;
      }
      currCombination.add(i);
      dfs(currCombination, currSum + i, i + 1, target, lenTarget, currSize + 1);
      currCombination.remove(currSize);
    }
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    result = new ArrayList<>();
    dfs(new ArrayList<Integer>(), 0, 1, n, k, 0);
    return result;
  }
}