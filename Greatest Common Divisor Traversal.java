class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        if(nums.length == 1) return true;
        int n = nums.length;
        int maxElement = Arrays.stream(nums).max().getAsInt();
        if(Arrays.stream(nums).min().getAsInt() == 1) return false;
        int[] factorArray = calculatePrimeFactors(maxElement);
        
        int[] parent = new int[maxElement + 1];
        int[] rank = new int[maxElement + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int num : nums) {
            int current = num;
            while (current > 1) {
                int factor = factorArray[current];
                union(parent, rank, factor, num);
                while (current % factor == 0) {
                    current = current / factor;
                }
            }
        }

        int representative = find(parent, nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (find(parent, nums[i]) != representative) return false;
        }

        return true;
    }

    private int[] calculatePrimeFactors(int n) {
        int[] factors = new int[n + 2];
        for (int i = 0; i < factors.length; i++) {
            factors[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (factors[i] == i) {
                for (int j = i * 2; j <= n; j += i) {
                    if (factors[j] == j) factors[j] = i;
                }
            }
        }
        return factors;
    }

    private int find(int[] parent, int element) {
        return parent[element] = (parent[element] == element) ? element : find(parent, parent[element]);
    }

    private void union(int[] parent, int[] rank, int elementA, int elementB) {
        elementA = find(parent, elementA);
        elementB = find(parent, elementB);
        if (elementA == elementB) return;
        if (rank[elementA] < rank[elementB]) {
            int temp = elementA;
            elementA = elementB;
            elementB = temp;
        }
        parent[elementB] = elementA;
        rank[elementA] += rank[elementB];
    }
}
