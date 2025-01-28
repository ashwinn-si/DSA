class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0, count2 = 0, element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;
        int N = nums.length;
        for(int i = 0 ; i < N ; i++){
            if(count1 == 0 && nums[i] != element2){
                element1 = nums[i];
                count1 = 1;
            }else if(count2 == 0 && nums[i] != element1){
                element2 = nums[i];
                count2 = 1;
            }else if(nums[i] == element1) count1++;
            else if(nums[i] == element2) count2++;
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int  i = 0 ; i < N; i++){
            if(nums[i] == element1){
                count1++;
            }else if(nums[i] == element2){
                count2++;
            }
        }

        if(count1 > N / 3 ) result.add(element1);
        if(count2 > N / 3) result.add(element2);

        return result;
    }
}