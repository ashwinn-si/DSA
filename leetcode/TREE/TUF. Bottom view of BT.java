class Solution {
  TreeMap<Integer, Integer> BottomNode;
  TreeMap<Integer, Integer> minDepth;

  void dfs(TreeNode node, int y, int x) {
    if (node == null) {
      return;
    }
    if (!BottomNode.containsKey(y) || x >= minDepth.get(y)) {
      BottomNode.put(y, node.data);
      minDepth.put(y, x);
    }
    dfs(node.left, y - 1, x + 1);
    dfs(node.right, y + 1, x + 1);
  }

  public List<Integer> bottomView(TreeNode root) {
    BottomNode = new TreeMap<>();
    minDepth = new TreeMap<>();
    List<Integer> result = new ArrayList<>();
    dfs(root, 0, 0);
    for (int key : BottomNode.keySet()) {
      result.add(BottomNode.get(key));
    }
    return result;
  }
}

// BFS

class Solution {
  public List<Integer> bottomView(TreeNode root) {
    // your code goes here
    TreeMap<Integer, Integer> hash = new TreeMap<>();
    Queue<Custom> queue = new LinkedList<>();
    queue.add(new Custom(root, 0));
    while (!queue.isEmpty()) {
      Custom curr = queue.poll();
      if (curr.node == null)
        continue;
      hash.put(curr.y, curr.node.data);
      queue.add(new Custom(curr.node.left, curr.y - 1));
      queue.add(new Custom(curr.node.right, curr.y + 1));
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
  int y;

  Custom(TreeNode node, int y) {
    this.node = node;
    this.y = y;
  }
}