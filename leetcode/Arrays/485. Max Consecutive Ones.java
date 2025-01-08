class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int currSum = 0;
        for(int i : nums){
            if(i == 0){
                if(currSum > res){
                    res = currSum;
                }
                currSum = 0;
            }
            currSum += i;
        }
        if(currSum > res){
            res = currSum;
        }
        return res;
    }
}