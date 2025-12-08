class Solution {
  TreeNode build(int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd, int preOrder[], int inOrder[],
      HashMap<Integer, Integer> hash) {
    if (preOrderEnd - preOrderStart == 1) {
      return new TreeNode(preOrder[preOrderStart]);
    }
    if (preOrderEnd - preOrderStart == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preOrder[preOrderStart]);
    int rootIndex = hash.get(preOrder[preOrderStart]);
    root.left = build(preOrderStart + 1, preOrderStart + 1 + (rootIndex - inOrderStart), inOrderStart, rootIndex - 1,
        preOrder, inOrder, hash);
    root.right = build(preOrderStart + 1 + (rootIndex - inOrderStart), preOrderEnd, rootIndex + 1, inOrderEnd, preOrder,
        inOrder, hash);
    return root;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    int inOrder[] = Arrays.copyOf(preorder, preorder.length);
    Arrays.sort(inOrder);
    HashMap<Integer, Integer> inOrderHash = new HashMap<>();
    for (int index = 0; index < preorder.length; index++) {
      inOrderHash.put(inOrder[index], index);
    }
    return build(0, preorder.length, 0, preorder.length, preorder, inOrder, inOrderHash);
  }
}

// INFO SOLUTION 2
class Solution {
  TreeNode build(TreeNode root, int num) {
    if (root == null) {
      return new TreeNode(num);
    }
    if (root.val > num) {
      root.left = build(root.left, num);
    } else {
      root.right = build(root.right, num);
    }
    return root;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    TreeNode root = null;
    for (int num : preorder) {
      root = build(root, num);
    }
    return root;
  }
}