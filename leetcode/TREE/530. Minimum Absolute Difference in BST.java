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
  Integer prev = null;
  int answer;

  void inOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    if (prev != null) {
      answer = Math.min(answer, Math.abs(prev - node.val));
    }
    prev = node.val;
    inOrder(node.right);
  }

  public int getMinimumDifference(TreeNode root) {
    answer = Integer.MAX_VALUE;
    inOrder(root);
    return answer;
  }
}