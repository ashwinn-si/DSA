class Solution {
    public int getSecondLargest(int[] arr) {
        int firstLargest = arr[0];
        int secondLargest = -1;
        for(int i : arr){
            if( i > firstLargest){
                secondLargest = firstLargest;
                firstLargest = i;
            }else if(i > secondLargest && i != firstLargest){
                secondLargest = i;
            }
        }
        return secondLargest;
        
    }
}