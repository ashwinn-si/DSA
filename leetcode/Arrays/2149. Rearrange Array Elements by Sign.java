class Solution {
    public int[] rearrangeArray(int[] nums) {
        int N = nums.length;
        int res[] = new int[N];
        int p1 = 0;
        int p2 = 1;
        for(int i = 0 ; i < N ; i++){
            if(nums[i] > 0){
                res[p1] = nums[i];
                p1 += 2;
            }else{
                res[p2] = nums[i];
                p2 += 2;
            }
        }
        return res;
    }
}