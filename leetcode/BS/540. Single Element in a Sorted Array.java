class Solution {
    public int singleNonDuplicate(int[] nums) {
        int st = 0, end = nums.length - 1, len = nums.length;
        while(st <= end){
            int mid = (st + end) / 2;
            if(mid + 1 < len && nums[mid + 1] == nums[mid]){
                if(mid % 2 == 0){
                    st = mid + 2 ;
                }else{
                    end = mid - 1;
                }
            }else if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]){
                if(mid % 2 == 0){
                    end = mid - 2;
                }else{
                    st = mid + 1;
                }
            }else{
                return nums[mid];
            }
        }
        return -1;
    }
}