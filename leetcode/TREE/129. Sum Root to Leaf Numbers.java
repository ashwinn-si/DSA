/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        int result = 0;
        Queue<Element> queue = new LinkedList<>();
        queue.offer(new Element(root, root.val));
        while(!queue.isEmpty()){
            Element e = queue.poll();
            TreeNode node = e.node;
            int number = e.number;
            if(node.left == null && node.right == null){
                result += number;
                continue;
            }
            if(node.left != null){
                queue.offer(new Element(node.left, (number * 10) + node.left.val));
            }
            if(node.right != null){
                queue.offer(new Element(node.right, (number * 10) + node.right.val));
            }
        }
        return result;
    }
}
class Element{
    TreeNode node;
    int number;
    Element(TreeNode node, int number){
        this.node = node;
        this.number = number;
    }
}