class Solution {
  boolean checkChildrenSum(TreeNode root) {
    if (root == null || (root.left == null && root.right == null))
      return true;
    // Your code goes here
    int currSum = 0;
    if (root.left != null)
      currSum += root.left.val;
    if (root.right != null)
      currSum += root.right.val;
    return currSum == root.val & checkChildrenSum(root.left) && checkChildrenSum(root.right);
  }
}
