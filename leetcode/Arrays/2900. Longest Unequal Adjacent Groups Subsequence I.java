class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int checkIndex = 0, N = words.length;
        ArrayList<String> result = new ArrayList<>();
        result.add(words[0]);
        for(int index = 1; index < N; index++){
            if(groups[index] != groups[checkIndex]){
                result.add(words[index]);
                checkIndex = index;
            }
        }
        return result;
    }
}