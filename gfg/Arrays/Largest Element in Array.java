class Solution {
    public static int largest(int[] arr) {
        // code here
        int largest = arr[0];
        for(int i : arr){
            if(i > largest){
                largest = i;
            }
        }
        return largest;
    }
}
