class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int N = nums.length;
        Arrays.sort(nums);
        for(int A = 0 ; A < N-2 ; A++){
            if(A > 0 && nums[A] == nums[A-1]) continue;
            int B = A+1;
            int C = N-1;
            while(B < C){
                int currSum = nums[A]+nums[B]+nums[C];
                if(currSum == 0){
                    result.add(new ArrayList<>(Arrays.asList(nums[A], nums[B], nums[C])));
                    B++;
                    C--;
                    while(B < C && nums[B] == nums[B-1]) B++;
                    while(B < C && nums[C] == nums[C+1]) C--;
                    
                }else if(currSum > 0){
                    C--;
                }else{
                    B++;
                }
            }
        }
        return result;
    }
}