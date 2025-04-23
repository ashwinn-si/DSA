class Solution {
    public boolean search(int[] nums, int target) {
        int st = 0, end = nums.length - 1, len = nums.length;
        while(st <= end){
            int mid = (st + end) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[st] == nums[mid] && nums[mid] == nums[end]){
                st++;
                end--;
                continue;
            }
            if(nums[st] <= nums[mid]){
                if(nums[st] <= target && target <= nums[mid]){
                    end = mid - 1;
                }else{
                    st = mid + 1;
                }
            }else{
                if(nums[end] >= target && target >= nums[mid]){
                    st = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}