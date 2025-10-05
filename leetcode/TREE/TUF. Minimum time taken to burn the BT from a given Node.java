
class Solution {
  public int timeToBurnTree(TreeNode root, int start) {
    // your code goes here
    TreeNode target = new TreeNode(-1);
    HashMap<TreeNode, TreeNode> hash = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode currNode = queue.poll();
      if (currNode.data == start) {
        target = currNode;
      }
      if (currNode.left != null) {
        queue.offer(currNode.left);
        hash.put(currNode.left, currNode);
      }
      if (currNode.right != null) {
        queue.offer(currNode.right);
        hash.put(currNode.right, currNode);
      }
    }

    queue.clear();
    HashSet<TreeNode> set = new HashSet<>();
    int result = 0;
    queue.offer(target);
    set.add(target);
    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean flag = false;
      for (int index = 0; index < size; index++) {
        TreeNode currNode = queue.poll();
        if (hash.get(currNode) != null && !set.contains(hash.get(currNode))) {
          set.add(hash.get(currNode));
          queue.offer(hash.get(currNode));
          flag = true;
        }
        if (currNode.left != null && !set.contains(currNode.left)) {
          set.add(currNode.left);
          queue.offer(currNode.left);
          flag = true;
        }
        if (currNode.right != null && !set.contains(currNode.right)) {
          set.add(currNode.right);
          queue.offer(currNode.right);
          flag = true;
        }
      }
      if (flag) {
        result++;
      }
    }
    return result;
  }
}