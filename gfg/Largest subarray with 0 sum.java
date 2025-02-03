class Solution {
    int maxLen(int arr[]) {
        // code here
        HashMap<Integer, Integer> hash = new HashMap<>();
        int currSum = 0, N = arr.length, result = 0;
        for(int i = 0 ; i < N ; i++){
            currSum += arr[i];
            if(currSum == 0){
                result = Math.max(result , i+1);
            }else{
                if(hash.get(currSum) != null){
                    result = Math.max(result , i - hash.get(currSum));
                }else{
                    hash.put(currSum,i);
                }
            }
        }
        return result;
    }
}