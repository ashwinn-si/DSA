class Solution {
    public int findMin(int[] nums) {
        int st = 0, end = nums.length - 1, result = Integer.MAX_VALUE;
        while(st <= end){
            int mid = (st + end) / 2;
            result = Math.min(result, nums[mid]);
            if(nums[mid] > nums[end]){
                st = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return  result;
    }
}