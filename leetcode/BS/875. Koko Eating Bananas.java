class Solution {
    static long helper(int n, int m){
        return (n + m - 1) / m;
    }
    public int minEatingSpeed(int[] nums, int h) {
        int st = 1, end = 0;
        for(int num: nums){
            end = Math.max(num, end);
        }
        int result = end;
        while(st <= end){
            int mid = (st + end) / 2;
            long time = 0;
            for(int num : nums){
                time += helper(num, mid);
                if(time > h){
                    break;
                }
            }
            if(time <= h){
                result = mid;
                end = mid - 1;
            }else{
                st = mid + 1;
            }
        }
        return result;
    }
}