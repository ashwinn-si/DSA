class Solution {
    public int trap(int[] arr) {
        int N = arr.length, rightPointer = N - 1;
        int leftMax[] = new int[N];
        int rightMax[] = new int[N];
        for (int leftPointer = 0; leftPointer < N; leftPointer++) {
            if (leftPointer == 0) {
                leftMax[leftPointer] = arr[0];
                rightMax[rightPointer--] = arr[N - 1];
                continue;
            }
            leftMax[leftPointer] = Math.max(leftMax[leftPointer - 1], arr[leftPointer]);
            rightMax[rightPointer] = Math.max(rightMax[rightPointer + 1], arr[rightPointer]);
            rightPointer--;
        }
        int water = 0;
        for (int i = 0; i < N; i++) {
            water += (Math.min(leftMax[i], rightMax[i]) - arr[i]);
        }
        return water;
    }
}   