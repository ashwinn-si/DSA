class Solution {
    int helper(int st , int end , int target , int[] nums){
        if(st > end){
            return -1;
        }
        int mid = (st+end) / 2;
        if(nums[mid] > target){
           return  helper(st , mid-1 , target, nums);
        }else if(nums[mid] < target){
            return helper(mid+1, end , target , nums);
        }
        return mid;
        

    }
    public int search(int[] nums, int target) {
        return helper(0 , nums.length-1 , target , nums);
    }
}