class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
         int[] leftCandy = new int[n];
        int[] rightCandy=new int[n];
        Arrays.fill(leftCandy,1);
        Arrays.fill(rightCandy,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                leftCandy[i]=leftCandy[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                rightCandy[i]=rightCandy[i+1]+1;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.max(leftCandy[i],rightCandy[i]);
        }
        return ans;
    }
}
