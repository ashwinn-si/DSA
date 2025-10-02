class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean leftToRight = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> curr = new ArrayList<>();
      for (int index = 0; index < size; index++) {
        TreeNode currNode = queue.poll();
        if (leftToRight) {
          curr.addLast(currNode.val);
        } else {
          curr.addFirst(currNode.val);
        }
        if (currNode.left != null)
          queue.offer(currNode.left);
        if (currNode.right != null)
          queue.offer(currNode.right);
      }
      leftToRight = !leftToRight;
      result.add(curr);
    }
    return result;
  }
}