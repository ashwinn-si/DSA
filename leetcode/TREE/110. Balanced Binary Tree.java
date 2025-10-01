class Solution {
  int findLevel(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = findLevel(node.left);
    if (left == -1)
      return -1;
    int right = findLevel(node.right);
    if (right == -1)
      return -1;

    if (Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }

  public boolean isBalanced(TreeNode root) {
    return findLevel(root) != -1;
  }
}
