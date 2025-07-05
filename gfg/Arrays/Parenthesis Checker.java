class Solution {
    // Function to check if brackets are balanced or not.
    static boolean isParenthesisBalanced(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        int N = s.length();
        for(int i = 0 ; i < N ; i++){
            char ch1 = s.charAt(i);
            if(ch1 != '(' && ch1 !='{' && ch1 != '['){
                if(stack.isEmpty()){
                    return false;
                }
                char ch2 = stack.pop();
                if(ch2 != '(' && ch1 == ')'){
                    return false;
                }else if(ch2 != '{' && ch1 == '}'){
                    return false;
                }else if(ch2 != '[' && ch1 == ']'){
                    return false;
                }
            }else{
                stack.push(ch1);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
