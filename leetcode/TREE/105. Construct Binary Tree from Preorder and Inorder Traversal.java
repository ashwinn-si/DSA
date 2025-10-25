class Solution {
    HashMap<Integer, Integer> inOrderHash;
    TreeNode build(int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd, int [] preOrder, int [] inOrder){
        if(preOrderEnd - preOrderStart == 1){
            return new TreeNode(preOrder[preOrderStart]);
        }
        if(preOrderEnd - preOrderStart == 0){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preOrderStart]);
        int rootIndex = inOrderHash.get(preOrder[preOrderStart]);
        root.left = build(preOrderStart + 1, preOrderStart + 1 + (rootIndex - inOrderStart), inOrderStart, rootIndex - 1, preOrder, inOrder);
        root.right = build( preOrderStart + (rootIndex - inOrderStart) + 1, preOrderEnd, rootIndex + 1, inOrderEnd, preOrder, inOrder);
        return root;
    }
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        inOrderHash = new HashMap<>();
        for(int index = 0; index < inOrder.length; index++){
            inOrderHash.put(inOrder[index], index);
        }
        return build(0, preOrder.length, 0, inOrder.length, preOrder, inOrder);
    }
}