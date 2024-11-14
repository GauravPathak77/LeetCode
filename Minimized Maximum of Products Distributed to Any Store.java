class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = getMax(quantities);
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(quantities, n, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean canDistribute(int[] quantities, int n, int maxPerStore) {
        int requiredStores = 0;
        
        for (int quantity : quantities) {
            requiredStores += (quantity + maxPerStore - 1) / maxPerStore;
            if (requiredStores > n) {
                return false;
            }
        }
        
        return requiredStores <= n;
    }
    
    private int getMax(int[] quantities) {
        int max = 0;
        for (int quantity : quantities) {
            max = Math.max(max, quantity);
        }
        return max;
    }
}
