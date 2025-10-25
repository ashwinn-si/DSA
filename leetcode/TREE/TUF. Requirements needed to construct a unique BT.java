class Solution {
  public boolean uniqueBinaryTree(int a, int b) {
    // your code goes here
    return a + b == 3 || a + b == 5;
  }
}

// IMP
// Preorder And inorder
// Inorder And Postorder can only form a binary tree