class Solution {
    public int compareVersion(String version1, String version2) {
        int pointer1 = 0;
        int pointer2 = 0;
        int n1 = version1.length();
        int n2 = version2.length();
        int v1  = 0;
        int v2 = 0;
        while(pointer1 < n1 || pointer2 < n2){
            while(pointer1 < n1 && version1.charAt(pointer1) == '0'){
                pointer1++;
            }
            while(pointer2 < n2 && version2.charAt(pointer2) == '0'){
                pointer2++;
            }
            while(pointer1 < n1 && version1.charAt(pointer1) != '.'){
                    v1 = v1*10 + (version1.charAt(pointer1) - '0');
                    pointer1++;
            }pointer1++;
            while(pointer2 < n2 && version2.charAt(pointer2) != '.'){
                    v2 = v2*10 + (version2.charAt(pointer2) - '0');
                    pointer2++;
            }pointer2++;
            if(v1 > v2){
                return 1;
            }
            if(v1 < v2){
                return -1;
            }
        }
        
        
        return 0;
    }
}