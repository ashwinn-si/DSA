class Solution {
    public int[] findEvenNumbers(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int N = nums.length;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                for (int k = 0; k < N; k++) {
                    if (k == i || k == j) continue;

                    int a = nums[i], b = nums[j], c = nums[k];
                    int num = a * 100 + b * 10 + c;

                    if (a != 0 && num % 2 == 0) {
                        set.add(num);
                    }
                }
            }
        }
        
        int[] result = new int[set.size()];
        int idx = 0;
        for (int val : set) {
            result[idx++] = val;
        }
        return result;
    }
}
