package leetcode;
class Solution {
    public void helper(int st ,int end, int [] nums){
        while(st < end){
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length ;
        k  = k % n;
        if(k == 0){
            return;
        }
        helper(0 , n-k-1 , nums);
        helper(n-k , n-1, nums);
        helper(0 , n-1, nums);
    }
}