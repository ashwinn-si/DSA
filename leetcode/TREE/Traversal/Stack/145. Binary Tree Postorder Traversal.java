class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode currNode = root;
    Stack<TreeNode> stack = new Stack<>();
    while (currNode != null || !stack.isEmpty()) {
      if (currNode != null) {
        stack.push(currNode);
        currNode = currNode.left;
      } else {
        TreeNode temp = stack.peek().right;
        if (temp == null) {
          temp = stack.peek();
          stack.pop();
          result.add(temp.val);
          while (!stack.isEmpty() && temp == stack.peek().right) {
            temp = stack.peek();
            stack.pop();
            result.add(temp.val);
          }
        } else {
          currNode = temp;
        }
      }
    }
    return result;
  }
}