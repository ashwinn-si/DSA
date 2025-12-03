class Solution {
  public int kthSmallest(TreeNode root, int k) {
    Queue<Integer> pq = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    TreeNode currNode = root;
    // USING INORDER TRAVERSAL GIVES THE ORDERED VALUE IN BST
    while (true) {
      if (currNode != null) {
        stack.add(currNode);
        currNode = currNode.left;
      } else {
        if (stack.isEmpty()) {
          break;
        }
        currNode = stack.pop();
        pq.offer(currNode.val);
        currNode = currNode.right;
      }
    }
    while (k-- > 1) {
      pq.poll();
    }
    return pq.peek();
  }
}