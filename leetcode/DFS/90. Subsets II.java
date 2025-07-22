import java.util.ArrayList;
import java.util.List;

class Solution {
  List<List<Integer>> result;
  int N;

  public void dfs(int pointer1, List<Integer> currCombination, int[] nums) {
    result.add(new ArrayList<>(currCombination));
    for (int i = pointer1 + 1; i < N; i++) {
      if (i > pointer1 + 1 && nums[i] == nums[i - 1])
        continue;
      currCombination.add(nums[i]);
      dfs(i, currCombination, nums);
      currCombination.remove(currCombination.size() - 1);
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    result = new ArrayList<>();
    N = nums.length;
    result.add(new ArrayList<>());
    Arrays.sort(nums);
    int freq[] = new int[10];
    for (int i = 0; i < N; i++) {
      // skip the duplicates
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      List<Integer> startList = new ArrayList<>();
      startList.add(nums[i]);
      dfs(i, startList, nums);
    }

    return result;
  }
}
