class ProductOfNumbers {
    private ArrayList<Integer> nums;
    int N;
    public ProductOfNumbers() {
        initialize();
    }
    private void initialize(){
        nums = new ArrayList<>(Arrays.asList(1));
        N = 1;
    }
    public void add(int num) {
        if(num == 0){
            initialize();
        }else{
            nums.add(nums.get(N - 1) * num);
            N++;
        }
    }
    
    public int getProduct(int K) {
        return K >= N ? 0 : (nums.get(N-1) / nums.get(N-1-K));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */