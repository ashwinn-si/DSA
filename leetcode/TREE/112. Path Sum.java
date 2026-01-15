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
  boolean dfs(TreeNode node, int target, int curr) {
    if (node == null) {
      return false;
    }

    curr += node.val;

    if (node.left == null && node.right == null) {
      return curr == target;
    }

    return dfs(node.left, target, curr) ||
        dfs(node.right, target, curr);
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    return dfs(root, targetSum, 0);
  }
}