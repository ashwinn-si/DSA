class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    TreeMap<Integer, Integer> hash = new TreeMap<>();
    Queue<Custom> queue = new LinkedList<>();
    queue.add(new Custom(root, 0));
    while (!queue.isEmpty()) {
      Custom curr = queue.poll();
      if (curr.node == null)
        continue;
      if (hash.get(curr.level) == null) {
        hash.put(curr.level, curr.node.val);
      }
      queue.offer(new Custom(curr.node.right, curr.level + 1));
      queue.offer(new Custom(curr.node.left, curr.level + 1));
    }
    List<Integer> res = new ArrayList<>();
    for (int key : hash.keySet()) {
      res.add(hash.get(key));
    }
    return res;
  }
}

class Custom {
  TreeNode node;
  int level;

  Custom(TreeNode node, int level) {
    this.node = node;
    this.level = level;
  }
}