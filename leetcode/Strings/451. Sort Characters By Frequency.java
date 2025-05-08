class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int len = s.length();
        for(int i = 0 ; i < len ; i++){
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue< Pair > pq = new PriorityQueue<>((a, b)-> b.count - a.count);
        for(char ch: hash.keySet()){
            pq.offer(new Pair(ch, hash.get(ch)));
        }
        StringBuffer res = new StringBuffer();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(int i = 0 ; i < p.count ; i++){
                res.append(p.ch);
            }
        }
        return res.toString();
    }
}
class Pair{
    char ch;
    int count;
    Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}