class Solution {
    public int pivotInteger(int n) {
        int leftSum[] = new int[n];
        int rightSum[] = new int[n];

        for(int i=0, j=n-1; i<n; i++, j--){
            if(i == 0){
                leftSum[i] = 1;
                rightSum[n-1] = n;
            } else{
                leftSum[i] = leftSum[i-1] + i+1;
                rightSum[j] = rightSum[j+1] + j+1;
            }
        }

        for(int i=0; i<n; i++){
            if(leftSum[i] == rightSum[i]){
                return i+1;
            }
        }
        return -1;
    }
}
