class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int N1 = s1.length() , N2 = s2.length(), reqSwaps = 0, countChar = 0;
        char misMatchingChar[] = new char[4];
        if(N1 != N2) return false;
        for(int i = 0 ; i < N1 ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                reqSwaps++;
                if(reqSwaps > 2) return false;
                misMatchingChar[countChar] = s1.charAt(i);
                misMatchingChar[countChar+1] = s2.charAt(i);
                countChar += 2;
            }
        }
        return misMatchingChar[0] == misMatchingChar[3] && misMatchingChar[1] == misMatchingChar[2];
    }
}