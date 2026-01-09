class Solution {
  List<List<Integer>> result;

  void dfs(int index, int noElements, int n, int k, List<Integer> curr) {
    if (noElements == k) {
      result.add(new ArrayList<>(curr));
      return;
    }
    if (index > n) {
      return;
    }
    dfs(index + 1, noElements, n, k, curr);
    curr.add(index);
    dfs(index + 1, noElements + 1, n, k, curr);
    curr.remove(curr.size() - 1);
  }

  public List<List<Integer>> combine(int n, int k) {
    result = new ArrayList<>();
    dfs(1, 0, n, k, new ArrayList<>());
    return result;
  }
}