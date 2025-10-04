class Solution {
  public int widthOfBinaryTree(TreeNode root) {
    long result = 0;
    Queue<Custom> queue = new LinkedList<>();
    queue.offer(new Custom(root, 0L));
    while (!queue.isEmpty()) {
      int size = queue.size();
      long left = 0;
      long right = 0;
      for (int index = 0; index < size; index++) {
        Custom curr = queue.poll();
        if (curr.node.left != null)
          queue.offer(new Custom(curr.node.left, curr.x * 2));
        if (curr.node.right != null)
          queue.offer(new Custom(curr.node.right, curr.x * 2 + 1));
        if (index == 0) {
          left = curr.x;
        }
        if (index == size - 1) {
          right = curr.x;
        }
      }
      result = Math.max(right - left + 1, result);
    }
    return (int) result;
  }
}

class Custom {
  TreeNode node;
  long x;

  Custom(TreeNode node, long x) {
    this.node = node;
    this.x = x;
  }
}