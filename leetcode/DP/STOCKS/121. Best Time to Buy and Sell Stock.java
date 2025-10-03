class Solution {
    public int maxProfit(int[] nums) {
        int buyPrice = nums[0];
        int result = 0;
        for(int num: nums){
            result = Math.max(result, num - buyPrice);
            if(num < buyPrice){
                buyPrice = num;
            }
        }
        return result;
    }
}