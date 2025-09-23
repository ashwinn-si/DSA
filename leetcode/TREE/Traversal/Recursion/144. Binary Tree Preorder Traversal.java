class Solution {
  List<Integer> tree;

  void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    tree.add(node.val);
    dfs(node.left);
    dfs(node.right);
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    tree = new ArrayList<>();
    dfs(root);
    return tree;
  }
}