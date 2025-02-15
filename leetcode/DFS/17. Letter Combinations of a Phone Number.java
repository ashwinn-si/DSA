class Solution {
    private HashMap<Character, String> hash = new HashMap<>();
    private List<String> answer = new ArrayList<>();

    private void dfs(String inputString, int currIndex, int N, String currCombination){
        if(currIndex == N){
            answer.add(currCombination);
            return;
        }
        String currIndexString = hash.get(inputString.charAt(currIndex));
        int len = currIndexString.length();
        for(int i = 0 ; i < len ; i++){
            dfs(inputString, currIndex+1, N, currCombination+currIndexString.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        hash.put('2',"abc");
        hash.put('3',"def");
        hash.put('4',"ghi");
        hash.put('5',"jkl");
        hash.put('6',"mno");
        hash.put('7',"pqrs");
        hash.put('8',"tuv");
        hash.put('9',"wxyz");

        //base case
        if(digits.length() == 0){
            return new ArrayList<>();
        }

        dfs(digits, 0, digits.length(), "");
        return answer;
    }
}