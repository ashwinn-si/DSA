class Solution {
  TreeMap<Integer, Integer> BottomNode;
  TreeMap<Integer, Integer> minDepth;

  void dfs(TreeNode node, int y, int x) {
    if (node == null) {
      return;
    }
    if (!BottomNode.containsKey(y) || x >= minDepth.get(y)) {
      BottomNode.put(y, node.data);
      minDepth.put(y, x);
    }
    dfs(node.left, y - 1, x + 1);
    dfs(node.right, y + 1, x + 1);
  }

  public List<Integer> bottomView(TreeNode root) {
    BottomNode = new TreeMap<>();
    minDepth = new TreeMap<>();
    List<Integer> result = new ArrayList<>();
    dfs(root, 0, 0);
    for (int key : BottomNode.keySet()) {
      result.add(BottomNode.get(key));
    }
    return result;
  }
}