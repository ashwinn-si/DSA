class Solution {
  int dfs(TreeNode root, int level) {
    if (root == null) {
      return level;
    }
    return Math.max(dfs(root.right, level + 1), dfs(root.left, level + 1));
  }

  public int maxDepth(TreeNode root) {
    return dfs(root, 0);
  }
}