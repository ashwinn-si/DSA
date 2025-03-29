class Solution {
    public int reverse(int N) {
        long result = 0;
        while (N != 0) {
            result = (result * 10) + (N % 10);
            N /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;

    }
}