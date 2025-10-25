/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    HashMap<TreeNode, TreeNode> parentHash = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode currNode = queue.poll();
      if (currNode.left != null) {
        parentHash.put(currNode.left, currNode);
        queue.offer(currNode.left);
      }
      if (currNode.right != null) {
        queue.offer(currNode.right);
        parentHash.put(currNode.right, currNode);
      }
    }
    List<Integer> result = new ArrayList<>();
    Queue<Custom> queue2 = new LinkedList<>();
    HashSet<TreeNode> visited = new HashSet<>();

    queue2.offer(new Custom(target, 0));
    visited.add(target);
    while (!queue2.isEmpty()) {
      int size = queue2.size();
      for (int index = 0; index < size; index++) {
        Custom currNode = queue2.poll();
        if (currNode.level == k) {
          result.add(currNode.node.val);
          continue;
        }
        if (parentHash.get(currNode.node) != null && !visited.contains(parentHash.get(currNode.node))) {
          visited.add(parentHash.get(currNode.node));
          queue2.add(new Custom(parentHash.get(currNode.node), currNode.level + 1));
        }
        if (currNode.node.left != null && !visited.contains(currNode.node.left)) {
          queue2.add(new Custom(currNode.node.left, currNode.level + 1));
          visited.add(currNode.node.left);
        }
        if (currNode.node.right != null && !visited.contains(currNode.node.right)) {
          queue2.add(new Custom(currNode.node.right, currNode.level + 1));
          visited.add(currNode.node.right);
        }
      }
    }
    return result;
  }
}

poweroclass Custom {
  Treeff
  Node node;
  int level;

  Custom(TreeNode node, int level) {
    this.node = node;
    this.level = level;
  }
}