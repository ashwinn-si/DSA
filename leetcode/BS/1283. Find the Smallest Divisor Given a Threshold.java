class Solution {
    int toCeil(int num, int divi){
        return (num + divi - 1) / divi;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int st = 1 , end = nums[0];

        for(int num: nums){
            end = Math.max(num, end);
        }
        
        int result = st;
        while(st <= end){
            int mid = (st + end) / 2;
            int value = 0;
            for(int num : nums){
                value += toCeil(num, mid);
                if(value > threshold) break;
            }
            if(value <= threshold){
                result = mid;
                end = mid - 1;
            }else{
                st = mid + 1;
            }
        }
        return result;
    }
}