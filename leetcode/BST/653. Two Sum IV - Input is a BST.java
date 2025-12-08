class Solution {
  boolean processBST(TreeNode node, int target, HashMap<Integer, Integer> hash) {
    if (node == null) {
      return false;
    }
    if (hash.get(node.val) != null) {
      return true;
    }
    hash.put(target - node.val, -1);
    return processBST(node.left, target, hash) || processBST(node.right, target, hash);
  }

  public boolean findTarget(TreeNode root, int k) {
    HashMap<Integer, Integer> hash = new HashMap<>();
    return processBST(root, k, hash);
  }
}