class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root == null)
      return result;
    TreeNode currNode = root;
    while (true) {
      if (currNode != null) {
        stack.add(currNode);
        currNode = currNode.left;
      } else {
        if (stack.isEmpty()) {
          break;
        }
        currNode = stack.pop();
        result.add(currNode.val);
        currNode = currNode.right;
      }
    }
    return result;
  }

}