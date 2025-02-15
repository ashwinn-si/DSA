class Solution {
    private int helper(int N){
        int sum = 0;
        while(N != 0){
            sum += N %10;
            N /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int result = -1, N = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            int sumDigit = helper(nums[i]);
            if(hash.get(sumDigit) != null){
                int num = hash.get(sumDigit);
                result = Math.max(result, nums[i]+num);
                hash.put(sumDigit, Math.max(nums[i],num));
            }else{
                hash.put(sumDigit, nums[i]);
            }
        }
        return result;
    }
}