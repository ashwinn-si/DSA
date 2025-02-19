class Solution {
    public String smallestNumber(String pattern) {
        int count = 1, N  = pattern.length(), i =0;
        String result = "";
        while(i < N){
            if(pattern.charAt(i) == 'I'){
                result+= (char) (count + '0');
                count++;
                i++;
            }else{
                int incCount = count;
                while(i < N){
                    if(pattern.charAt(i) == 'D'){
                        incCount++;
                        i++;
                    }else{
                        break;
                    }
                }
                if(incCount == 10){
                    incCount = 9;
                }
                for(int j = incCount; j >= count; j--){
                    result+= (char) (j + '0');
                }
                count = incCount + 1;
                i++;
            }
        }
        if(pattern.charAt(N-1) == 'I'){
            result+=count;
        }
        return result;
    }
}