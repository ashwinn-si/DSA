class Solution {
  TreeNode dfs(int nums[], int start, int end, int n) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(nums[mid]);

    node.left = dfs(nums, start, mid - 1, n);

    node.right = dfs(nums, mid + 1, end, n);

    return node;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    int n = nums.length;
    return dfs(nums, 0, n - 1, n);
  }
}