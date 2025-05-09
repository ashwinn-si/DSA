class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = heights[i];
        }
        int res = 0;
        Arrays.sort(heights);
        for(int i = 0 ; i < n ; i++){
            res += (arr[i] != heights[i]) ? 1 : 0;
        }
        return res;
    }
}