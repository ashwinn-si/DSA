class BSTIterator {
  Stack<Custom> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    stack.push(new Custom(root));
  }

  public int next() {
    while (true) {
      if (stack.isEmpty()) {
        return -1;
      }
      Custom cus = stack.pop();
      if (cus.left && cus.right) {
        return cus.node.val;
      }
      if (cus.left == false) {
        cus.left = true;
        stack.push(cus);
        if (cus.node.left != null) {
          stack.push(new Custom(cus.node.left));
        }
      } else {
        cus.right = true;
        if (cus.node.right != null) {
          stack.push(new Custom(cus.node.right));
        }
        stack.push(cus);
      }
    }
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }
}

class Custom {
  TreeNode node;
  boolean left, right;

  Custom(TreeNode node) {
    this.node = node;
    this.left = false;
    this.right = false;
  }
}
