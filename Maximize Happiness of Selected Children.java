class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        int n = happiness.length;
        List<Integer> happinessList = new ArrayList<>();
        
        for (int i = 0 ; i < n ; i++) happinessList.add(happiness[i]);
        
        Collections.sort(happinessList, (a, b) -> (b - a));
        
        long maxHappiness = 0;
        
        for (int i = 0 ; i < k ; i++) {
            maxHappiness += Math.max(happinessList.get(i)-i, 0);
        }
        
        return maxHappiness;
    }
}
