class Solution {
    public String clearDigits(String s) {
        int N = s.length(), top = -1;
        char [] stack = new char[N];
        for(int i = 0 ; i < N ; i++){
            if(Character.isDigit(s.charAt(i)) && top != -1){
                top--;
            }else{
                stack[++top] = s.charAt(i);
            }
        }
        String result = "";
        return new String(stack, 0, top + 1);

    }
}