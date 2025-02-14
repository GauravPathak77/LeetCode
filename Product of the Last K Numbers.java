class ProductOfNumbers {
    List<Integer> streamInt;

    public ProductOfNumbers() {
        streamInt = new ArrayList<>();
    }
    
    public void add(int num) {
        streamInt.add(num);
    }
    
    public int getProduct(int k) {
        int n = streamInt.size();
        if(n < k) return 0;
        int prod = 1;

        while(k > 0) {
            prod *= streamInt.get(n-k);
            k--;
        }

        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
