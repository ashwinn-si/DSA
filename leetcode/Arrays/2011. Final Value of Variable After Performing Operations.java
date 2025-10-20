class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int num = 0;
        for(String str: operations){
            if(str.charAt(1) == '+'){
                num++;
            }else{
                num--;
            }
        }
        return num;
    }
}