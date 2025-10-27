class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int prev = 0;
        for(int index = 0; index < bank.length; index++){
            int count = 0;
            String str = bank[index];
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '1'){
                    count++;
                }
            }
            res += (count * prev);
            prev = count == 0 ? prev : count;
        }
        return res;
    }
}