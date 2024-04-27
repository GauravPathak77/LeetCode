import java.util.*;

class Solution {
    public int findRotateSteps(String ring, String key) {
        char[] r = ring.toCharArray();
        List<Integer>[] positions = new List[26];
        
        for (int i = 0; i < r.length; i++) {
            int c = r[i] - 'a';
            if (positions[c] == null) positions[c] = new ArrayList<>();
            positions[c].add(i);
        }
        
        int[][] dp = new int[key.length()][r.length];
        
        return helper(0, 0, positions, key.toCharArray(), r, dp);
    }
    
    int helper(int index, int pos, List<Integer>[] positions, char[] key, char[] ring, int[][] dp) {
        if (index == key.length) return 0;
        
        if (dp[index][pos] > 0) return dp[index][pos];
        
        char target = key[index];
        List<Integer> possiblePositions = positions[target - 'a'];
        
        int minSteps = Integer.MAX_VALUE;
        
        for (int nextPos : possiblePositions) {
            int steps = Math.min(Math.abs(nextPos - pos), ring.length - Math.abs(nextPos - pos));
            
            int totalSteps = steps + helper(index + 1, nextPos, positions, key, ring, dp);
            
            minSteps = Math.min(minSteps, totalSteps);
        }
        
        return dp[index][pos] = minSteps + 1;
    }
}
