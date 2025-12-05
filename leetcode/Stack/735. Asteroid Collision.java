class Solution {
    public int[] asteroidCollision(int[] nums) {
        int N = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int index = 0; index < N; index++){
            int num = nums[index];
            if(num > 0){
                stack.push(num);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num){
                    stack.pop();
                }
                if(stack.isEmpty()|| (stack.peek() < 0 && num < 0)){
                    stack.push(num);
                }
                if(stack.peek() == -num){
                    stack.pop();
                }
            }
        }
        int result[] = new int[stack.size()];
        int index = stack.size() - 1;
        while(!stack.isEmpty()){
            result[index--] = stack.pop();
        }
        return result;
    }
}