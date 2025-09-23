class Solution {
  List<Integer> tree;

  void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    dfs(node.left);
    tree.add(node.val);
    dfs(node.right);
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    tree = new ArrayList<>();
    dfs(root);
    return tree;
  }
}