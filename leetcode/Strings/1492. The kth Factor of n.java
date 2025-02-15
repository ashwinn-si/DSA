class Solution {
    public int kthFactor(int n, int k) {
        int count = 0, result = 0;
        for(int i = 1 ; i <= n ; i++){
            if(n % i == 0){
                count++;
                result = i;
            }
            if(count == k) return result;
        }
        return -1;
    }
}