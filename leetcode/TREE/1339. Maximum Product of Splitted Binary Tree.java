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
  long result;
  long totalSum;
  private final int MOD = 1_000_000_007;

  long totalSumFinder(TreeNode node) {
    if (node == null) {
      return 0;
    }
    long left = totalSumFinder(node.left);
    long right = totalSumFinder(node.right);
    return left + right + node.val;
  }

  long dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }
    long left = dfs(node.left);
    long right = dfs(node.right);
    long currSum = left + right + node.val;
    result = Math.max(result, ((totalSum - currSum) * currSum));
    return currSum;
  }

  public int maxProduct(TreeNode root) {
    result = 0L;
    totalSum = totalSumFinder(root);
    dfs(root);
    return (int) (result % MOD);
  }
}