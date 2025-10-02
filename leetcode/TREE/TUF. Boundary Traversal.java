/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int data;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
  List<Integer> result;

  void traverLeft(TreeNode node) {
    if (node == null) {
      return;
    }
    if (node.left != null || node.right != null) {
      result.add(node.data);
    }
    if (node.left == null) {
      traverLeft(node.right);
    } else {
      traverLeft(node.left);
    }
  }

  void leafNode(TreeNode node) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      result.add(node.data);
    }
    leafNode(node.left);
    leafNode(node.right);
  }

  void traverseRight(TreeNode node) {
    if (node == null) {
      return;
    }

    if (node.right != null) {
      traverseRight(node.right);
    } else {
      traverseRight(node.left);
    }
    if (node.left != null || node.right != null) {
      result.add(node.data);
    }
  }

  public List<Integer> boundary(TreeNode root) {
    // your code goes here
    result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    result.add(root.data);

    traverLeft(root.left);
    leafNode(root.left);
    leafNode(root.right);
    traverseRight(root.right);
    return result;
  }

}