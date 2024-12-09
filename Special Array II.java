class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;
        boolean[] ans=new boolean[m];

        int[] preSum=new int[n];
        int cnt=0;
        for(int i=1; i<n; i++){
            
            if( nums[i-1]%2 != nums[i]%2 ){
                cnt++;
            }
            preSum[i]=cnt;
        }


        for(int i=0; i<m; i++){
            ans[i]=true;           
            if(preSum[queries[i][1]]-preSum[queries[i][0]] != queries[i][1]-queries[i][0] ){ 
                ans[i]=false;                                
            }            
        }

        return ans;
    }
}
