class Solution {
    public List<String> removeAnagrams(String[] words) {
        int N = words.length;
        List<HashMap<Character, Integer>> arr = new ArrayList<>();
        for(String str: words){
            HashMap<Character, Integer> hash = new HashMap<>();
            for(char ch: str.toCharArray()){
                hash.put(ch, hash.getOrDefault(ch, 0) + 1);
            }
            arr.add(hash);
        }
        List<String> answer = new ArrayList<>();
        answer.add(words[0]);

        for(int index = 1; index < N; index++){
            if(!arr.get(index).equals(arr.get(index - 1))){
                answer.add(words[index]);
            }
        }
        return answer;
    }
}