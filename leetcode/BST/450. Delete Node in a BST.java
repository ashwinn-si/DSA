class Solution {
  TreeNode findLastRight(TreeNode node) {
    while (node.right != null) {
      node = node.right;
    }
    return node;
  }

  TreeNode helper(TreeNode root) {
    if (root.left == null) {
      return root.right;
    } else if (root.right == null) {
      return root.left;
    } else {
      TreeNode rightChild = root.right;
      TreeNode lastRight = findLastRight(root.left);
      lastRight.right = rightChild;
      return root.left;
    }
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val == key) {
      return helper(root);
    }
    TreeNode dummy = root;
    while (dummy != null) {
      if (dummy.left != null && dummy.left.val == key) {
        dummy.left = helper(dummy.left);
        break;
      } else if (dummy.right != null && dummy.right.val == key) {
        dummy.right = helper(dummy.right);
        break;
      } else {
        if (dummy.val > key) {
          dummy = dummy.left;
        } else {
          dummy = dummy.right;
        }
      }
    }
    return root;
  }
}