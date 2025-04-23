class Solution {
    public int search(int[] nums, int target) {
        int st = 0, end = nums.length - 1, result = -1;
        while(st <= end){
            int mid = (st + end) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[st] <= nums[mid]){
                //left part is in sorted order
                if(nums[st] <= target && target <= nums[mid]){
                    end = mid - 1;
                }else{
                    st = mid + 1;
                }
            }else{
                //right part is in sorted order
                if(nums[mid] <= target && nums[end] >= target){
                    st = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}