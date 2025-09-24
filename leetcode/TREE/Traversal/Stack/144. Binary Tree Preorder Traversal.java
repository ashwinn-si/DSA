class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null)
      return result;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode currNode = stack.pop();
      result.add(currNode.val);
      if (currNode.right != null) {
        stack.push(currNode.right);
      }
      if (currNode.left != null) {
        stack.push(currNode.left);
      }
    }
    return result;
  }
}