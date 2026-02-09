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
  void helper(TreeNode node, List<TreeNode> nums) {
    if (node == null) {
      return;
    }
    helper(node.left, nums);
    nums.add(node);
    helper(node.right, nums);
  }

  TreeNode build(int left, int right, List<TreeNode> nums) {
    if (left > right) {
      return null;
    }
    int mid = (left + right) / 2;
    TreeNode node = nums.get(mid);
    node.left = build(left, mid - 1, nums);
    node.right = build(mid + 1, right, nums);
    return node;
  }

  public TreeNode balanceBST(TreeNode root) {
    List<TreeNode> nums = new ArrayList<>();
    helper(root, nums);
    return build(0, nums.size() - 1, nums);
  }
}