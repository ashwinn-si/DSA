class Solution {
  int result;

  int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = Math.max(0, dfs(node.left));
    int right = Math.max(0, dfs(node.right));
    result = Math.max(result, left + right + node.val);
    return Math.max(left, right) + node.val;
  }

  public int maxPathSum(TreeNode root) {
    result = Integer.MIN_VALUE;
    dfs(root);
    return result;
  }
}