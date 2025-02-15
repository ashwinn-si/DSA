class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int N = nums.length;
        for(int i = 0 ; i < N ; i++){
            pq.offer((long)nums[i]);
        }
        int count = 0;
        while(true){
            long x = pq.poll();
            if(x >= k ){
                return count;
            }
            long y = pq.poll();
            pq.offer((long)(Math.min(x,y) * 2 + Math.max(x , y)));
            count++;
            N--;
        }

        
    } 
}