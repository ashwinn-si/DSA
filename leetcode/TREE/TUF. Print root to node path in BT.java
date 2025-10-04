class Solution {
    List<List<Integer>> result;
    void dfs(TreeNode node, List<Integer> curr){
        curr.add(node.data);
        if(node.left == null && node.right == null){
            result.add(new ArrayList<>(curr));
        }else{
            if(node.left != null) dfs(node.left, curr);
            if(node.right != null) dfs(node.right, curr);
        }
        curr.remove(curr.size() - 1);
    }
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        //your code goes here
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        dfs(root, new ArrayList<Integer>());
        return result;
    }
}