class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int index = 0; index < size; index++) {
                TreeNode currNode = queue.poll();
                if (currNode != null) {
                    currLevel.add(currNode.val);
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                }
            }
            if (currLevel.size() > 0)
                result.add(currLevel);
        }

        return result;
    }
}