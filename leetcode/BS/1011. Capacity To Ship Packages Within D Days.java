class Solution {
    public int shipWithinDays(int[] nums, int days) {
        int st = 0, end = 0;
        for(int num: nums){
            st = (st > num)? st : num;
            end += num;
        }
        if(days == 1){
            return end;
        }
        int result = end;
        while(st <= end){
            int mid = (st + end) / 2;
            int noDaysRequired = 0;
            int currWeight = 0;
            for(int num : nums){
                currWeight += num;
                if(currWeight == mid){
                    currWeight = 0;
                    noDaysRequired ++;
                }else if(currWeight > mid){
                    noDaysRequired += currWeight / mid;
                    currWeight = num;
                }
            }
            noDaysRequired += ((currWeight + mid - 1) / mid);
            if(noDaysRequired <= days){
                result = mid;
                end = mid - 1;
            }else{
                st = mid + 1;
            }
        }
        return result;
    }
}