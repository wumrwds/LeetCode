class ProductOfNumbers {

    private List<Integer> prefixProduct = new ArrayList<>();
    
    public ProductOfNumbers() {
        prefixProduct.add(1);
    }
    
    public void add(int num) {
        if (num != 0) {
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        }
        else {
            prefixProduct.clear();
            prefixProduct.add(1);
        }
    }
    
    public int getProduct(int k) {
        if (prefixProduct.size() - 1 - k < 0) {
            return 0;
        }
        
        return prefixProduct.get(prefixProduct.size() - 1) / prefixProduct.get(prefixProduct.size() - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */