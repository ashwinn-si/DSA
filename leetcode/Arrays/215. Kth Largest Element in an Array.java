class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(int i = 0, N = nums.length ; i < N ; i++){
            queue.offer(nums[i]);
        }
        for(int i = 0; i < nums.length-k ; i++){
            queue.poll();
        }
        return queue.poll();
    }
}