class NumArray {
    private int log[];
    private int N;
    private int R, C;
    private int sTable[][];

    private void buildSparseTable(int nums[]){
        this.sTable = new int[R][C];
        //base case
        for(int index = 0; index < N; index++){
            sTable[0][index] = nums[index]; 
        }

        //main case
        for(int row = 1; row < R; row++){
            int valid = (1 << row);
            int range  = (1 << (row - 1));
            for(int col = 0; col + valid <= C; col++){
                sTable[row][col] = sTable[row - 1][col] + sTable[row - 1][col + range];
            } 
        }
    }

    
    private void buildLog(){
        this.log = new int[this.N + 1];
        for(int index = 2; index <= N; index++) this.log[index] = this.log[index / 2] + 1;
    }

    public NumArray(int[] nums) {
        this.N = nums.length;
        buildLog();
        this.R = this.log[N] + 1;
        this.C = N;
        buildSparseTable(nums);
    }
    
    public int sumRange(int left, int right) {
        int result = 0;
        int range = right - left + 1;
        while(range > 0){
            int level = log[range];
            result += this.sTable[level][left];
            left += (1 << level);
            range -= (1 << level);
        }
        return result;
    }
}
