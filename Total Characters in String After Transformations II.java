class Solution {
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        final int MOD = 1_000_000_007;
        long transformations = t;
        
        long[][] transformMatrix = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < nums.get(i); j++) {
                int nextChar = (i + j + 1) % 26;
                transformMatrix[i][nextChar]++;
            }
        }
        
        long[][] resultMatrix = matrixPower(transformMatrix, transformations, MOD);
        
        long totalLength = 0;
        for (char c : s.toCharArray()) {
            int charIndex = c - 'a';
            
            long charContribution = 0;
            for (int i = 0; i < 26; i++) {
                charContribution = (charContribution + resultMatrix[charIndex][i]) % MOD;
            }
            
            totalLength = (totalLength + charContribution) % MOD;
        }
        
        return (int) totalLength;
    }
    
    private long[][] multiplyMatrix(long[][] A, long[][] B, int MOD) {
        int n = A.length;
        long[][] result = new long[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        
        return result;
    }
    
    private long[][] matrixPower(long[][] matrix, long power, int MOD) {
        int n = matrix.length;
        long[][] result = new long[n][n];
        
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }
        
        while (power > 0) {
            if (power % 2 == 1) {
                result = multiplyMatrix(result, matrix, MOD);
            }
            matrix = multiplyMatrix(matrix, matrix, MOD);
            power /= 2;
        }
        
        return result;
    }
}
