class Solution {
  List<List<Integer>> result;

  void dfs(int[] nums, int freq[], int currPointer, int remainingElements, int N, List<Integer> currCombination) {
    if (remainingElements == 0) {
      result.add(new ArrayList<>(currCombination));
      return;
    }
    int exporing = 0;
    while (exporing < remainingElements) {
      int currIndex = currPointer % N;
      if (freq[currIndex] == 0) {
        freq[currIndex]++;
        currCombination.add(nums[currIndex]);
        dfs(nums, freq, currPointer + 1, remainingElements - 1, N, currCombination);
        currCombination.remove(currCombination.size() - 1);
        freq[currIndex]--;
        exporing++;
      }
      currPointer++;
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    result = new ArrayList<>();
    int N = nums.length;
    dfs(nums, new int[N], 0, N, N, new ArrayList<>());
    return result;
  }
}