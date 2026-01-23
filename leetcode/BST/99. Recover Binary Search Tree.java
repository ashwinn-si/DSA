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
  private TreeNode first = null;
  private TreeNode second = null;
  private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

  void inorder(TreeNode node) {
    if (node == null) {
      return;
    }
    inorder(node.left);
    if (prev.val > node.val) {
      if (first == null) {
        first = prev;
        second = node;
      } else {
        second = node;
      }
    }
    prev = node;
    inorder(node.right);
  }

  public void recoverTree(TreeNode root) {
    inorder(root);
    if (first != null && second != null) {
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
    }
  }
}