class Solution {
  TreeMap<Integer, Integer> topNode;
  TreeMap<Integer, Integer> minDepth;

  void dfs(TreeNode node, int y, int x) {
    if (node == null) {
      return;
    }
    if (!topNode.containsKey(y) || x < minDepth.get(y)) {
      topNode.put(y, node.data);
      minDepth.put(y, x);
    }
    dfs(node.left, y - 1, x + 1);
    dfs(node.right, y + 1, x + 1);
  }

  public List<Integer> topView(TreeNode root) {
    topNode = new TreeMap<>();
    minDepth = new TreeMap<>();
    List<Integer> result = new ArrayList<>();
    dfs(root, 0, 0);
    for (int key : topNode.keySet()) {
      result.add(topNode.get(key));
    }
    return result;
  }
}
