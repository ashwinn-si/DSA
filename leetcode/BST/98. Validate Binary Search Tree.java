class Solution {
  boolean helper(TreeNode node, long start, long end) {
    if (node == null) {
      return true;
    }
    if (node.val <= start || node.val >= end) {
      return false;
    }
    return helper(node.left, start, Math.min(end, node.val)) && helper(node.right, Math.max(start, node.val), end);
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return true;
    }
    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
}