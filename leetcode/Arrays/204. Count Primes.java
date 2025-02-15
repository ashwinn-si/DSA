class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean arr[] = new boolean[n];
        // false -> prime number
        // true -> not primeNumber
        int counter = 2;
        arr[0] = true; arr[1] = true;
        int resCount = 0;
        while(counter < n){
            while(counter < n && arr[counter]) counter++;
            int currCounter  = counter * 2;
            while(currCounter < n){
                arr[currCounter] = true;
                currCounter += counter;
            } 
            counter++;
        }
        for(int i = 0 ; i < n ; i++){
            if(!arr[i]) resCount++;
        }
        return resCount;
    }
}