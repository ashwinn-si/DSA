class Solution {
    public int[] sortByBits(int[] nums) {
        int N = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            arr.add(nums[i]);
        }

        Comparator<Integer> comp = new Comparator<Integer>(){
            @Override
		    public int compare(Integer a1, Integer a2){
                int bitA1 = helper(a1);
                int bitA2 = helper(a2);
                if(bitA1 == bitA2){
                    return Integer.compare(a1,a2);
                }
                return Integer.compare(bitA1,bitA2);
            }
        };

        Collections.sort(arr,comp);

        for(int i = 0 ; i< N ; i++){
            nums[i] = arr.get(i);
        }

        return nums;
    }
    public int helper(int num){
        int count = 0;
        while(num != 0){
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
}