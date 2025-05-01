class Solution {
    static boolean isBloom(int bloomDay, int currDay){
        return bloomDay <= currDay;
    }
    public int minDays(int[] nums, int m, int k) {
        int len = nums.length, st = nums[0], end = nums[0];
        if(len < m * k || k == 0){
            return -1; //impossible case
        }
        for(int num: nums){
            st = Math.min(st, num);
            end = Math.max(end, num);
        }
        int result = -1;
        while(st <= end){
            int mid = (st + end) / 2;
            int noBouquets = 0, count = 0;
            for(int num: nums){
                if(isBloom(num, mid)){
                    count++;
                }else{
                    noBouquets += count / k;
                    count = 0;
                }
            }
            noBouquets += count / k;
            System.out.println(st+" "+end+" "+noBouquets);
            if(noBouquets >= m){
                result = mid;
                end = mid - 1;
            }else{
                st = mid + 1;
            }
        }
        return result;
    }
}