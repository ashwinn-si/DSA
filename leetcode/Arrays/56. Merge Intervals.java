class Solution {
    public int[][] merge(int[][] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        int pointer = 0;
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                result.add(new ArrayList<>(Arrays.asList(nums[0][0], nums[0][1])));
                continue;
            }
            if (result.get(pointer).get(1) >= nums[i][0]) {
                result.get(pointer).set(1, Math.max(nums[i][1], result.get(pointer).get(1)));
                result.get(pointer).set(0, Math.min(nums[i][0], result.get(pointer).get(0)));
            } else {
                result.add(new ArrayList<>(Arrays.asList(nums[i][0], nums[i][1])));
                pointer++;
            }
        }
        len = result.size();
        int returnResult[][] = new int[len][2];
        for (int i = 0; i < len; i++) {
            returnResult[i][0] = result.get(i).get(0);
            returnResult[i][1] = result.get(i).get(1);
        }
        return returnResult;
    }
}