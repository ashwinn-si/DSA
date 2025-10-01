class Solution {
  int result;

  int findLevel(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = findLevel(node.left);
    int right = findLevel(node.right);
    result = Math.max(left + right, result);
    return Math.max(left, right) + 1;
  }

  public int diameterOfBinaryTree(TreeNode root) {
    result = 0;
    findLevel(root);
    return result;
  }
}