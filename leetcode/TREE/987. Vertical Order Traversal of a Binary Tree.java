/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  TreeMap<Integer, List<Custom>> hash;

  void dfs(TreeNode node, int y, int x) {
    if (node == null) {
      return;
    }
    hash.computeIfAbsent(y, k -> new ArrayList<>()).add(new Custom(node.val, x, y));
    dfs(node.left, y - 1, x + 1);
    dfs(node.right, y + 1, x + 1);
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    hash = new TreeMap<>();
    List<List<Integer>> result = new ArrayList<>();
    dfs(root, 0, 0);
    for (int key : hash.keySet()) {
      List<Custom> currRes = hash.get(key);
      List<Integer> res = new ArrayList<>();
      Collections.sort(currRes, (a, b) -> a.x == b.x && a.y == b.y ? a.val - b.val : a.x - b.x);
      for (Custom obj : currRes) {
        res.add(obj.val);
      }
      result.add(res);
    }
    return result;
  }
}

class Custom {
  int val;
  int x, y;

  Custom(int val, int x, int y) {
    this.val = val;
    this.x = x;
    this.y = y;
  }
}