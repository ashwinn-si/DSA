//use try catch method
class Solution {
    public int maximumValue(String[] strs) {
        int res = 0;
        for(String s : strs){
            try{
                int number = Integer.parseInt(s);
                if(number > res){
                    res = number;
                }
            }catch(Exception e){
                if(res < s.length()){
                    res = s.length();
                }
            }
        }
        return res;
    }
}