//INFO SOLUTION 1
class Solution {
  ArrayList<TreeNode> target1Path;
  ArrayList<TreeNode> target2Path;

  boolean findPath(TreeNode node, TreeNode target, ArrayList<TreeNode> curr, int targetVal) {
    if (node == target) {
      curr.add(target);
      if (targetVal == 1) {
        target1Path = new ArrayList<>(curr);
      } else {
        target2Path = new ArrayList<>(curr);
      }
      return true;
    }
    curr.add(node);
    if (node.left != null)
      if (findPath(node.left, target, curr, targetVal))
        return true;
    if (node.right != null)
      if (findPath(node.right, target, curr, targetVal))
        return true;
    curr.remove(curr.size() - 1);
    return false;
  }

  TreeNode getResult(List<TreeNode> path1, List<TreeNode> path2) {
    TreeNode result = path1.get(0);
    int pointer = 0;
    int size = path1.size();
    while (pointer < size) {
      if (path1.get(pointer) == path2.get(pointer)) {
        result = path1.get(pointer);
      }
      pointer++;
    }
    return result;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode target1, TreeNode target2) {
    target1Path = new ArrayList<>();
    target2Path = new ArrayList<>();
    TreeNode cpyRoot = root;
    findPath(root, target1, new ArrayList<TreeNode>(), 1);
    findPath(cpyRoot, target2, new ArrayList<TreeNode>(), 2);

    return target1Path.size() < target2Path.size() ? getResult(target1Path, target2Path)
        : getResult(target2Path, target1Path);
  }
}

// INFO SOLUTION 2
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q)
      return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null)
      return root;

    return left != null ? left : right;
  }
}