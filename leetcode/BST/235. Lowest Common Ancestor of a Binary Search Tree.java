/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int min = Math.min(p.val, q.val);
    int max = Math.max(p.val, q.val);
    while (root != null) {
      // both targets lies on left
      if (max < root.val) {
        root = root.left;
      } else if (min > root.val) {
        // both targets lies on right
        root = root.right;
      } else {
        // targets lies on different sides
        return root;
      }
    }
    return null;
  }
}