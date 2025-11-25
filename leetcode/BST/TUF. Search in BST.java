class Solution {
  public TreeNode searchBST(TreeNode root, int val) {
    // your code goes here
    if (root == null) {
      return null;
    }
    if (root.data == val) {
      return root;
    }
    return root.data > val ? searchBST(root.left, val) : searchBST(root.right, val);
  }
}