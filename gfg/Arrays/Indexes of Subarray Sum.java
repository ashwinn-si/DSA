class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int pointer1 = 0;
        int sum = 0;
        for(int pointer2 = 0 ; pointer2 < arr.length ; pointer2++){
            sum += arr[pointer2];
            while( sum > target){
                sum -= arr[pointer1];
                pointer1++;
            }
            if(sum == target){
                res.add(pointer1+1);
                res.add(pointer2+1);
                return res;
            }
        }
        res.add(-1);
        return res;
    }
}
