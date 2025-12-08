class Solution {
  List<Integer> succPredBST(TreeNode root, int key) {
    // your code goes here
    int pre = -1;
    int succ = -1;
    while (root != null) {
      if (root.data == key) {
        if (root.left != null) {
          TreeNode temp = root.left;
          while (temp.right != null) {
            temp = temp.right;
          }
          pre = temp.data;
        }
        if (root.right != null) {
          TreeNode temp = root.right;
          while (temp.left != null) {
            temp = temp.left;
          }
          succ = temp.data;
        }
        break;
      } else if (root.data > key) {
        // go left
        succ = root.data;
        root = root.left;
      } else {
        // go right
        pre = root.data;
        root = root.right;
      }
    }
    return new ArrayList<>(Arrays.asList(pre, succ));
  }
}