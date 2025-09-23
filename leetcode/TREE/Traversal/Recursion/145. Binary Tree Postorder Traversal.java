class Solution {
  List<Integer> tree;

  void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    dfs(node.left);
    dfs(node.right);
    tree.add(node.val);
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    tree = new ArrayList<>();
    dfs(root);
    return tree;
  }
}