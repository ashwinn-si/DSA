class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int st = 0, end = arr.size() - 1, result = -1, maxIndex = -1;
        while(st <= end){
            int mid = (st + end) / 2;
            if(arr.get(mid) > result){
                result = arr.get(mid);
                maxIndex = mid;
            }
            if(arr.get(mid) < arr.get(end) && arr.get(st) > arr.get(end)){
                end = mid - 1;
            }else{
                st = mid + 1;
            }
        }
        return (maxIndex + 1 )% arr.size() ;
    }
}