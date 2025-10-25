class Solution {
  private HashMap<Integer, Integer> inOrderIndex;

  private TreeNode build(int postStart, int postEnd,
      int inStart, int inEnd,
      int[] postOrder, int[] inOrder) {

    if (postStart > postEnd || inStart > inEnd) {
      return null;
    }

    int rootVal = postOrder[postEnd];
    TreeNode root = new TreeNode(rootVal);

    if (postStart == postEnd) {
      return root;
    }

    int rootIdx = inOrderIndex.get(rootVal);
    int leftSize = rootIdx - inStart;

    root.left = build(postStart, postStart + leftSize - 1,
        inStart, rootIdx - 1,
        postOrder, inOrder);

    root.right = build(postStart + leftSize, postEnd - 1,
        rootIdx + 1, inEnd,
        postOrder, inOrder);

    return root;
  }

  public TreeNode buildTree(int[] inOrder, int[] postOrder) {
    inOrderIndex = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++) {
      inOrderIndex.put(inOrder[i], i);
    }
    return build(0, postOrder.length - 1,
        0, inOrder.length - 1,
        postOrder, inOrder);
  }
}
