class Solution {
    private boolean isValid(int n){
        return ((int)((Math.log10(n) + 1)) % 2 == 0);
    }

    private int sumDigits(int n){
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private boolean isSymmentric(int n){
        int len =(int)((Math.log10(n)) + 1) ;
        return (sumDigits(n % (int)(Math.pow(10, len / 2))) == sumDigits(n / (int)(Math.pow(10, len / 2))));
    }

    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int num = low; num <= high ; num++){
            // break;
            if(isValid(num) && isSymmentric(num)){
                count++;
            }
        }
        return count;
    }
}