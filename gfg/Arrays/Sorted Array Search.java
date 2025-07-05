class Solution {
    static boolean searchInSorted(int arr[], int k) {
        // Your code here
        for(int i  : arr){
            if(i == k){
                return true;
            }
        }
        return false;
    }
}