class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 1; j < col; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        for(int start = 0; start < col; start++){
            for(int end = start; end < col; end++){
                int subMatrixSum = 0;
                
                Map<Integer, Integer> countElm = new HashMap<Integer, Integer>();
                countElm.put(0,1);
                
                for(int k = 0; k < row; k++){
                    int prefixSum = start == 0 ? 0:matrix[k][start-1];
                    subMatrixSum += matrix[k][end] - prefixSum;
                    
                    if(countElm.containsKey(subMatrixSum - target))
                        res += countElm.get(subMatrixSum - target);
                    
                    int r = countElm.getOrDefault(subMatrixSum, 0);
                    countElm.put(subMatrixSum, r+1);
                }
            }
        }
        
        return res;
    }
}
