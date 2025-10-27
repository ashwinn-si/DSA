/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer result = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                result.append("null,");
                continue;
            }
            result.append(curr.val + ",");
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return result.toString();
    }

    private int getVal(String data){
        return Integer.parseInt(data);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String inputData[] = data.split(",");
        if(inputData[0].equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(getVal(inputData[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(!inputData[index].equals("null")){
                curr.left = new TreeNode(getVal(inputData[index]));
                queue.add(curr.left);
            }
            index++;
            if(!inputData[index].equals("null")){
                curr.right = new TreeNode(getVal(inputData[index]));
                queue.add(curr.right);
            }
            index++;
        }
        return root;
    }
}
