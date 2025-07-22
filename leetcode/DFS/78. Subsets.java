import java.util.ArrayList;
import java.util.List;

class Solution {
  List<List<Integer>> result;
  int N;

  public void dfs(int pointer1, List<Integer> currCombination, int[] nums) {
    result.add(new ArrayList<>(currCombination));
    for (int i = pointer1 + 1; i < N; i++) {
      currCombination.add(nums[i]);
      dfs(i, currCombination, nums);
      currCombination.remove(currCombination.size() - 1);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    result = new ArrayList<>();
    N = nums.length;
    result.add(new ArrayList<>());
    for (int i = 0; i < N; i++) {
      List<Integer> startList = new ArrayList<>();
      startList.add(nums[i]);
      dfs(i, startList, nums);
    }

    return result;
  }
}
